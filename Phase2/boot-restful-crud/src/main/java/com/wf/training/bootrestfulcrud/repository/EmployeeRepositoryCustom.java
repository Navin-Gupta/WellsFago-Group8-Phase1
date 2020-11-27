package com.wf.training.bootrestfulcrud.repository;

import java.util.List;

import com.wf.training.bootrestfulcrud.entity.Employee;

public interface EmployeeRepositoryCustom {
	List<Employee> veryComplexBusinessLogicReq(String email);
}
