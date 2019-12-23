package com.example.ecoleapi.dto;

import java.util.List;

public class Cours {
    private Integer id;
    private Matiere matiere;
    private Professeur professeur;
    private List<Etudiant> etudiant;

    public Cours() {

    }

    public Cours(Integer id, Matiere matiere, Professeur professeur, List<Etudiant> etudiant) {
        this.id = id;
        this.matiere = matiere;
        this.professeur = professeur;
        this.etudiant = etudiant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public List<Etudiant> getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(List<Etudiant> etudiant) {
        this.etudiant = etudiant;
    }
}
