package com.wf.training.bootrestfulcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.wf.training.bootrestfulcrud.entity.Employee;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	// leave it blank
}
