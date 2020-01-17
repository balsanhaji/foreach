package com.gpasletemps.todo.service;
import com.gpasletemps.todo.dto.Liste;
import com.gpasletemps.todo.dto.Todo;
import com.gpasletemps.todo.repository.ListeRepository;
import com.gpasletemps.todo.service.ListeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListeServiceImpl implements ListeService {
	@Autowired
	private ListeRepository listeRepository;

	public List<Liste> getListes() {
		return listeRepository.getListes();
	}

	public Liste getListe(Integer id) {
		return listeRepository.getListe(id);
	}

	public Liste ajouterListe(Liste liste) {
		return listeRepository.ajouterListe(liste);
	}

}
