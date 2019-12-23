package com.example.ecoleapi.repository;
import com.example.ecoleapi.dto.Cours;

public interface CoursRepository {
	Cours getCoursWithProfesseur(Integer id);
	int addCours(Cours cours);
	void patchCours(Integer id, Cours cours);
}