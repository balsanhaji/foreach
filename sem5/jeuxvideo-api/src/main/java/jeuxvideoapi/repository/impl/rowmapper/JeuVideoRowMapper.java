package jeuxvideoapi.repository.impl.rowmapper;

import jeuxvideoapi.dto.JeuVideo;
import jeuxvideoapi.dto.TypeJeu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JeuVideoRowMapper implements RowMapper<JeuVideo> {
	public JeuVideo mapRow(ResultSet rs, int i) throws SQLException {
		JeuVideo jeuVideo = new JeuVideo();

		jeuVideo.setId(rs.getInt("idjeu"));
		jeuVideo.setNom(rs.getString("nomjeu"));
		jeuVideo.setDescription(rs.getString("description"));
		jeuVideo.setDate(rs.getString("date"));
		jeuVideo.setNote(rs.getInt("note"));
		jeuVideo.setPrix(rs.getInt("prix"));

//		if(jeuVideo.getTypeJeu().getId() != null) {
			TypeJeu typeJeu = new TypeJeu();
			typeJeu.setId(rs.getInt("idtype"));
			typeJeu.setNom(rs.getString("nomtype"));
			jeuVideo.setTypeJeu(typeJeu);
//		}

		return jeuVideo;
	}
}
