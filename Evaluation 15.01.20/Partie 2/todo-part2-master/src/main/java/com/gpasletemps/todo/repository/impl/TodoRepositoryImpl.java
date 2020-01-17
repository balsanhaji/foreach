package com.gpasletemps.todo.repository.impl;

import com.gpasletemps.todo.dto.Todo;
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
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepositoryImpl implements TodoRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Todo> getTodos() {
		return jdbcTemplate.query("SELECT id, nom, description, termine, dateFin, liste_id FROM todo", new BeanPropertyRowMapper<>(Todo.class));
	}

	public Todo getTodo(Integer id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject("SELECT id, nom, description, termine, dateFin, liste_id FROM todo WHERE id = :id", namedParameters, new BeanPropertyRowMapper<>(Todo.class));
	}

	public Todo ajouterTodo(Todo todo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatement ps = null;

		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("nom", todo.getNom())
				.addValue("desc", todo.getDescription())
				.addValue("termine", todo.getTermine())
				.addValue("dateFin", todo.getDateFin())
				.addValue("listeId", todo.getListe_id());

		namedParameterJdbcTemplate.update("INSERT INTO todo(nom, description, termine, dateFin, liste_id) VALUES(:nom, :desc, :termine, :dateFin, :listeId)", namedParameters,
				keyHolder, new String[]{"id"});

		return getTodo(keyHolder.getKey().intValue());
	}

	public Todo putTodo(Integer id, Todo todo) {
		SqlParameterSource namedParameters = new MapSqlParameterSource()
				.addValue("id", id)
				.addValue("nom", todo.getNom())
				.addValue("desc", todo.getDescription())
				.addValue("termine", todo.getTermine())
				.addValue("dateFin", todo.getDateFin())
				.addValue("listeId", todo.getListe_id());

		namedParameterJdbcTemplate.update("UPDATE todo SET nom = :nom, description = :desc, termine = :termine, dateFin = :dateFin, liste_id = :listeId WHERE id = :id", namedParameters);

		return getTodo(id);
	}

	public void delTodo(Integer id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		namedParameterJdbcTemplate.update("DELETE FROM todo WHERE id = :id", namedParameters);
	}

	public void patchTodo(Integer id, Todo todo) {
		List<String> listPatch = new ArrayList<>();

		if(todo.getNom() != null)
			listPatch.add("nom = :nom");
		if(todo.getDescription() != null)
			listPatch.add("description = :description");
		if(todo.getTermine() != null)
			listPatch.add("termine = :termine");
		if(todo.getDateFin() != null)
			listPatch.add("dateFin = :dateFin");
		if(todo.getListe_id() != null)
			listPatch.add("liste_id = :listeId");

		String updatedColumns = String.join(",", listPatch);
		String update = "UPDATE todo SET " + updatedColumns + " WHERE id = :id";

		SqlParameterSource namedParameters = new MapSqlParameterSource()
				.addValue("id", id)
				.addValue("nom", todo.getNom())
				.addValue("desc", todo.getDescription())
				.addValue("termine", todo.getTermine())
				.addValue("dateFin", todo.getDateFin())
				.addValue("listeId", todo.getListe_id());

		namedParameterJdbcTemplate.update(update, namedParameters);
	}

	public List<Todo> getTodosTermines() {
		return jdbcTemplate.query("SELECT id, nom, description, termine, dateFin, liste_id FROM todo WHERE termine = false", new BeanPropertyRowMapper<>(Todo.class));
	}
}