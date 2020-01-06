package jeuxvideoapi.controller;

import jeuxvideoapi.dto.JeuVideo;
import jeuxvideoapi.service.JeuVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Controller
@Validated
@ResponseBody
public class JeuVideoController {
	@Autowired
	private JeuVideoService jeuVideoService;

	@GetMapping("/jeu/{id}")
	public JeuVideo getJeu(@PathVariable("id") Integer id) {
		return jeuVideoService.getJeu(id);
	}

	@PostMapping("/jeu")
	public JeuVideo addJeu(@RequestBody @Valid JeuVideo jeu) {
		return jeuVideoService.addJeu(jeu);
	}

	@GetMapping("/jeuxvideo")
	public List<JeuVideo> getJeuByNote() {
		return jeuVideoService.getJeuByNote();
	}

	@GetMapping("/jeux")
	public List<JeuVideo> searchJeuByNom(@RequestParam(value = "nom") @NotEmpty @Size(min = 3) String nom) {
		List<JeuVideo> jeux = jeuVideoService.getJeuByNote();

		List<JeuVideo> jeu = new ArrayList<>();

		if(nom == null)
			jeu = jeux;
		else {
			for (JeuVideo sJeu : jeux) {
				if (sJeu.getNom().equals(nom))
					jeu.add(sJeu);
			}
		}

		return jeu;
	}

	@DeleteMapping("/jeu/{id}")
	public void delProfesseur(@PathVariable("id") Integer id) {
		jeuVideoService.delJeu(id);
	}

	@PutMapping("/putjeu/{id}")
	public void putJeu(@PathVariable("id") Integer id, @RequestBody JeuVideo jeu) {
		jeuVideoService.putJeu(id, jeu);
	}
}
