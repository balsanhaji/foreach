package com.example.ecoleapi.repository.impl;
import com.example.ecoleapi.dto.Professeur;
import com.example.ecoleapi.repository.ProfesseurRepository;
import com.example.ecoleapi.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfesseurRepositoryImpl implements ProfesseurRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate NamedParameterJdbcTemplate;

	public Professeur getProfesseur(Integer id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		return NamedParameterJdbcTemplate.queryForObject("SELECT id, nom, prenom, codeinsee FROM professeur WHERE id = :id", namedParameters, new BeanPropertyRowMapper<>(Professeur.class));
	}

	public List<Professeur> searchProfesseur(String nom, String prenom) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("nom", nom).addValue("prenom", prenom);
		return NamedParameterJdbcTemplate.query("SELECT id, nom, prenom FROM professeur WHERE nom = :nom AND prenom = :prenom", namedParameters, new BeanPropertyRowMapper<>(Professeur.class));
	}

	public List<Professeur> getProfesseurs() {
		return (List<Professeur>)jdbcTemplate.query("SELECT * FROM professeur",	new BeanPropertyRowMapper<>(Professeur.class));
	}

	public Professeur addProfesseur(Professeur professeur) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("nom", professeur.getNom()).addValue("prenom",
            professeur.getPrenom()).addValue("codeinsee", professeur.getCodeInsee());

		NamedParameterJdbcTemplate.update("INSERT INTO professeur(nom, prenom, codeinsee) values(:nom, :prenom, :codeinsee)", namedParameters);

		List<Professeur> listProfs = getProfesseurs();

		return listProfs.get(listProfs.size()-1);
	}

	public void putProfesseur(Integer id, Professeur professeur) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id).addValue("nom", professeur.getNom()).addValue("prenom", professeur.getPrenom()).addValue("codeinsee", professeur.getCodeInsee());

		NamedParameterJdbcTemplate.update("UPDATE professeur SET nom = :nom, prenom = :prenom, codeinsee = :codeinsee WHERE id = :id", namedParameters);
	}

	public void patchProfesseur(Integer id, Professeur professeur) {
		List<String> listPatch = new ArrayList<>();
		String set = "";

		if(professeur.getNom() != null)
			listPatch.add("nom = :nom");
		if(professeur.getPrenom() != null)
			listPatch.add("prenom = :prenom");
		if(professeur.getCodeInsee() != null)
			listPatch.add("codeinsee = :codeinsee");

//		for(int i=0; i<listPatch.size();i++)
//			set = (i == listPatch.size()-1) ? set + listPatch.get(i) : set + listPatch.get(i) + ", ";

		String updatedColumns = String.join(",", listPatch);
		String update = "UPDATE professeur SET " +updatedColumns + " WHERE id = :id";

			SqlParameterSource namedParameters = new MapSqlParameterSource()
						.addValue("id", id)
						.addValue("nom", professeur.getNom())
                        .addValue("prenom", professeur.getPrenom())
						.addValue("codeinsee", professeur.getCodeInsee());

			NamedParameterJdbcTemplate.update(update, namedParameters);
	}

	public void delProfesseur(Integer id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		NamedParameterJdbcTemplate.update("DELETE FROM professeur WHERE id = :id", namedParameters);
	}
}