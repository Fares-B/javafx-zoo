package fr.fares.zoo;

import fr.fares.zoo.employe.Employe;
import fr.fares.zoo.employe.Profession;
import fr.fares.zoo.employe.Soigneur;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    List<Habitat> habitats = new ArrayList<>();
    List<Employe> employes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Bienvenue au fr.fares.zoo-park");

        Zoo zoo = new Zoo();

//        Entretien entretien = new Entretien("Jean");
//        fr.fares.zoo.ajouterEmploye(entretien);
//
//        fr.fares.zoo.licencieEmploye(entretien);
//
//        System.out.println(fr.fares.zoo.employes);
//        fr.fares.zoo.ajouterHabitat(new Habitat(Environnement.CAGE));

//        entretien.nettoyer(fr.fares.zoo.habitats.get(0));


//        fr.fares.zoo.ajouterHabitat(new Habitat(Environnement.CAGE));
//
//        fr.fares.zoo.ajouterEmploye(new Employe("Fares", Metier.SOIGNEUR));
//
    }

    public void licencieEmploye(Employe employe) {
        if (!(employe instanceof Soigneur)) {
            employes.remove(employe);
            System.out.println(employe.getMetier() + ": " + employe.getNom() + " a été licencié.");
        } else {
            int i = 0;
            for (Soigneur soigneur: getSoigneurs()) {
                if (soigneur.getTypeAnimal().getNom().equals( ((Soigneur) employe).getTypeAnimal().getNom() )) {
                    i++;
                }
            }
            if (i>1) {
                employes.remove(employe);
                System.out.println(employe.getMetier() + ": " + employe.getNom() + " a été licencié.");
            }
            else System.out.println("impossible de licencé " + employe.getNom() + " est le seul soigneur pour " + ((Soigneur) employe).getTypeAnimal().getNom());
        }
    }

    public List<Soigneur> getSoigneurs() {
        List<Soigneur> soigneurs = new ArrayList<>();
        employes.forEach(employe -> {
            if (employe instanceof Soigneur )
                soigneurs.add((Soigneur) employe);
        });
        return soigneurs;
    }

    public List<Employe> getEmployesPar(Profession metier) {
        List<Employe> employesTemp = new ArrayList<>();
        this.employes.forEach(employe -> {
            if (employe.getMetier().equals(metier))
                employesTemp.add(employe);
        });
        return employesTemp;
    }

    public List<Animal> getAnimauxPar(Animal animal) {
        List<Animal> animaux = new ArrayList<>();
        for (Habitat habitat: habitats) {
            habitat.getAnimaux().forEach(animal1 -> {
                if (animal1.equals(animal)) {
                    animaux.add(animal1);
                }
            });
        }
        return animaux;
    }

    public List<Animal> getAnimaux() {
        List<Animal> animaux = new ArrayList<>();
        for (Habitat habitat: habitats) {
            animaux.addAll(habitat.getAnimaux());
        }
        return animaux;
    }

    public void ajouterHabitat(Habitat habitat) {
        habitats.add(habitat);
    }

    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
    }

    public int getNombreHabitatDeType(Environnement environnement) {
        int cpt = 0;
        for (Habitat habitat: habitats) {
            if (habitat.getEnvironnement().equals(environnement))
                cpt++;
        }
        return cpt;
    }

    public List<Habitat> getHabitats() {
        return habitats;
    }

    public List<Employe> getEmployes() {
        return employes;
    }
}
