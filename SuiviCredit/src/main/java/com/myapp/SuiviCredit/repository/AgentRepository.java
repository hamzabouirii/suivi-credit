package com.myapp.SuiviCredit.repository;
import com.myapp.SuiviCredit.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface AgentRepository extends JpaRepository<Agent, Long> {
    Optional<Agent> findById(Long id);
    Optional<Agent> findByMatricule(String matricule);

}


