package com.myapp.SuiviCredit.entities;

import com.myapp.SuiviCredit.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agent extends User {

    @Column(unique = true)
    private String matricule;

    private String agence;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<Credit> creditsGeres;

    @OneToMany(mappedBy = "agent")
    private List<Client> listClients;
}
