package com.wf.training.bootrestfulcrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // unique AI value 
	private Long id;
	private String projectName;
	private String projectDomain;
	
	// Employeeid as foreign key
	@ManyToOne
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDomain() {
		return projectDomain;
	}

	public void setProjectDomain(String projectDomain) {
		this.projectDomain = projectDomain;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
