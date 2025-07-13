package com.myapp.SuiviCredit.service;

import com.myapp.SuiviCredit.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto clientDto);
    ClientDto update(Long id, ClientDto clientDto);
    void delete(Long id);
    ClientDto getById(Long id);
    List<ClientDto> getAll();
}
