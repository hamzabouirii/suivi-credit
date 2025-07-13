package com.myapp.SuiviCredit.dto;

import com.myapp.SuiviCredit.entities.Client;
import com.myapp.SuiviCredit.enumeration.Role;

public class ClientMapper {
    public static ClientDto toDto(Client client) {
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setPrenom(client.getPrenom());
        dto.setEmail(client.getEmail());
        dto.setTelephone(client.getTelephone());
        dto.setAdresse(client.getAdresse());
        dto.setActif(client.isActif());
        dto.setCin(client.getCin());
        return dto;
    }

    public static Client toEntity(ClientDto dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setEmail(dto.getEmail());
        client.setTelephone(dto.getTelephone());
        client.setAdresse(dto.getAdresse());
        client.setActif(dto.getActif());
        client.setCin(dto.getCin());
        //client.setMotDePasse("password"); // à crypter plus tard
        client.setRole(Role.CLIENT);


        return client;
    }
}
