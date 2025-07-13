package com.myapp.SuiviCredit.controller;

import com.myapp.SuiviCredit.dto.AgentDto;
import com.myapp.SuiviCredit.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService agentService;

    @PostMapping
    public AgentDto create(@RequestBody AgentDto dto) {
        return agentService.createAgent(dto);
    }

    @PutMapping("/{id}")
    public AgentDto update(@PathVariable Long id, @RequestBody AgentDto dto) {
        return agentService.updateAgent(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        agentService.deleteAgent(id);
    }

    @GetMapping("/{id}")
    public AgentDto getById(@PathVariable Long id) {
        return agentService.getAgentById(id);
    }

    @GetMapping
    public List<AgentDto> getAll() {
        return agentService.getAllAgents();
    }
}
