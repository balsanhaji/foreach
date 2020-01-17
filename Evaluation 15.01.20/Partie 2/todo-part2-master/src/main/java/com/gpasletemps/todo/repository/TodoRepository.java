package com.gpasletemps.todo.repository;

import com.gpasletemps.todo.dto.Todo;

import java.util.List;

public interface TodoRepository {
	List<Todo> getTodos();
	Todo getTodo(Integer id);
	Todo ajouterTodo(Todo todo);
	Todo putTodo(Integer id, Todo todo);
	void delTodo(Integer id);
	void patchTodo(Integer id, Todo todo);
	List<Todo> getTodosTermines();
}
