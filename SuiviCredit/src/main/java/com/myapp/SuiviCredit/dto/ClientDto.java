package com.myapp.SuiviCredit.dto;
import lombok.Data;


@Data
public class ClientDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
    private Boolean actif;
    private String cin;
}
