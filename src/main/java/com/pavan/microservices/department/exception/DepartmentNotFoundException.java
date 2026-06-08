package com.pavan.microservices.department.exception;

public class DepartmentNotFoundException extends RuntimeException{
	
	public DepartmentNotFoundException(String message) {
		super(message);
	}
}
