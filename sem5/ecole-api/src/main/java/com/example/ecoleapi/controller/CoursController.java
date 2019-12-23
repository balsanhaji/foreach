package com.example.ecoleapi.controller;
import com.example.ecoleapi.dto.Cours;
import com.example.ecoleapi.dto.Professeur;
import com.example.ecoleapi.repository.CoursRepository;
import com.example.ecoleapi.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@ResponseBody
public class CoursController {
	@Autowired
	CoursService coursService;

	@GetMapping("/cours/{id}")
	public Cours getCoursWithProfesseur(@PathVariable Integer id) {
		return coursService.getCoursWithProfesseur(id);
	}
	
	@PostMapping("/cours")
	public Cours addCours(@RequestBody @Valid Cours cours) {
		int idCours = coursService.addCours(cours);
		cours.setId(idCours);
		return cours;
	}

	@PatchMapping("/cours/{id}")
	public Cours patchCours(@PathVariable("id") Integer id, @RequestBody Cours cours) {
		coursService.patchCours(id, cours);

		return getCoursWithProfesseur(id);
	}
}
