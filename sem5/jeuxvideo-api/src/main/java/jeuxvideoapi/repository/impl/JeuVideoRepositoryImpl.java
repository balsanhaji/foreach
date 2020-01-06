package jeuxvideoapi.repository.impl;

import jeuxvideoapi.dto.JeuVideo;
import jeuxvideoapi.repository.JeuVideoRepository;
import jeuxvideoapi.repository.impl.rowmapper.JeuVideoRowMapper;
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
public class JeuVideoRepositoryImpl implements JeuVideoRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate NamedParameterJdbcTemplate;

	public JeuVideo getJeu(Integer id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		return NamedParameterJdbcTemplate.queryForObject("SELECT jeu_video.id AS idjeu, jeu_video.nom AS nomjeu, jeu_video.description, jeu_video.date, jeu_video.note, jeu_video.prix, type_jeu.id AS idtype, type_jeu.nom AS nomtype FROM jeu_video LEFT JOIN type_jeu ON jeu_video.id_type_jeu = type_jeu.id WHERE jeu_video.id = :id", namedParameters, new JeuVideoRowMapper());
	}

	public JeuVideo addJeu(JeuVideo jeu) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatement ps = null;

		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("nom", jeu.getNom())
				.addValue("desc", jeu.getDescription())
				.addValue("date", jeu.getDate())
				.addValue("note", jeu.getNote())
				.addValue("prix", jeu.getPrix());

		NamedParameterJdbcTemplate.update("INSERT INTO jeu_video(nom, description, date, note, prix) VALUES(:nom, :desc, :date, :note, :prix)", namedParameters,
				keyHolder, new String[]{"id"});

		return getJeu(keyHolder.getKey().intValue());
	}

	public List<JeuVideo> getJeuByNote() {
		return jdbcTemplate.query("SELECT jeu_video.id AS idjeu, jeu_video.nom AS nomjeu, jeu_video.description, jeu_video.date, jeu_video.note, jeu_video.prix, type_jeu.id AS idtype, type_jeu.nom AS nomtype FROM jeu_video LEFT JOIN type_jeu ON jeu_video.id_type_jeu = type_jeu.id ORDER BY jeu_video.note DESC", new JeuVideoRowMapper());
	}

	public JeuVideo searchJeuByNom(String nom) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("nom", nom);
		return NamedParameterJdbcTemplate.queryForObject("SELECT jeu_video.id AS idjeu, jeu_video.nom AS nomjeu, jeu_video.description, jeu_video.date, jeu_video.note, jeu_video.prix, type_jeu.id AS idtype, type_jeu.nom AS nomtype FROM jeu_video LEFT JOIN type_jeu ON jeu_video.id_type_jeu = type_jeu.id WHERE jeu_video.nom = :nom ORDER BY jeu_video.note DESC", namedParameters, new JeuVideoRowMapper());
	}

	public void delJeu(Integer id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		NamedParameterJdbcTemplate.update("DELETE FROM jeu_video WHERE id = :id", namedParameters);
	}

	public void putJeu(Integer id, JeuVideo jeu) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id)
				.addValue("nom", jeu.getNom())
				.addValue("desc", jeu.getDescription())
				.addValue("date", jeu.getDate())
				.addValue("note", jeu.getNote())
				.addValue("prix", jeu.getPrix());

		NamedParameterJdbcTemplate.update("UPDATE jeu_video SET nom = :nom, description = :desc, date = :date, note = :note, prix = :prix WHERE id = :id", namedParameters);
	}
}
