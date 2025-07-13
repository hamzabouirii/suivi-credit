package com.myapp.SuiviCredit.service;

import com.myapp.SuiviCredit.dto.CreditDto;
import com.myapp.SuiviCredit.entities.Credit;

import java.util.List;

public interface CreditService {
    void ajouterCredit(CreditDto dto);
    void supprimerCredit(Long creditId);
    void verifierEtMettreAJourStatut();
    List<CreditDto> getCreditsByClientCin(String cin);

}
