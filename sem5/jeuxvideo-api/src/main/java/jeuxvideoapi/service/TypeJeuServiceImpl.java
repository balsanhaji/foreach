package jeuxvideoapi.service;

import jeuxvideoapi.dto.TypeJeu;
import jeuxvideoapi.repository.TypeJeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeJeuServiceImpl implements TypeJeuService {
	@Autowired
	private TypeJeuRepository typeJeuRepository;

	public List<TypeJeu> getTypesJeu() {
		return typeJeuRepository.getTypesJeu();
	}

	public TypeJeu addTypeJeu(TypeJeu typeJeu) {
		return typeJeuRepository.addTypeJeu(typeJeu);
	}
}
