package jeuxvideoapi.controller;

import jeuxvideoapi.dto.JeuVideo;
import jeuxvideoapi.dto.TypeJeu;
import jeuxvideoapi.service.TypeJeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Validated
@ResponseBody
public class TypeJeuController {
	@Autowired
	private TypeJeuService typeJeuService;

	@GetMapping("/typesjeux")
	public List<TypeJeu> getTypesJeu() {
		return typeJeuService.getTypesJeu();
	}

	@PostMapping("/typejeu")
	public TypeJeu addTypeJeu(TypeJeu typeJeu) {
		return typeJeuService.addTypeJeu(typeJeu);
	}
}
