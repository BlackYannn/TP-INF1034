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

public class PrendreRdvController {
    public TextField nom;
    public DatePicker dateNaissance;
    public RadioButton sexHomme;
    public RadioButton sexFemme;
    public TextField telephone;
    public TextField email;
    public DatePicker dateRdv;
    public TextField motif;
    public RadioButton urgentOui;
    public RadioButton urgentNon;

    private ToggleGroup toggleGroupSex;
    private ToggleGroup toggleGroupUrgent;

    @FXML
    public void initialize() {
        // Créer un ToggleGroup
        toggleGroupSex = new ToggleGroup();
        toggleGroupUrgent = new ToggleGroup();
        // Associer le ToggleGroup aux deux boutons radio
        sexHomme.setToggleGroup(toggleGroupSex);
        sexFemme.setToggleGroup(toggleGroupSex);
        urgentOui.setToggleGroup(toggleGroupUrgent);
        urgentNon.setToggleGroup(toggleGroupUrgent);
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
    private void confirmer(ActionEvent event) {
        StringBuilder champsManquants = new StringBuilder();

        if (nom.getText().isEmpty()) {
            champsManquants.append("- Nom\n");
        }
        if (dateNaissance.getValue() == null) {
            champsManquants.append("- Date de naissance\n");
        }
        if (toggleGroupSex.getSelectedToggle() == null) {
            champsManquants.append("- Sexe\n");
        }
        if (telephone.getText().isEmpty()) {
            champsManquants.append("- Téléphone\n");
        }
        if (email.getText().isEmpty()) {
            champsManquants.append("- Email\n");
        }
        if (dateRdv.getValue() == null) {
            champsManquants.append("- Date du rendez-vous\n");
        }
        if (motif.getText().isEmpty()) {
            champsManquants.append("- Motif\n");
        }
        if (toggleGroupUrgent.getSelectedToggle() == null) {
            champsManquants.append("- Urgent\n");
        }

        if (!champsManquants.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Champs obligatoires manquants");
            alert.setHeaderText("Veuillez remplir les champs suivants :");
            alert.setContentText(champsManquants.toString());
            alert.showAndWait();
        } else {
            reserverRendezVous(event);
        }
    }


    @FXML
    private void reserverRendezVous(ActionEvent event) {
        // Création de la boîte de dialogue de confirmation
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmer la réservation");
        alert.setContentText("Êtes-vous sûr de vouloir réserver ce rendez-vous ?");

        // Boutons personnalisés
        ButtonType buttonValider = new ButtonType("Valider");
        ButtonType buttonAnnuler = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonValider, buttonAnnuler);

        // Affichage et attente de la réponse
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonValider) {
            // L'utilisateur a confirmé
            System.out.println("Rendez-vous réservé !");
            // TODO : Ajouter la logique pour enregistrer le rendez-vous ici

            // Message de succès
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Succès");
            success.setHeaderText(null);
            success.setContentText("Le rendez-vous a été réservé avec succès !");
            success.showAndWait();
        } else {
            // L'utilisateur a annulé
            System.out.println("Réservation annulée.");
        }
    }

}
