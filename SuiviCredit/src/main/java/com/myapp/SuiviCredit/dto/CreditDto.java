package com.myapp.SuiviCredit.dto;

import com.myapp.SuiviCredit.enumeration.StatutCredit;
import com.myapp.SuiviCredit.enumeration.TypeCredit;
import lombok.Data;

@Data
public class CreditDto {
        private Double montant;
        private int dureeMois;
        private double tauxInteret;
        private TypeCredit type;
        private StatutCredit statut;
        private String clientCin;
        private String agentMatricule;
}
