package com.wf.training.bootrestfulcrud.exception;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
