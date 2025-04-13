package com.example.tpinf1034;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class RecherchePatientController {
    public Button btnFermer;
    public DatePicker dateDepart;
    public DatePicker dateAdmission;
    public TextField detailDossier;
    public TextField detailSexe;
    public TextField detailAge;
    public ListView patientListView;
    public Button btnRecherche;
    public TextField prenomField;
    public TextField nomField;
    public TextField detailNom;

    public TextField detailNom1;
    public TextField detailNom11;
    public TextField detailNom2;
    public TextField detailDossier1;
    public TextField detailDossier11;
    public TextField detailDossier111;

    private ObservableList<Patient> listePatient;
    private ObservableList<Patient> listePatientFiltree;

    @FXML
    public void initialize() {

        listePatient = FXCollections.observableArrayList(
                new Patient("Dupont", "Jean", 45, "Homme", "D12345", "C1", true),
                new Patient("Lavoie", "Sophie", 32, "Femme", "D67890", "C2", false),
                new Patient("Tremblay", "Marc", 60, "Homme", "D54321", "C3", true),
                new Patient("Martin", "Émilie", 28, "Femme", "D11111", "C4", true),
                new Patient("Gagnon", "Luc", 51, "Homme", "D22222", "C5", false),
                new Patient("Roy", "Chantal", 36, "Femme", "D33333", "C6", true),
                new Patient("Bouchard", "Alexandre", 40, "Homme", "D44444", "C7", false),
                new Patient("Morin", "Isabelle", 29, "Femme", "D55555", "C8", true),
                new Patient("Lefebvre", "Nicolas", 67, "Homme", "D66666", "C9", false),
                new Patient("Côté", "Julie", 73, "Femme", "D77777", "C10", true)
        );

        // Initialiser la liste filtrée
        listePatientFiltree = FXCollections.observableArrayList();

        // Lier la liste au ListView
        patientListView.setItems(listePatient);
    }

    @FXML
    public void recherchePatient(ActionEvent event) {
        String nom = nomField.getText().toLowerCase().trim();
        String prenom = prenomField.getText().toLowerCase().trim();

        // Vider la liste filtrée avant chaque recherche
        listePatientFiltree.clear();

        // Filtrer les patients
        for (Patient p : listePatient) {
            if (p.getNom().toLowerCase().contains(nom) &&
                    p.getPrenom().toLowerCase().contains(prenom)) {
                listePatientFiltree.add(p);
            }
        }

        // Afficher les patients filtrés
        patientListView.setItems(listePatientFiltree);
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
}
