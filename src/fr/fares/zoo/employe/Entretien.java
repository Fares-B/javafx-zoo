package fr.fares.zoo.employe;

import fr.fares.zoo.Habitat;

public class Entretien extends Employe {

    public Entretien(String nom) {
        super(nom, Profession.ENTRETIEN);
    }

    public void nettoyer(Habitat habitat) {
        System.out.println(this.getNom() + " nettoie " + habitat.getEnvironnement().getNom());
    }

}
