package jeuxvideoapi.service;

import jeuxvideoapi.dto.JeuVideo;
import jeuxvideoapi.dto.TypeJeu;

import java.util.List;

public interface TypeJeuService {
	List<TypeJeu> getTypesJeu();
	TypeJeu addTypeJeu(TypeJeu typeJeu);
}
