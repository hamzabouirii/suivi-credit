package com.myapp.SuiviCredit.controller;

import com.myapp.SuiviCredit.dto.CreditDto;
import com.myapp.SuiviCredit.entities.Credit;
import com.myapp.SuiviCredit.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService creditService;

    @PostMapping
    public void ajouter(@RequestBody CreditDto dto) {
        creditService.ajouterCredit(dto);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        creditService.supprimerCredit(id);
    }

    @PutMapping("/verifier-statut")
    public void verifier() {
        creditService.verifierEtMettreAJourStatut();
    }

    @GetMapping("/client/{cin}")
    public List<CreditDto> getCreditsParClient(@PathVariable String cin) {
        return creditService.getCreditsByClientCin(cin);
    }
}


