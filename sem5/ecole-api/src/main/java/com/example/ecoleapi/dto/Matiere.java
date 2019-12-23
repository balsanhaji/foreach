package com.example.ecoleapi.dto;

public class Matiere {
    private Integer id;
    private String nom;

    public Matiere() {

    }

    public Matiere(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
