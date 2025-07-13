package com.myapp.SuiviCredit.service;

import com.myapp.SuiviCredit.dto.AgentDto;
import com.myapp.SuiviCredit.dto.AgentMapper;
import com.myapp.SuiviCredit.entities.Agent;
import com.myapp.SuiviCredit.repository.AgentRepository;
import com.myapp.SuiviCredit.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;

    @Override
    public AgentDto createAgent(AgentDto dto) {
        Agent agent = AgentMapper.toEntity(dto);
        return AgentMapper.toDto(agentRepository.save(agent));
    }

    @Override
    public AgentDto updateAgent(Long id, AgentDto dto) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent not found"));
        if (dto.getNom() != null) agent.setNom(dto.getNom());
        if (dto.getPrenom() != null) agent.setPrenom(dto.getPrenom());
        if (dto.getEmail() != null) agent.setEmail(dto.getEmail());
        if (dto.getAgence() != null) agent.setAgence(dto.getAgence());
        if (dto.getMatricule() != null) agent.setMatricule(dto.getMatricule());
        agent.setActif(dto.isActif());
        return AgentMapper.toDto(agentRepository.save(agent));
    }

    @Override
    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }

    @Override
    public AgentDto getAgentById(Long id) {
        return agentRepository.findById(id)
                .map(AgentMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Agent not found"));
    }

    @Override
    public List<AgentDto> getAllAgents() {
        return agentRepository.findAll()
                .stream()
                .map(AgentMapper::toDto)
                .collect(Collectors.toList());
    }
}
