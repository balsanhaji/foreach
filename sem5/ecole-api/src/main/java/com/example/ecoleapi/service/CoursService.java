package com.example.ecoleapi.service;
import com.example.ecoleapi.dto.Cours;

public interface CoursService {
	Cours getCoursWithProfesseur(Integer id);
	int addCours(Cours cours);
	void patchCours(Integer id, Cours cours);
}