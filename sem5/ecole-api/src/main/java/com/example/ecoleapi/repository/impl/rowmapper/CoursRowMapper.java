package com.example.ecoleapi.repository.impl.rowmapper;

import com.example.ecoleapi.dto.Cours;
import com.example.ecoleapi.dto.Etudiant;
import com.example.ecoleapi.dto.Matiere;
import com.example.ecoleapi.dto.Professeur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoursRowMapper implements RowMapper<Cours> {
	public Cours mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cours cours = new Cours();

		cours.setId(rs.getInt("idcours"));

		Matiere matiere = new Matiere();
		matiere.setId(rs.getInt("idmatiere"));
		matiere.setNom(rs.getString("nommatiere"));
		cours.setMatiere(matiere);

		Professeur professeur = new Professeur();
		professeur.setId(rs.getInt("id_professeur"));
		professeur.setNom(rs.getString("nomprof"));
		professeur.setPrenom(rs.getString("prenom"));
		professeur.setCodeInsee(rs.getString("codeinsee"));
		cours.setProfesseur(professeur);

		return cours;
	}
}
