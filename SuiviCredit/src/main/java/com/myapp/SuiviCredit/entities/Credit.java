package com.myapp.SuiviCredit.entities;

import com.myapp.SuiviCredit.entities.Agent;
import com.myapp.SuiviCredit.enumeration.StatutCredit;
import com.myapp.SuiviCredit.enumeration.TypeCredit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;
    private int dureeMois;
    private double tauxInteret;

    @Enumerated(EnumType.STRING)
    private TypeCredit type;

    @Enumerated(EnumType.STRING)
    private StatutCredit statut;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    private List<Echeance> echeances;
}
