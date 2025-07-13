package com.myapp.SuiviCredit.dto;

import lombok.Data;

@Data
public class AgentDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String agence;
    private String matricule;
    private boolean actif;
}
