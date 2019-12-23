package com.example.ecoleapi.controller;
import com.example.ecoleapi.dto.Commune;
import com.example.ecoleapi.dto.Professeur;
import com.example.ecoleapi.repository.ProfesseurRepository;
import com.example.ecoleapi.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Controller
@Validated
@ResponseBody
public class ProfesseurController {
	@Autowired
	private ProfesseurService professeurService;

	@GetMapping("/professeur")
	public List<Professeur> getProfesseurs() {
		return professeurService.getProfesseurs();
	}

	@Value("${insee}")
	private String inceptionUrl;

	@GetMapping("/professeur/{id}")
	public Professeur getProfesseur(@PathVariable("id") @Positive Integer id) {
		Professeur prof = professeurService.getProfesseur(id);

		try{
			Commune commune;
			commune = new RestTemplate().getForObject(inceptionUrl + prof.getCodeInsee(), Commune.class);
			prof.setNomCommune(commune.getNom());
		}catch (HttpClientErrorException e){
			prof.setNomCommune(null);
		}

		return prof;
	}

	@PostMapping("/professeur")
	public Professeur addProfesseur(@RequestBody @Valid Professeur professeur) {
		return professeurService.addProfesseur(professeur);
	}

	@PutMapping("/professeur/{id}")
	public void putProfesseur(@PathVariable("id") Integer id, @RequestBody Professeur professeur) {
		professeurService.putProfesseur(id, professeur);
	}

	@PatchMapping("/professeur/{id}")
	public Professeur patchProfesseur(@PathVariable("id") Integer id, @RequestBody Professeur professeur) {
		professeurService.patchProfesseur(id, professeur);

		return getProfesseur(id);
	}

	@DeleteMapping("/professeur/{id}")
	public void delProfesseur(@PathVariable("id") Integer id) {
		professeurService.delProfesseur(id);
	}

	@GetMapping("/professeurs")
	public ResponseEntity<List<Professeur>> searchProfesseur(@RequestParam(value = "nom", required = false) @NotEmpty String nom, @RequestParam(value = "prenom", required = false) @NotEmpty String prenom) {
		List<Professeur> professeurs = professeurService.searchProfesseur(nom, prenom);

		List<Professeur> prof = new ArrayList<>();

		if(nom == null && prenom == null)
			prof = professeurs;
		else {
			for(Professeur professeur : professeurs) {
				if(rechercheUniquementParNom(nom, prenom, professeur))
					prof.add(professeur);
				if(rechercheUniquementParPrenom(nom, prenom, professeur))
					prof.add(professeur);
				if(rechercheParNomEtPrenom(nom, prenom, professeur))
					prof.add(professeur);
			}
		}

		if(prof.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(prof);
		}
	}

	private boolean rechercheParNomEtPrenom(String nom, String prenom, Professeur professeur) {
		return professeur.getNom().equals(nom) && professeur.getPrenom().equals(prenom);
	}

	private boolean rechercheUniquementParPrenom(String nom, String prenom, Professeur professeur) {
		return professeur.getPrenom().equals(prenom) && nom == null;
	}

	private boolean rechercheUniquementParNom(String nom, String prenom, Professeur professeur) {
		return professeur.getNom().equals(nom) && prenom == null;
	}
}