package com.example.tpinf1034;

public class Patient {

    private String nom;
    private String prenom;
    private int age;
    private String sexe;
    private String dossier;
    private String unite;
    private String civiere;
    private boolean visite;
    private String prenomConjoint;
    private String provanance;
    private String destination;
    private String dateAdmission;
    private String dateDepart;

    // Constructeur de base
    public Patient(String nom, String prenom, int age, String sexe, String dossier, String civiere, boolean visite) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.dossier = dossier;
        this.civiere = civiere;
        this.visite = visite;
    }

    // Constructeur complet
    public Patient(String nom, String prenom, int age, String sexe, String dossier, String civiere, boolean visite,
                   String unite, String prenomConjoint, String provanance, String destination,
                   String dateAdmission, String dateDepart) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.dossier = dossier;
        this.civiere = civiere;
        this.visite = visite;
        this.unite = unite;
        this.prenomConjoint = prenomConjoint;
        this.provanance = provanance;
        this.destination = destination;
        this.dateAdmission = dateAdmission;
        this.dateDepart = dateDepart;
    }

    // Getters
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public int getAge() { return age; }
    public String getSexe() { return sexe; }
    public String getDossier() { return dossier; }
    public String getUnite() { return unite; }
    public String getCiviere() { return civiere; }
    public boolean getVisite() { return visite; }
    public String getPrenomConjoint() { return prenomConjoint; }
    public String getProvanance() { return provanance; }
    public String getDestination() { return destination; }
    public String getDateAdmission() { return dateAdmission; }
    public String getDateDepart() { return dateDepart; }

    public String getVisiteStr() {
        return visite ? "Autorisé" : "Non autorisé";
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }
}
