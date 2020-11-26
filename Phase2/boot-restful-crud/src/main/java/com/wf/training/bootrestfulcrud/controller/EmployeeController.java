package com.wf.training.bootrestfulcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wf.training.bootrestfulcrud.dto.EmployeeInputDto;
import com.wf.training.bootrestfulcrud.dto.EmployeeOutputDto;
import com.wf.training.bootrestfulcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	// add dependency
	@Autowired
	private EmployeeService service;
	
	// fetch all records
	@GetMapping("/employees")
	public List<EmployeeOutputDto> fetchAll() {
		List<EmployeeOutputDto> employees = this.service.fetchAllEmployees();
		return employees;
	}
	
	// fetch single record based on id
	@GetMapping("/employees/{id}")
	public EmployeeOutputDto fetchSingle(@PathVariable Long id) {
		EmployeeOutputDto employeeOutputDto = this.service.fetchSingleEmployee(id);
		return employeeOutputDto;
	}
	
	// add a new record
	@PostMapping("/employees")
	public EmployeeOutputDto save(@RequestBody EmployeeInputDto employeeInputDto) {
		EmployeeOutputDto employeeOutputDto = this.service.saveEmployee(employeeInputDto);
		return employeeOutputDto;
	}
	
	// edit a record
	@PutMapping("/employees/{id}")
	public EmployeeOutputDto update(@PathVariable Long id, 
									@RequestBody EmployeeInputDto employeeInputDto) {
		EmployeeOutputDto employeeOutputDto = this.service.updateEmployee(id, employeeInputDto);
		return employeeOutputDto;
	}
	
	// add a new record
	@DeleteMapping("/employees/{id}")
	public EmployeeOutputDto save(@PathVariable Long id) {
		EmployeeOutputDto employeeOutputDto = this.service.deleteEmployee(id);
		return employeeOutputDto;
	}
}
