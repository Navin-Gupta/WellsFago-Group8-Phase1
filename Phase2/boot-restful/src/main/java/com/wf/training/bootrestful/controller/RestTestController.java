package com.wf.training.bootrestful.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wf.training.bootrestful.model.Employee;

@RestController
@RequestMapping("/api")
public class RestTestController {

	// REST endpoint /api/test
	@RequestMapping("/test")
	public String test() {
		return "Hello all";
	}
	
	// REST endpoint /api/employee
	@RequestMapping("/employee")
	public Employee employeeInfo() {
		Employee employee = new Employee("Second", "second@mail.com", "123456789");
		return employee;
	}
}



