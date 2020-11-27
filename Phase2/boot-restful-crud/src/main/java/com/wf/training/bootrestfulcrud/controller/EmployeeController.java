package com.wf.training.bootrestfulcrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wf.training.bootrestfulcrud.dto.EmployeeInputDto;
import com.wf.training.bootrestfulcrud.dto.EmployeeOutputDto;
import com.wf.training.bootrestfulcrud.dto.exception.ExceptionResponse;
import com.wf.training.bootrestfulcrud.exception.EmployeeException;
import com.wf.training.bootrestfulcrud.exception.EmployeeNotFoundException;
import com.wf.training.bootrestfulcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	// add dependency
	@Autowired
	private EmployeeService service;
	
	// fetch all records
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeOutputDto>> fetchAll() {
		List<EmployeeOutputDto> employees = this.service.fetchAllEmployees();
		ResponseEntity<List<EmployeeOutputDto>> response =
				new ResponseEntity<List<EmployeeOutputDto>>(employees, HttpStatus.OK);
		return response;
	}
	
	// fetch single record based on id
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeOutputDto> fetchSingle(@PathVariable Long id) {
		EmployeeOutputDto employeeOutputDto = this.service.fetchSingleEmployee(id);
		if(employeeOutputDto == null) {
			// throw custom exception
			throw new EmployeeNotFoundException("Employee not found with Id : " + id);
		}
		ResponseEntity<EmployeeOutputDto> response =
				new ResponseEntity<EmployeeOutputDto>(employeeOutputDto, HttpStatus.OK);
		return response;
	}
	
	// add a new record
	@PostMapping("/employees")
	public ResponseEntity<EmployeeOutputDto> save(@Valid @RequestBody EmployeeInputDto employeeInputDto,
								  BindingResult result) {
		if(result.hasErrors()) {
			// throw custom exception
			throw new EmployeeException("Invalid Data Format!");
		}
		EmployeeOutputDto employeeOutputDto = this.service.saveEmployee(employeeInputDto);
		ResponseEntity<EmployeeOutputDto> response =
				new ResponseEntity<EmployeeOutputDto>(employeeOutputDto, HttpStatus.OK);
		return response;
	}
	
	// edit a record
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeOutputDto> update(@PathVariable Long id, 
									@RequestBody EmployeeInputDto employeeInputDto) {
		EmployeeOutputDto employeeOutputDto = this.service.updateEmployee(id, employeeInputDto);
		if(employeeOutputDto == null) {
			// throw custom exception
			throw new EmployeeNotFoundException("Employee not found with Id : " + id);
		}
		ResponseEntity<EmployeeOutputDto> response =
				new ResponseEntity<EmployeeOutputDto>(employeeOutputDto, HttpStatus.OK);
		return response;
	}
	
	// add a new record
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<EmployeeOutputDto> delete(@PathVariable Long id) {
		EmployeeOutputDto employeeOutputDto = this.service.deleteEmployee(id);
		if(employeeOutputDto == null) {
			// throw custom exception
			throw new EmployeeNotFoundException("Employee not found with Id : " + id);
		}
		ResponseEntity<EmployeeOutputDto> response =
				new ResponseEntity<EmployeeOutputDto>(employeeOutputDto, HttpStatus.OK);
		return response;
	}
	/*
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
	*/
	
}


















