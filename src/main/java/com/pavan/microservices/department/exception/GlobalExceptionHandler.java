package com.pavan.microservices.department.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<String> handleDepartmentNotFoundException(DepartmentNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
