package com.gpasletemps.todo.repository.impl;

import com.gpasletemps.todo.dto.Liste;
import com.gpasletemps.todo.dto.Todo;
import com.gpasletemps.todo.repository.ListeRepository;
import com.gpasletemps.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class ListeRepositoryImpl implements ListeRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Liste> getListes() {
		return jdbcTemplate.query("SELECT id, nom FROM liste", new BeanPropertyRowMapper<>(Liste.class));
	}

	public Liste getListe(Integer id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject("SELECT id, nom FROM liste WHERE id = :id", namedParameters, new BeanPropertyRowMapper<>(Liste.class));
	}

	public Liste ajouterListe(Liste liste) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatement ps = null;

		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("nom", liste.getNom());

		namedParameterJdbcTemplate.update("INSERT INTO liste(nom) VALUES(:nom)", namedParameters,
				keyHolder, new String[]{"id"});

		return getListe(keyHolder.getKey().intValue());
	}
}