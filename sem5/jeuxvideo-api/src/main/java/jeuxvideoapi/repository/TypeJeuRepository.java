package jeuxvideoapi.repository;

import jeuxvideoapi.dto.TypeJeu;

import java.util.List;

public interface TypeJeuRepository {
	List<TypeJeu> getTypesJeu();
	TypeJeu addTypeJeu(TypeJeu typeJeu);
}
