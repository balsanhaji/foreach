package com.gpasletemps.todo.repository;

import com.gpasletemps.todo.dto.Liste;
import com.gpasletemps.todo.dto.Todo;

import java.util.List;

public interface ListeRepository {
	List<Liste> getListes();
	Liste getListe(Integer id);
	Liste ajouterListe(Liste liste);
}
