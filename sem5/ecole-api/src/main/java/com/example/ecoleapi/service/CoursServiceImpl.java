package com.example.ecoleapi.service;

import com.example.ecoleapi.dto.Cours;
import com.example.ecoleapi.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursServiceImpl implements CoursService {
	@Autowired
	private CoursRepository coursRepository;

	public Cours getCoursWithProfesseur(Integer id) {
		return coursRepository.getCoursWithProfesseur(id);
	}

	public int addCours(Cours cours) {
		return coursRepository.addCours(cours);
	}

	public void patchCours(Integer id, Cours cours) {
		coursRepository.patchCours(id, cours);
	}
}