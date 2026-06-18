package com.pavan.microservices.department.exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
