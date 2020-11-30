package com.wf.training.bootrestfulcrud.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// map java class to db table
@Entity // by default class name is defined as table name
// @Table(name = "employeemaster")
public class Employee {

	// all field will be mapped as cols with same name
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // unique AI value 
	private Long id;
	
	// @Column(name = "empname")
	private String name;
	
	private String email;
	
	private String contact;
	private Double basicPay;
	private Double hra;
	private Double ta;
	private Double da;
	private Double pfDeduction;
	
	@OneToMany(mappedBy = "employee")
	private List<Project> projects;
	
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Double getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(Double basicPay) {
		this.basicPay = basicPay;
	}
	public Double getHra() {
		return hra;
	}
	public void setHra(Double hra) {
		this.hra = hra;
	}
	public Double getTa() {
		return ta;
	}
	public void setTa(Double ta) {
		this.ta = ta;
	}
	public Double getDa() {
		return da;
	}
	public void setDa(Double da) {
		this.da = da;
	}
	public Double getPfDeduction() {
		return pfDeduction;
	}
	public void setPfDeduction(Double pfDeduction) {
		this.pfDeduction = pfDeduction;
	}
	
	
	
}
