package com.wf.training.bootrestfulcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wf.training.bootrestfulcrud.dto.exception.ExceptionResponse;

// @ControllerAdvice ( View Based MVC Applicatiom)
@RestControllerAdvice  // proxy (AOP)
public class GlobalHandler {
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionResponse> nullPointerExceptionHandler(NullPointerException ex) {
		ExceptionResponse response =
				new ExceptionResponse(ex.getMessage(), 
									  System.currentTimeMillis(), 
									  HttpStatus.INTERNAL_SERVER_ERROR.value());
		ResponseEntity<ExceptionResponse> exResponse = 
				new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		return exResponse;
	}
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ExceptionResponse> employeeExceptionHandler(EmployeeException ex) {
		ExceptionResponse response =
				new ExceptionResponse(ex.getMessage(), 
									  System.currentTimeMillis(), 
									  HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> exResponse = 
				new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
		return exResponse;
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionResponse> employeeNotFoundExceptionHandler(EmployeeNotFoundException ex) {
		ExceptionResponse response =
				new ExceptionResponse(ex.getMessage(), 
									  System.currentTimeMillis(), 
									  HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> exResponse = 
				new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		return exResponse;
	}
	
	// generalized : default
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> exceptionHandler(Exception ex) {
		ExceptionResponse response =
				new ExceptionResponse(ex.getMessage(), 
									  System.currentTimeMillis(), 
									  HttpStatus.INTERNAL_SERVER_ERROR.value());
		ResponseEntity<ExceptionResponse> exResponse = 
				new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		return exResponse;
	}
	
}
