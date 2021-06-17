package fr.fares.zoo.employe;

import fr.fares.zoo.Animal;

public class Soigneur extends Employe{

    private Animal typeAnimal;

    public Soigneur(String nom, Animal typeAnimal) {
        super(nom, Profession.SOIGNEUR);
        this.typeAnimal = typeAnimal;
    }

    public Animal getTypeAnimal() {
        return typeAnimal;
    }

    public void soigner(Animal animal) {
        if (animal.equals(typeAnimal)) {
            System.out.println( super.getNom() + " a soigné : " + animal.getNom());
        } else {
            System.out.println(super.getNom() + " ne peut soigner que l'espèce : " + typeAnimal.getNom());
        }
    }
}
