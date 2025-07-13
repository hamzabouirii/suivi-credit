package com.myapp.SuiviCredit.entities;

import com.myapp.SuiviCredit.entities.Credit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Echeance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate datePaiement;
    private double montant;
    private boolean paye;
    private boolean enRetard;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;
}
