package com.myapp.SuiviCredit.util;

import com.myapp.SuiviCredit.entities.Echeance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EcheanceCalculator {

    public static List<Echeance> genererEcheances(double montant, int duree, double taux) {
        List<Echeance> liste = new ArrayList<>();
        double mensualite = (montant * taux / 12) / (1 - Math.pow(1 + taux / 12, -duree));
        LocalDate date = LocalDate.now();

        for (int i = 0; i < duree; i++) {
            Echeance e = new Echeance();
            e.setDatePaiement(date.plusMonths(i + 1));
            e.setMontant(mensualite);
            e.setPaye(false);
            e.setEnRetard(false);
            liste.add(e);
        }

        return liste;
    }
}
