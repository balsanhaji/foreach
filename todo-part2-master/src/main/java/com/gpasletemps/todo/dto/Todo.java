package com.gpasletemps.todo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Todo {
	private Integer id;
	private String nom;
	private String description;
	private Boolean termine;
	private Date dateFin;
	private Integer liste_id;

	public Todo() {

	}

	public Todo(Integer id, String nom, String description, Boolean termine, Date dateFin, Integer liste_id) {
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.termine = termine;
		this.dateFin = dateFin;
		this.liste_id = liste_id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getTermine() {
		return termine;
	}

	public void setTermine(Boolean termine) {
		this.termine = termine;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getListe_id() {
		return liste_id;
	}

	public void setListe_id(Integer liste_id) {
		this.liste_id = liste_id;
	}
}