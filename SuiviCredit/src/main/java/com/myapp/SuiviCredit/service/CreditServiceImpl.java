package com.myapp.SuiviCredit.service;

import com.myapp.SuiviCredit.dto.CreditDto;
import com.myapp.SuiviCredit.dto.CreditMapper;
import com.myapp.SuiviCredit.entities.*;
import com.myapp.SuiviCredit.enumeration.StatutCredit;
import com.myapp.SuiviCredit.repository.*;
import com.myapp.SuiviCredit.util.EcheanceCalculator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {
    private final CreditRepository creditRepo;
    private final ClientRepository clientRepo;
    private final AgentRepository agentRepo;
    private final EcheanceRepository echeanceRepo;

    @Override
    @Transactional
    public void ajouterCredit(CreditDto dto) {
        // Récupération client et agent par leurs identifiants lisibles (CIN, matricule)
        Client client = clientRepo.findByCin(dto.getClientCin())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        Agent agent = agentRepo.findByMatricule(dto.getAgentMatricule())
                .orElseThrow(() -> new RuntimeException("Agent non trouvé"));

        // Création de l'objet crédit
        Credit credit = CreditMapper.toEntity(dto, client, agent);
        credit.setStatut(StatutCredit.EN_COURS);

        // Sauvegarde du crédit (pour obtenir l'ID)
        final Credit savedCredit = creditRepo.save(credit);

        // Génération des échéances
        List<Echeance> echeances = EcheanceCalculator.genererEcheances(
                dto.getMontant(),
                dto.getDureeMois(),
                dto.getTauxInteret()
        );

        // Liaison du crédit à chaque échéance
        echeances.forEach(e -> e.setCredit(savedCredit));

        // Sauvegarde des échéances
        echeanceRepo.saveAll(echeances);
    }

    @Override
    public void supprimerCredit(Long creditId) {
        creditRepo.deleteById(creditId); // CascadeType.ALL dans l'entité supprime les échéances
    }

    @Override
    public void verifierEtMettreAJourStatut() {
        for (Credit credit : creditRepo.findAll()) {
            boolean tousPayes = credit.getEcheances().stream()
                    .allMatch(Echeance::isPaye);

            boolean enRetard = credit.getEcheances().stream()
                    .anyMatch(e -> !e.isPaye() && e.getDatePaiement().isBefore(LocalDate.now()));

            if (tousPayes) {
                credit.setStatut(StatutCredit.TERMINE);
            } else if (enRetard) {
                credit.setStatut(StatutCredit.EN_RETARD);
            } else {
                credit.setStatut(StatutCredit.EN_COURS);
            }

            creditRepo.save(credit);
        }
    }

    @Override
    public List<CreditDto> getCreditsByClientCin(String cin) {
        return creditRepo.findByClientCin(cin)
                .stream()
                .map(CreditMapper::toDto)
                .toList();
    }

}