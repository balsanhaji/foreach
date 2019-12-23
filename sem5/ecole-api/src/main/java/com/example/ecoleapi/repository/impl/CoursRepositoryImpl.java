package com.example.ecoleapi.repository.impl;
import com.example.ecoleapi.dto.Cours;
import com.example.ecoleapi.repository.CoursRepository;
import com.example.ecoleapi.repository.impl.rowmapper.CoursRowMapper;
import com.example.ecoleapi.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CoursRepositoryImpl implements CoursRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate NamedParameterJdbcTemplate;


	public Cours getCoursWithProfesseur(Integer id) {
			SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);

//			return NamedParameterJdbcTemplate.queryForObject("SELECT cours.id AS idcours, cours.id_professeur, professeur.nom AS nomprof, professeur.prenom, professeur.codeinsee, matiere.id AS idmatiere, matiere.nom AS nommatiere, etudiant.id AS idetu, etudiant.nom AS nometu, etudiant.prenom AS prenometu FROM cours JOIN professeur ON cours.id_professeur = professeur.id JOIN matiere ON matiere.id = cours.id_matiere JOIN suit_cours ON cours.id = suit_cours.id_cours JOIN etudiant ON suit_cours.id_etudiant = etudiant.id WHERE cours.id = :id", namedParameters, new CoursRowMapper());

			return NamedParameterJdbcTemplate.queryForObject("SELECT cours.id AS idcours, cours.id_professeur, professeur.nom AS nomprof, professeur.prenom, professeur.codeinsee, matiere.id AS idmatiere, matiere.nom AS nommatiere FROM cours JOIN professeur ON cours.id_professeur = professeur.id JOIN matiere ON matiere.id = cours.id_matiere WHERE cours.id = :id", namedParameters, new CoursRowMapper());
	}

	public int addCours(Cours cours) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatement ps = null;

		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id", cours.getId());
		NamedParameterJdbcTemplate.update("INSERT INTO cours DEFAULT VALUES", sqlParameterSource, keyHolder, new String[] {"id"});

		return keyHolder.getKey().intValue();
	}

	public void patchCours(Integer id, Cours cours) {
		List<String> listPatch = new ArrayList<>();

//		if(cours.getMatiere().getId() != null)
//			listPatch.add("id_matiere = :id_matiere");
//		if(cours.getProfesseur().getId() != null)
//			listPatch.add("id_professeur = :id_professeur");

//		String updatedColumns = String.join(",", listPatch);
//		String update = "UPDATE professeur SET " + updatedColumns + " WHERE id = :id";

			String update = "UPDATE cours SET id_matiere = :id_matiere WHERE id = :id";
			SqlParameterSource namedParameters = new MapSqlParameterSource()
					.addValue("id", id)
					.addValue("id_matiere", cours.getMatiere().getId());
//					.addValue("id_professeur", cours.getProfesseur().getId());

			NamedParameterJdbcTemplate.update(update, namedParameters);
	}
}