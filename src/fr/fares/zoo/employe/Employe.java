package fr.fares.zoo.employe;

import fr.fares.zoo.Animal;

public class Employe {
    private String nom;
    private Profession metier;

    public Employe(String nom, Profession metier) {
        this.nom = nom;
        this.metier = metier;
    }

    public String getNom() {
        return nom;
    }

    public Profession getMetier() {
        return metier;
    }

    public void nourrir(Animal animal) {
        System.out.println(this.nom + " nourri " + animal.getNom());
    }

    @Override
    public String toString() {
        return "Nom : " + nom + ", metier : " + metier;
    }
}
