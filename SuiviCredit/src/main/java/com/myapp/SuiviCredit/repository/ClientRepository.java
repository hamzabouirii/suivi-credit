package com.myapp.SuiviCredit.repository;

import com.myapp.SuiviCredit.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByAgentId(Long agentId);
    Optional<Client> findByCin(String cin);// pour lister les clients d’un agent
}

