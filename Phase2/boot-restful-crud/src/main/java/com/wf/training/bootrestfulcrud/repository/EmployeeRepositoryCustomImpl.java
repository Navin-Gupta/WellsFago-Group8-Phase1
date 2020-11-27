package com.wf.training.bootrestfulcrud.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.wf.training.bootrestfulcrud.entity.Employee;

public class EmployeeRepositoryCustomImpl 
				implements EmployeeRepositoryCustom{
	
	// special bean exposed by JPA for custom DB interaction
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> veryComplexBusinessLogicReq(String email) {
		// entityManager.
		return null;
	}

}
