package com.gpasletemps.todo.service;

import com.gpasletemps.todo.dto.Todo;
import com.gpasletemps.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;

	public List<Todo> getTodos() {
		return todoRepository.getTodos();
	}

	public Todo getTodo(Integer id) {
		return todoRepository.getTodo(id);
	}

	public Todo ajouterTodo(Todo todo) {
		return todoRepository.ajouterTodo(todo);
	}

	public Todo putTodo(Integer id, Todo todo) {
		return todoRepository.putTodo(id, todo);
	}

	public void delTodo(Integer id) {
		todoRepository.delTodo(id);
	}

	public void patchTodo(Integer id, Todo todo) {
		todoRepository.patchTodo(id, todo);
	}

	public List<Todo> getTodosTermines() {
		return todoRepository.getTodosTermines();
	}
}
