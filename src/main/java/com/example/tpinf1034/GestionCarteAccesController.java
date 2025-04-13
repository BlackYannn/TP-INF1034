package com.example.tpinf1034;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class GestionCarteAccesController {
    public RadioButton radioOptionGesCar1;
    public RadioButton radioOptionGesCar2;


    private ToggleGroup toggleGroupStatus;

    @FXML
    public void initialize() {
        // Créer un ToggleGroup
        toggleGroupStatus = new ToggleGroup();
        // Associer le ToggleGroup aux deux boutons radio
        radioOptionGesCar1.setToggleGroup(toggleGroupStatus);
        radioOptionGesCar1.setToggleGroup(toggleGroupStatus);
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


    public void confirmerEnregistrement(ActionEvent event) {
        if (afficherConfirmation("Voulez-vous vraiment enregistrer cette carte ?")) {
            // Logique d'enregistrement ici
            System.out.println("Carte enregistrée !");
        }
    }

    public void confirmerReinitialisation(ActionEvent event) {
        if (afficherConfirmation("Voulez-vous réinitialiser les champs ?")) {
            // Réinitialisation des champs
            System.out.println("Champs réinitialisés !");
        }
    }

    public void confirmerSuppression(ActionEvent event) {
        if (afficherConfirmation("Êtes-vous sûr de vouloir supprimer cette carte ?")) {
            System.out.println("Carte supprimée !");
        }
    }

    public void confirmerImpression(ActionEvent event) {
        if (afficherConfirmation("Imprimer le badge maintenant ?")) {
            System.out.println("Badge imprimé !");
        }
    }

    public void confirmerDesactivation(ActionEvent event) {
        if (afficherConfirmation("Désactiver l'accès de cette carte ?")) {
            System.out.println("Accès désactivé !");
        }
    }

    private boolean afficherConfirmation(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }
}
