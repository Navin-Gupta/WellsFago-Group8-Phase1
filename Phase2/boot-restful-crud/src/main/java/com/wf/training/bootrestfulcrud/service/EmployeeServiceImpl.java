package com.wf.training.bootrestfulcrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wf.training.bootrestfulcrud.dto.EmployeeInputDto;
import com.wf.training.bootrestfulcrud.dto.EmployeeOutputDto;
import com.wf.training.bootrestfulcrud.entity.Employee;
import com.wf.training.bootrestfulcrud.repository.EmployeeRepository;

// @Component
@Service
public class EmployeeServiceImpl implements EmployeeService {

	// injecting a dependency
	@Autowired
	private EmployeeRepository repository;
	
	// utility method
	private EmployeeOutputDto convertEntityToOutputDto(Employee employee) {
		EmployeeOutputDto employeeOutputDto = new EmployeeOutputDto();
		employeeOutputDto.setId(employee.getId());
		employeeOutputDto.setName(employee.getName());
		employeeOutputDto.setEmail(employee.getEmail());
		employeeOutputDto.setContact(employee.getContact());
		Double netSalary = employee.getBasicPay() +
						   employee.getHra() + 
						   employee.getTa() + 
						   employee.getDa() -
						   employee.getPfDeduction();
		employeeOutputDto.setNetSalary(netSalary);
		return employeeOutputDto;
	}
	
	private Employee convertInputDtoToEntity(EmployeeInputDto employeeInputDto) {
		Employee employee = new Employee();
		employee.setName(employeeInputDto.getName());
		employee.setEmail(employeeInputDto.getEmail());
		employee.setContact(employeeInputDto.getContact());
		employee.setBasicPay(employeeInputDto.getBasicPay());
		Double basicPay = employeeInputDto.getBasicPay();
		Double hra = (basicPay * 20)/100;
		Double ta = (basicPay * 10)/100;
		Double da = (basicPay * 10)/100;
		Double pfDeduction = (basicPay * 15)/100;
		employee.setHra(hra);
		employee.setTa(ta);
		employee.setDa(da);
		employee.setPfDeduction(pfDeduction);
		
		return employee;
	}
	
	@Override
	public List<EmployeeOutputDto> fetchAllEmployees() {
		
		/*this.repository.findByEmail("");
		this.repository.findByBasicPayGreaterThan(2000.0);
		this.repository.findBySomeComplexQuery(2000.0, "");
		this.repository.veryComplexBusinessLogicReq("");
		*/
		
		List<Employee> employees = this.repository.findAll();
		// convert entity into dto list
		/*List<EmployeeOutputDto> employeeDtos = new ArrayList<EmployeeOutputDto>();
		for(Employee employee : employees) {
			EmployeeOutputDto employeeOutputDto = this.convertEntityToOutputDto(employee);
			employeeDtos.add(employeeOutputDto);
		}*/
		List<EmployeeOutputDto> employeeDtos = 
				employees.stream()
						 .map(this :: convertEntityToOutputDto)
						 .collect(Collectors.toList());
		return employeeDtos;
	}

	@Override
	public EmployeeOutputDto fetchSingleEmployee(Long id) {
		if(this.repository.existsById(id)) {
			Employee employee = this.repository.findById(id).orElse(null);
			EmployeeOutputDto employeeOutputDto = this.convertEntityToOutputDto(employee);
			return employeeOutputDto;
		}
		return null;
	}

	@Override
	public EmployeeOutputDto saveEmployee(EmployeeInputDto employeeInputDto) {
		// convert dto into entity
		Employee employee = this.convertInputDtoToEntity(employeeInputDto);
		// save into DB, returns newly added record
		Employee newEmployee = this.repository.save(employee);
		// convert entity into dto
		EmployeeOutputDto employeeOutputDto =  this.convertEntityToOutputDto(newEmployee);
		return employeeOutputDto;
	}

	@Override
	public EmployeeOutputDto updateEmployee(Long id, EmployeeInputDto employeeInputDto) {
		if(this.repository.existsById(id)) {
			// convert input dto into entity
			Employee employee = this.convertInputDtoToEntity(employeeInputDto);
			// assign the id to employee
			employee.setId(id);
			// save into DB, returns newly added record
			// save : PK (id) is null or empty:insert or else update
			Employee updatedEmployee = this.repository.save(employee);
			// convert entity into dto
			EmployeeOutputDto employeeOutputDto =  this.convertEntityToOutputDto(updatedEmployee);
			return employeeOutputDto;
		}
		return null;
	}

	@Override
	public EmployeeOutputDto deleteEmployee(Long id) {
		if(this.repository.existsById(id)) {
			// get the copy of record to be deleted
			EmployeeOutputDto employeeOutputDto = this.fetchSingleEmployee(id);
			this.repository.deleteById(id);
			return employeeOutputDto;
		}
		return null;
	}

}
