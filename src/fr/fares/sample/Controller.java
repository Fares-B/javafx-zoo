package fr.fares.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import fr.fares.zoo.Animal;
import fr.fares.zoo.Environnement;
import fr.fares.zoo.Habitat;
import fr.fares.zoo.Zoo;
import fr.fares.zoo.employe.Employe;
import fr.fares.zoo.employe.Entretien;
import fr.fares.zoo.employe.Profession;
import fr.fares.zoo.employe.Soigneur;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private Zoo zoo;

    /* HABITAT */
    @FXML private ChoiceBox<Environnement> choiceBoxHabitats;
    @FXML private ListView<Habitat> habitatListView;
    @FXML private Label habitatInfoLabel;
    /* EMPLOYES */
    @FXML private TextField ajouterEmployeNomTextField;
    @FXML private ChoiceBox<Profession> selectProfessionEmployeChoiceBox;
    @FXML private ListView<Employe> employesListView;

    /* STATS */
    @FXML private Label nombreTotalAnimaux;
    @FXML private Label nombreTotalHabitats;
    @FXML private ListView<String> statsAnimauxListView;
    @FXML private ListView<String> statsEmployeListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.zoo = new Zoo();
        rechargerHabitatChoiceBox();
        rechargerProfessionChoiceBox();
        rechargerStatistique();
    }

    public void rechargerStatistique() {
        /* EMPLOYES */
        Random rand = new Random();
        final int minimum = 0;
        final int maximum = 9;
        int cpt = zoo.getEmployes().size();
        for (int i = 0; i < 5; i++)
            zoo.ajouterEmploye(new Entretien("Jean-" + ++cpt));
        for (Animal animal: Animal.values()) {
            zoo.ajouterEmploye(new Soigneur("M.Soigneur-"+ ++cpt, animal));
        }
        /* Habitats */
        for (Environnement env : Environnement.values()) {
            Habitat habitat = new Habitat(env);

            /* Animaux */
            for (int i = 0; i < habitat.getPlacesTotal() - (minimum + rand.nextInt((maximum - minimum) + 1)); i++) {
                for (Animal animal : Animal.values()) {
                    habitat.ajouterUnAnimal(animal);
                }
            }
            zoo.ajouterHabitat(habitat);
        }

        int nombresAnimaux = zoo.getAnimaux().size();
        statsAnimauxListView.getItems().add("Animaux total    " + nombresAnimaux);
        for (Animal animal : Animal.values()) {
            float pourcentage = (float) zoo.getAnimauxPar(animal).size() * 100 / nombresAnimaux;
            statsAnimauxListView.getItems().add(animal.toString() + "    " + pourcentage + "%");
        }

        int nombresEmployes = zoo.getEmployes().size();
        statsEmployeListView.getItems().add("Employés total    " + nombresEmployes);
        for (Profession prof : Profession.values()) {
            float pourcentage = (float) zoo.getEmployesPar(prof).size()*100/nombresEmployes;
            statsEmployeListView.getItems().add(prof.toString() + "    " + pourcentage + "%");
        }

    }

    public void rechargerProfessionChoiceBox() {
        selectProfessionEmployeChoiceBox.setValue(Profession.values()[0]);
        for (Profession profession : Profession.values()) {
            selectProfessionEmployeChoiceBox.getItems().add(profession);
        }
    }

    public void ajouterEmploye(ActionEvent event) {
        String nom = ajouterEmployeNomTextField.getText();
        Employe employe = null;
        switch (selectProfessionEmployeChoiceBox.getValue()) {
            case SOIGNEUR:
                employe = new Soigneur(nom, Animal.SINGE);
                break;
            case ENTRETIEN:
                employe = new Entretien(nom);
                break;

        }
        this.zoo.ajouterEmploye(employe);
        employesListView.getItems().add(employe);
    }

    public void rechargerHabitatChoiceBox() {
        choiceBoxHabitats.setValue(Environnement.values()[0]);
        for (Environnement env : Environnement.values()) {
            choiceBoxHabitats.getItems().add(env);
        }
    }

//    CHARGEMENT DES DATAS SAVE
//    private void rechargerHabitatListView() {
//        habitatListView.getItems().addAll();
//    }

    public void ajouterHabitat(ActionEvent event) {
        Habitat habitat = new Habitat((Environnement) choiceBoxHabitats.getValue());
        this.zoo.ajouterHabitat(habitat);
        for (Animal animal: Animal.values()) {
            habitat.ajouterUnAnimal(animal);
        }
        habitatListView.getItems().add(habitat);
//
//        statsHabitatsCol.setCellValueFactory(new PropertyValueFactory<Habitat, Environnement>("environnement"));
//        statsHabitatTableView.setItems(<Habitat> fr.fares.zoo.getHabitats());
    }

    public void afficherHabitatInfoListView(MouseEvent event) {
        Habitat habitat = habitatListView.getSelectionModel().getSelectedItem();
        habitatInfoLabel.setText("Environnement : " + habitat.getEnvironnement().getNom() + "\n" +
                "places total : " + habitat.getPlacesTotal() + "\n" +
                "places restantes : " + habitat.getPlacesRestantes() + "\n");
    }

}
