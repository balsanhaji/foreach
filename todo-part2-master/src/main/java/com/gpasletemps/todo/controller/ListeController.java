package com.gpasletemps.todo.controller;

import com.gpasletemps.todo.dto.Liste;
import com.gpasletemps.todo.dto.Todo;
import com.gpasletemps.todo.service.ListeService;
import com.gpasletemps.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@ResponseBody
public class ListeController {
	@Autowired
	private ListeService listeService;

	@GetMapping("/listes")
	public List<Liste> getListes() {
		return listeService.getListes();
	}

	@GetMapping("/liste/{id}")
	public Liste getListe(@PathVariable("id") Integer id) {
		return listeService.getListe(id);
	}

	@PostMapping("/liste")
	public Liste ajouterListe(@RequestBody @Valid Liste liste) {
		return listeService.ajouterListe(liste);
	}
}