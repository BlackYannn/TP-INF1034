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

    public TextField detailPrenomConjoint;
    public TextField detailDestination;
    public TextField detailProvenance;
    public TextField detailUnite;
    public TextField detailVisite;
    public TextField detailCiviere;
    public TextArea detailDateDepart;
    public TextArea detailDateAdmission;

    private ObservableList<Patient> listePatient;
    private ObservableList<Patient> listePatientFiltree;

    @FXML
    public void initialize() {

        listePatient = FXCollections.observableArrayList(
                listePatient = FXCollections.observableArrayList(
                        new Patient("Dupont", "Jean", 45, "Homme", "D12345", "C1", true,
                                "U1", "Marie", "Urgence", "Chirurgie", "2023-01-10", "2023-01-15"),
                        new Patient("Lavoie", "Sophie", 32, "Femme", "D67890", "C2", false,
                                "U2", "Alex", "Clinique", "Soins intensifs", "2023-03-22", "2023-03-29"),
                        new Patient("Tremblay", "Marc", 60, "Homme", "D54321", "C3", true,
                                "U3", "Lucie", "Externe", "Oncologie", "2023-05-05", "2023-05-20"),
                        new Patient("Martin", "Émilie", 28, "Femme", "D11111", "C4", true,
                                "U4", "Pierre", "Médecin famille", "Obstétrique", "2023-07-12", "2023-07-19"),
                        new Patient("Gagnon", "Luc", 51, "Homme", "D22222", "C5", false,
                                "U5", "Nathalie", "Urgence", "Orthopédie", "2023-08-01", "2023-08-10"),
                        new Patient("Roy", "Chantal", 36, "Femme", "D33333", "C6", true,
                                "U6", "David", "Ambulance", "Cardiologie", "2023-09-15", "2023-09-20"),
                        new Patient("Bouchard", "Alexandre", 40, "Homme", "D44444", "C7", false,
                                "U7", "Sophie", "Clinique privée", "Neurologie", "2023-10-05", "2023-10-12"),
                        new Patient("Morin", "Isabelle", 29, "Femme", "D55555", "C8", true,
                                "U8", "Marc", "Maison", "Gynécologie", "2023-11-11", "2023-11-18"),
                        new Patient("Lefebvre", "Nicolas", 67, "Homme", "D66666", "C9", false,
                                "U9", "Julie", "Centre d'accueil", "Gériatrie", "2023-12-01", "2023-12-20"),
                        new Patient("Côté", "Julie", 73, "Femme", "D77777", "C10", true,
                                "U10", "Michel", "CHSLD", "Soins palliatifs", "2024-01-08", "2024-01-15")
                )
        );

        // Initialiser la liste filtrée
        listePatientFiltree = FXCollections.observableArrayList();

        // Lier la liste au ListView
        patientListView.setItems(listePatient);

        patientListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue,  newValue) -> {
            if (newValue != null) {
                afficherDetailsPatient((Patient) newValue);
            }
        });

    }

    private void afficherDetailsPatient(Patient patient) {
        detailNom.setText(patient.toString());
        detailAge.setText(String.valueOf(patient.getAge()));
        detailSexe.setText(patient.getSexe());
        detailDossier.setText(patient.getDossier());
        detailUnite.setText(patient.getUnite());
        detailCiviere.setText(patient.getCiviere());
        detailVisite.setText(patient.getVisiteStr());
        detailPrenomConjoint.setText(patient.getPrenomConjoint());
        detailProvenance.setText(patient.getProvanance());
        detailDestination.setText(patient.getDestination());
        detailDateAdmission.setText(patient.getDateAdmission());
        detailDateDepart.setText(patient.getDateDepart());

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

        if (!listePatientFiltree.isEmpty()) {
            patientListView.getSelectionModel().selectFirst();
            afficherDetailsPatient(listePatientFiltree.get(0));
        }
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
