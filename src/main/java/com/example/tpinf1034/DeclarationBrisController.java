package com.example.tpinf1034;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class DeclarationBrisController {


    public void annuler(ActionEvent event) {
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
    private void enregistrer(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation d'enregistrement");
        alert.setHeaderText("Voulez-vous vraiment enregistrer ce rapport ?");
        alert.setContentText("Cliquez sur Valider pour enregistrer ou Annuler pour revenir.");

        ButtonType buttonValider = new ButtonType("Valider");
        ButtonType buttonAnnuler = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonValider, buttonAnnuler);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonValider) {
            // Ici tu mets la logique d'enregistrement
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Enregistrement réussi");
            success.setHeaderText(null);
            success.setContentText("Le rapport a été enregistré avec succès !");
            success.showAndWait();
        } else {
            System.out.println("Enregistrement annulé.");
        }
    }

}
