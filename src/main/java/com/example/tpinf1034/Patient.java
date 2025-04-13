package com.example.tpinf1034;

public class Patient {

    private String nom;
    private String prenom;
    private int age;
    private String sex;
    private String dossier;
    private String civiere;
    private  boolean visite;


    public Patient(String nom, String prenom, int age, String sex, String dossier, String civiere, boolean visite) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sex = sex;
        this.dossier = dossier;
        this.civiere = civiere;
        this.visite = visite;
    }

    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public int getAge() { return age; }
    public String getSex() { return sex; }
    public String getDossier() { return dossier; }
    public String getCiviere() { return civiere; }
    public boolean isVisite() { return visite; }


    @Override
    public String toString() {
        return nom + " " + prenom;
    }
}
