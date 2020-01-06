package jeuxvideoapi.repository.impl;

import jeuxvideoapi.dto.TypeJeu;
import jeuxvideoapi.repository.TypeJeuRepository;
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
public class TypeJeuRepositoryImpl implements TypeJeuRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate NamedParameterJdbcTemplate;

	public List<TypeJeu> getTypesJeu() {
		return (List<TypeJeu>)jdbcTemplate.query("SELECT * FROM type_jeu",	new BeanPropertyRowMapper<>(TypeJeu.class));
	}

	public TypeJeu addTypeJeu(TypeJeu typeJeu) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatement ps = null;

		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("nom", typeJeu.getNom());

		NamedParameterJdbcTemplate.update("INSERT INTO type_jeu(nom) VALUES(:nom)", namedParameters,
				keyHolder, new String[]{"id"});

		return getTypesJeu().get(keyHolder.getKey().intValue());
	}

}