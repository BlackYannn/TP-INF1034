package com.example.tpinf1034;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onRecherchePatient(ActionEvent event) {
        try {
            // Charger la nouvelle fenêtre
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RecherchePatientView.fxml"));
            Scene newScene = new Scene(fxmlLoader.load());

            // Créer une nouvelle fenêtre (Stage)
            Stage newStage = new Stage();
            newStage.setTitle("Localisation des patients hospitalisés");
            newStage.setScene(newScene);
            newStage.show();

            // Fermer l'ancienne fenêtre
            Stage oldStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            // Afficher une alerte en cas d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Impossible d'ouvrir la nouvelle fenêtre");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    protected void onDeclarationBris(ActionEvent event) {
        try {
            // Charger la nouvelle fenêtre
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeclarationBrisView.fxml"));
            Scene SceneBris = new Scene(fxmlLoader.load());

            // Créer une nouvelle fenêtre (Stage)
            Stage newStage = new Stage();
            newStage.setTitle("Déclaration d'un bris");
            newStage.setScene(SceneBris);
            newStage.show();

            // Fermer l'ancienne fenêtre
            Stage oldStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            // Afficher une alerte en cas d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Impossible d'ouvrir la nouvelle fenêtre");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void onPrendreRdv(ActionEvent event) {
        try {
            // Charger la nouvelle fenêtre
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrendreRdv.fxml"));
            Scene SceneBris = new Scene(fxmlLoader.load());

            // Créer une nouvelle fenêtre (Stage)
            Stage newStage = new Stage();
            newStage.setTitle("Prendre rendez-vous");
            newStage.setScene(SceneBris);
            newStage.show();

            // Fermer l'ancienne fenêtre
            Stage oldStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            // Afficher une alerte en cas d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Impossible d'ouvrir la nouvelle fenêtre");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }


    public void onGestionRapport(ActionEvent event) {
        try {
            // Charger la nouvelle fenêtre
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GestionRapports.fxml"));
            Scene SceneBris = new Scene(fxmlLoader.load());

            // Créer une nouvelle fenêtre (Stage)
            Stage newStage = new Stage();
            newStage.setTitle("Gestion rapport");
            newStage.setScene(SceneBris);
            newStage.show();

            // Fermer l'ancienne fenêtre
            Stage oldStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            // Afficher une alerte en cas d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Impossible d'ouvrir la nouvelle fenêtre");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void onGestionCartes(ActionEvent event) {
        try {
            // Charger la nouvelle fenêtre
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GestionCarteAcces.fxml"));
            Scene SceneBris = new Scene(fxmlLoader.load());

            // Créer une nouvelle fenêtre (Stage)
            Stage newStage = new Stage();
            newStage.setTitle("Gestion Cartes d'accès");
            newStage.setScene(SceneBris);
            newStage.show();

            // Fermer l'ancienne fenêtre
            Stage oldStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            // Afficher une alerte en cas d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Impossible d'ouvrir la nouvelle fenêtre");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void onGestionMedicaments(ActionEvent event) {
        try {
            // Charger la nouvelle fenêtre
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GestionMedicaments.fxml"));
            Scene SceneBris = new Scene(fxmlLoader.load());

            // Créer une nouvelle fenêtre (Stage)
            Stage newStage = new Stage();
            newStage.setTitle("Gestion Médicaments");
            newStage.setScene(SceneBris);
            newStage.show();

            // Fermer l'ancienne fenêtre
            Stage oldStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            // Afficher une alerte en cas d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Impossible d'ouvrir la nouvelle fenêtre");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void fermerFenetre(ActionEvent event) {
        try {
            // Charger la nouvelle fenêtre
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConnexionView.fxml"));
            Scene newScene = new Scene(fxmlLoader.load());

            // Créer une nouvelle fenêtre (Stage)
            Stage newStage = new Stage();
            newStage.setTitle("Connexion");
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
}