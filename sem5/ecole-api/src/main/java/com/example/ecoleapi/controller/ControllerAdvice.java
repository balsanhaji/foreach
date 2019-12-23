package com.example.ecoleapi.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(value = {ConstraintViolationException.class})
	protected ResponseEntity<Object> handleConstraintViolationException(
			ConstraintViolationException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getConstraintViolations().forEach((error) -> {
			String fieldName = error.getPropertyPath().toString();
			String errorMessage = error.getMessage();
			errors.put(fieldName, errorMessage);
		});
		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(value = {EmptyResultDataAccessException.class})
	protected ResponseEntity<Object> EmptyResultDataAccessException(
			EmptyResultDataAccessException ex) {
				ex.toString();
				return ResponseEntity.badRequest().body(ex);
	}
}
