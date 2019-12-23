package com.example.ecoleapi.repository;
import com.example.ecoleapi.dto.Professeur;

import java.util.List;

public interface ProfesseurRepository {
	Professeur getProfesseur(Integer id);
	List<Professeur> searchProfesseur(String nom, String prenom);
	List<Professeur> getProfesseurs();
	Professeur addProfesseur(Professeur professeur);
	void putProfesseur(Integer id, Professeur professeur);
	void patchProfesseur(Integer id, Professeur professeur);
	void delProfesseur(Integer id);
}