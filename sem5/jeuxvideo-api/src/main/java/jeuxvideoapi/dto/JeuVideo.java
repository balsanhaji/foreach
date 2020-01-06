package jeuxvideoapi.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class JeuVideo {
	private Integer id;
	@NotNull
	private String nom;
	@NotNull
	private String description;
	private String date;
	private Integer note;
	private Integer prix;
	private TypeJeu typeJeu;

	public JeuVideo() {

	}

	public JeuVideo(Integer id, String nom, String description, String date, Integer note, Integer prix, TypeJeu typeJeu) {
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.date = date;
		this.note = note;
		this.prix = prix;
		this.typeJeu = typeJeu;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public TypeJeu getTypeJeu() {
		return typeJeu;
	}

	public void setTypeJeu(TypeJeu typeJeu) {
		this.typeJeu = typeJeu;
	}
}
