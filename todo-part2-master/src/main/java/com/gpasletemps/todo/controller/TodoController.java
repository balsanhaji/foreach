package com.gpasletemps.todo.controller;

import com.gpasletemps.todo.dto.Liste;
import com.gpasletemps.todo.dto.Todo;
import com.gpasletemps.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@ResponseBody
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping("/todos")
	public List<Todo> getTodos() {
		return todoService.getTodos();
	}

	@GetMapping("/todo/{id}")
	public Todo getTodo(@PathVariable("id") Integer id) {
		return todoService.getTodo(id);
	}

	@PostMapping("/todo")
	public Todo ajouterTodo(@RequestBody @Valid Todo todo) {
		return todoService.ajouterTodo(todo);
	}

	@PutMapping("/todoput/{id}")
	public Todo putTodo(@PathVariable("id") Integer id, @RequestBody Todo todo) {
		return todoService.putTodo(id, todo);
	}

	@DeleteMapping("/todo/{id}")
	public void delTodo(@PathVariable("id") Integer id) {
		todoService.delTodo(id);
	}

	@PatchMapping("/todo/{id}")
	public Todo patchTodo(@PathVariable("id") Integer id, @RequestBody Todo todo) {
		todoService.patchTodo(id, todo);

		return getTodo(id);
	}

	@GetMapping("/todostermines")
	public List<Todo> getTodosTermines() {
		return todoService.getTodosTermines();
	}
}