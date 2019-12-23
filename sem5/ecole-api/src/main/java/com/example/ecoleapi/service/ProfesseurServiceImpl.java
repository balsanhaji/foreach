package com.example.ecoleapi.service;
import com.example.ecoleapi.dto.Professeur;
import com.example.ecoleapi.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {
	@Autowired
	private ProfesseurRepository professeurRepository;

	public Professeur getProfesseur(Integer id) {
		return professeurRepository.getProfesseur(id);
	}

	public List<Professeur> searchProfesseur(String nom, String prenom) {
		return professeurRepository.searchProfesseur(nom, prenom);
	}

	public List<Professeur> getProfesseurs() {
//		return professeurRepository.getProfesseurs().stream()
//				.sorted(Comparator.comparing(Professeur::getNom))
//				.collect(Collectors.toList());
		List<Professeur> professeurs = professeurRepository.getProfesseurs();
		Collections.sort(professeurs);
		return professeurs;
	}

	public Professeur addProfesseur(Professeur professeur) {
		return professeurRepository.addProfesseur(professeur);
	}

	public void putProfesseur(Integer id, Professeur professeur) {
		professeurRepository.putProfesseur(id, professeur);
	}

	public void patchProfesseur(Integer id, Professeur professeur) {
		professeurRepository.patchProfesseur(id, professeur);
	}

	public void delProfesseur(Integer id) {
		professeurRepository.delProfesseur(id);
	}
}