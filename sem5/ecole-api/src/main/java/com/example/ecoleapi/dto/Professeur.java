package com.example.ecoleapi.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Professeur implements Comparable<Professeur> {
    @Positive
    private Integer id;
    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;
    private String codeInsee;
    private String nomCommune;

    public Professeur() {
    }

    public Professeur(Integer id, String nom, String prenom)  {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Professeur(Integer id, String nom, String prenom, String codeInsee) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.codeInsee = codeInsee;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public int compareTo(@NotNull Professeur professeur) {
        return this.getNom().compareTo(professeur.getNom());
    }
}