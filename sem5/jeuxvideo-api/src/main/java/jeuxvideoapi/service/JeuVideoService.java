package jeuxvideoapi.service;

import jeuxvideoapi.dto.JeuVideo;

import java.util.List;

public interface JeuVideoService {
	JeuVideo getJeu(Integer id);
	JeuVideo addJeu(JeuVideo jeu);
	List<JeuVideo> getJeuByNote();
	JeuVideo searchJeuByNom(String nom);
	void delJeu(Integer id);
	void putJeu(Integer id, JeuVideo jeu);
}
