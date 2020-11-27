package com.wf.training.bootrestfulcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.wf.training.bootrestfulcrud.entity.Employee;

//@Component
@Repository
public interface EmployeeRepository 
		extends JpaRepository<Employee, Long>, EmployeeRepositoryCustom{
	// leave it blank
	List<Employee> findByEmail(String email);
	List<Employee> findByBasicPayGreaterThan(Double basicSalary);
	
	@Query("select e from Employee e where e.basicPay >:pay and e.email=:email")
	List<Employee> findBySomeComplexQuery(@Param("pay") Double basicPay, @Param("email")String email);
}

/*
 * Custom DB implementation
 * 
 * 1. Naming Convention : add a appropriatley named mehtod in interface, 
 * 						  implementation would be provided internally
 * 2. Query Implementation : explicit query 
 * 						   : Not a std sql query : JPQL
 * 3. Custom interface with custom method(s), implementation class that define logic of those method
 * 			plugin that interface with current interface
 * 
 */
