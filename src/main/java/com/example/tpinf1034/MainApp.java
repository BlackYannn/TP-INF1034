package com.example.tpinf1034;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainApp extends Application {

    public List<Patient> listePatient;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("ConnexionView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Connexion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public  void creerPatient() {
        // Création de trois objets Patient
        Patient patient1 = new Patient("Dupont", "Jean", 45, "Homme", "D12345", "C1", true);
        Patient patient2 = new Patient("Lavoie", "Sophie", 32, "Femme", "D67890", "C2", false);
        Patient patient3 = new Patient("Tremblay", "Marc", 60, "Homme", "D54321", "C3", true);
        listePatient.add(patient1);
        listePatient.add(patient2);
        listePatient.add(patient3);
    }
}