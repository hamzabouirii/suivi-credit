package com.myapp.SuiviCredit.repository;

import com.myapp.SuiviCredit.entities.Echeance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcheanceRepository extends JpaRepository<Echeance, Long> {
    List<Echeance> findByCreditId(Long creditId);
}

