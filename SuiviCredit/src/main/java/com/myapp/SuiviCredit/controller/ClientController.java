package com.myapp.SuiviCredit.controller;

import com.myapp.SuiviCredit.dto.ClientDto;
import com.myapp.SuiviCredit.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientDto createClient(@RequestBody ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @PutMapping("/{id}")
    public ClientDto updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        return clientService.update(id, clientDto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.delete(id);
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.getAll();
    }
}
