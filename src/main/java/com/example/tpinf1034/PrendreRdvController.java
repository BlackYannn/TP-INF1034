package com.example.tpinf1034;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import javafx.scene.control.ToggleGroup;

public class PrendreRdvController {
    public RadioButton radioOption1;
    public RadioButton radioOption2;
    public RadioButton radioOption3;
    public RadioButton radioOption4;
    private ToggleGroup toggleGroupSex;
    private ToggleGroup toggleGroupUrgent;

    @FXML
    public void initialize() {
        // Créer un ToggleGroup
        toggleGroupSex = new ToggleGroup();
        toggleGroupUrgent = new ToggleGroup();
        // Associer le ToggleGroup aux deux boutons radio
        radioOption1.setToggleGroup(toggleGroupSex);
        radioOption2.setToggleGroup(toggleGroupSex);
        radioOption3.setToggleGroup(toggleGroupUrgent);
        radioOption4.setToggleGroup(toggleGroupUrgent);
    }

    public void fermerFenetre(ActionEvent event) {
        try {
            // Charger la nouvelle fenêtre
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainView.fxml"));
            Scene newScene = new Scene(fxmlLoader.load());

            // Créer une nouvelle fenêtre (Stage)
            Stage newStage = new Stage();
            newStage.setTitle("Gestion Hopital");
            newStage.setScene(newScene);
            newStage.show();

            // Fermer l'ancienne fenêtre
            Stage oldStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            // Afficher une alerte en cas d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Impossible d'ouvrir la nouvelle fenêtre");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void reserverRendezVous(ActionEvent event) {
        // Création de la boîte de dialogue de confirmation
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmer la réservation");
        alert.setContentText("Êtes-vous sûr de vouloir réserver ce rendez-vous ?");

        // Affichage et attente de la réponse
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            // L'utilisateur a confirmé
            System.out.println("Rendez-vous réservé !");
            // TODO : Ajouter la logique pour enregistrer le rendez-vous ici
        } else {
            // L'utilisateur a annulé
            System.out.println("Réservation annulée.");
        }
    }
}
