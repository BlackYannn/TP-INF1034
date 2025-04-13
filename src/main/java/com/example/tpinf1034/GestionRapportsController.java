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

public class GestionRapportsController {
    public RadioButton radioOptionGesRap1;
    public RadioButton radioOptionGesRap2;
    private ToggleGroup toggleGroupSex;

    @FXML
    public void initialize() {
        // Créer un ToggleGroup
        toggleGroupSex = new ToggleGroup();
        // Associer le ToggleGroup aux deux boutons radio
        radioOptionGesRap1.setToggleGroup(toggleGroupSex);
        radioOptionGesRap2.setToggleGroup(toggleGroupSex);
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
    private void validerRapport(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de validation");
        alert.setHeaderText("Voulez-vous vraiment valider ce rapport ?");
        alert.setContentText("Cliquez sur Valider pour confirmer ou Annuler pour revenir.");

        ButtonType buttonValider = new ButtonType("Valider");
        ButtonType buttonAnnuler = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonValider, buttonAnnuler);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonValider) {
            // Action à faire si l'utilisateur valide
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Validation");
            success.setHeaderText(null);
            success.setContentText("Le rapport a été validé avec succès !");
            success.showAndWait();
        } else {
            // Action à faire si l'utilisateur annule (optionnel)
            System.out.println("Validation annulée par l'utilisateur.");
        }
    }

}
