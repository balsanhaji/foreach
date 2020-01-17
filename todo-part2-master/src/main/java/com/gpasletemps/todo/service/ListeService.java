package com.gpasletemps.todo.service;

import com.gpasletemps.todo.dto.Liste;
import com.gpasletemps.todo.dto.Todo;

import java.util.List;

public interface ListeService {
	List<Liste> getListes();
	Liste getListe(Integer id);
	Liste ajouterListe(Liste liste);
}