package com.myapp.SuiviCredit.service;

import com.myapp.SuiviCredit.dto.AgentDto;
import java.util.List;

public interface AgentService {
    AgentDto createAgent(AgentDto dto);
    AgentDto updateAgent(Long id, AgentDto dto);
    void deleteAgent(Long id);
    AgentDto getAgentById(Long id);
    List<AgentDto> getAllAgents();
}
