package com.myapp.SuiviCredit.service;

import com.myapp.SuiviCredit.dto.ClientDto;
import com.myapp.SuiviCredit.dto.ClientMapper;
import com.myapp.SuiviCredit.entities.Client;

import com.myapp.SuiviCredit.repository.ClientRepository;
import com.myapp.SuiviCredit.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public ClientDto save(ClientDto clientDto) {
        Client client = ClientMapper.toEntity(clientDto);
        return ClientMapper.toDto(clientRepository.save(client));
    }

    @Override
    public ClientDto update(Long id, ClientDto dto) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Mise à jour partielle seulement des champs non-null
        if (dto.getNom() != null) existingClient.setNom(dto.getNom());
        if (dto.getPrenom() != null) existingClient.setPrenom(dto.getPrenom());
        if (dto.getEmail() != null) existingClient.setEmail(dto.getEmail());
        if (dto.getAdresse() != null) existingClient.setAdresse(dto.getAdresse());
        if (dto.getTelephone() != null) existingClient.setTelephone(dto.getTelephone());
        if (dto.getCin() != null) existingClient.setCin(dto.getCin());
        if (dto.getActif() != null) existingClient.setActif(dto.getActif());

        Client saved = clientRepository.save(existingClient);
        return ClientMapper.toDto(saved);
    }


    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDto getById(Long id) {
        return clientRepository.findById(id)
                .map(ClientMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
    }

    @Override
    public List<ClientDto> getAll() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }
}
