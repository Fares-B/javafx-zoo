package fr.fares.zoo;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private final Environnement environnement;
    private List<Animal> animaux = new ArrayList<>();

    public Habitat(Environnement environnement) {
        this.environnement = environnement;
    }

    public boolean ajouterUnAnimal(Animal animal) {
        for (Animal a: animaux) {
            if (a.isSolo() != animal.isSolo())
                return false;
            if (animal.isSolo() && !animal.equals(a)) {
                return false;
            }
        }
        if (getPlacesRestantes() > 0 && animal.getEnvironnement().equals(this.environnement)) {
            return this.animaux.add(animal);
        }
        return false;
    }

    public List<Animal> getAnimaux() {
        return animaux;
    }

    public int getPlacesPrises() {
        return animaux.size();
    }

    public int getPlacesTotal() {
        return environnement.getPlace();
    }

    public int getPlacesRestantes() {
        return environnement.getPlace() - animaux.size();
    }

    public String getAnimauxDescription() {
        String retour = "";
        for (Animal animal: animaux) {
            retour += animal.getDescription() + "; ";
        }
        return retour;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public String getDescription() {
        return this.environnement.getDescription() + "\nplaces restantes='" + getPlacesRestantes() + "'\nanimaux={ " + getAnimauxDescription() + "}";
    }

    public void deplacerAnimalVers(Habitat habitat, Animal animal) {
        if (!animaux.contains(animal))
            return;
        for (Animal a: animaux) {
            if (animal.equals(a)) {
                habitat.ajouterUnAnimal(a);
                animaux.remove(a);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return environnement.getNom();
//        return "Habitat{" +
//                "environnement=" + environnement +
//                ", animaux=" + animaux +
//                '}';
    }
}
