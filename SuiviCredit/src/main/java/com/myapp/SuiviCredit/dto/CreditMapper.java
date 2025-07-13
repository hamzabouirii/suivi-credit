package com.myapp.SuiviCredit.dto;

import com.myapp.SuiviCredit.entities.Agent;
import com.myapp.SuiviCredit.entities.Client;
import com.myapp.SuiviCredit.entities.Credit;

public class CreditMapper {

    public static Credit toEntity(CreditDto dto, Client client, Agent agent) {
        Credit credit = new Credit();
        credit.setMontant(dto.getMontant());
        credit.setDureeMois(dto.getDureeMois());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setType(dto.getType());
        credit.setClient(client);
        credit.setAgent(agent);
        dto.setAgentMatricule(credit.getAgent().getMatricule());
        return credit;
    }
    public static CreditDto toDto(Credit credit) {
        CreditDto dto = new CreditDto();
        dto.setMontant(credit.getMontant());
        dto.setDureeMois(credit.getDureeMois());
        dto.setTauxInteret(credit.getTauxInteret());
        dto.setType(credit.getType());
        dto.setStatut(credit.getStatut());
        if (credit.getClient() != null) {
            dto.setClientCin(credit.getClient().getCin());
        }

        if (credit.getAgent() != null) {
            dto.setAgentMatricule(credit.getAgent().getMatricule());
        }
        return dto;
    }

}
