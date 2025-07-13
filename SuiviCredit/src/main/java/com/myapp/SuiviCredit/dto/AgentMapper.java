package com.myapp.SuiviCredit.dto;

import com.myapp.SuiviCredit.entities.Agent;
import com.myapp.SuiviCredit.enumeration.Role;

public class AgentMapper {

    public static AgentDto toDto(Agent agent) {
        AgentDto dto = new AgentDto();
        dto.setId(agent.getId());
        dto.setNom(agent.getNom());
        dto.setPrenom(agent.getPrenom());
        dto.setEmail(agent.getEmail());
        dto.setAgence(agent.getAgence());
        dto.setMatricule(agent.getMatricule());
        dto.setActif(agent.isActif());
        return dto;
    }

    public static Agent toEntity(AgentDto dto) {
        Agent agent = new Agent();
        agent.setId(dto.getId());
        agent.setNom(dto.getNom());
        agent.setPrenom(dto.getPrenom());
        agent.setEmail(dto.getEmail());
        agent.setAgence(dto.getAgence());
        agent.setMatricule(dto.getMatricule());
        agent.setActif(dto.isActif());
        agent.setRole(Role.AGENT);
        return agent;
    }
}
