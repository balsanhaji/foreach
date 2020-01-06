package jeuxvideoapi.service;

import jeuxvideoapi.dto.JeuVideo;
import jeuxvideoapi.dto.TypeJeu;
import jeuxvideoapi.repository.JeuVideoRepository;
import jeuxvideoapi.repository.TypeJeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuVideoServiceImpl implements JeuVideoService {
	@Autowired
	private JeuVideoRepository jeuVideoRepository;
	@Autowired
	private TypeJeuRepository typeJeuRepository;

	public JeuVideo getJeu(Integer id) {
		return jeuVideoRepository.getJeu(id);
	}

	public JeuVideo addJeu(JeuVideo jeu) {
		return jeuVideoRepository.addJeu(jeu);
	}

	public List<JeuVideo> getJeuByNote() {
		return jeuVideoRepository.getJeuByNote();
	}

	public JeuVideo searchJeuByNom(String nom) {
		return jeuVideoRepository.searchJeuByNom(nom);
	}

	public void delJeu(Integer id) {
		jeuVideoRepository.delJeu(id);
	}

	public void putJeu(Integer id, JeuVideo jeu) {
//		TypeJeu type = jeu.getTypeJeu();
//
//		if(type.getId() != null)
//			jeuVideoRepository.putJeu(id, jeu);
//
//		try {
//			for(TypeJeu typeJeu: typeJeuRepository.getTypesJeu()) {
//				if(typeJeu.getNom().equals(type.getNom()))
//			}
//		} catch (EmptyResultDataAccessException e) {
//
//		}

		jeuVideoRepository.putJeu(id, jeu);
	}


}
