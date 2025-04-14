package com.example.tpinf1034;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class GestionCarteAccesController {
    @FXML
    private RadioButton radioActive;

    @FXML
    private RadioButton radioExpiree;

    @FXML
    private RadioButton radioSuspendue;

    ToggleGroup statusGroup;


    private ToggleGroup toggleGroupStatus;

    @FXML
    public void initialize() {
        statusGroup = new ToggleGroup();
        radioActive.setToggleGroup(statusGroup);
        radioExpiree.setToggleGroup(statusGroup);
        radioSuspendue.setToggleGroup(statusGroup);
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
            System.out.println("Carte enregistrée !");
            afficherSucces("La carte a été enregistrée avec succès !");
        }
    }

    public void confirmerReinitialisation(ActionEvent event) {
        if (afficherConfirmation("Voulez-vous réinitialiser les champs ?")) {
            System.out.println("Champs réinitialisés !");
            afficherSucces("Les champs ont été réinitialisés.");
        }
    }

    public void confirmerSuppression(ActionEvent event) {
        if (afficherConfirmation("Êtes-vous sûr de vouloir supprimer cette carte ?")) {
            System.out.println("Carte supprimée !");
            afficherSucces("La carte a été supprimée.");
        }
    }

    public void confirmerImpression(ActionEvent event) {
        if (afficherConfirmation("Imprimer le badge maintenant ?")) {
            System.out.println("Badge imprimé !");
            afficherSucces("Le badge a été imprimé.");
        }
    }

    public void confirmerDesactivation(ActionEvent event) {
        if (afficherConfirmation("Désactiver l'accès de cette carte ?")) {
            System.out.println("Accès désactivé !");
            afficherSucces("L'accès de la carte a été désactivé.");
        }
    }

    // Méthode de confirmation personnalisée avec boutons Valider et Annuler
    private boolean afficherConfirmation(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(message);

        ButtonType buttonValider = new ButtonType("Valider");
        ButtonType buttonAnnuler = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonValider, buttonAnnuler);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == buttonValider;
    }

    // Méthode pour afficher un message de succès
    private void afficherSucces(String message) {
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Succès");
        success.setHeaderText(null);
        success.setContentText(message);
        success.showAndWait();
    }

}
