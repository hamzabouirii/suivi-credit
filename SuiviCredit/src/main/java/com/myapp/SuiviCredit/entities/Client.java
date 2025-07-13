package com.myapp.SuiviCredit.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User {

    @Column(unique = true)
    private String cin;

    private String telephone;
    private String adresse;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Credit> credits;
}
