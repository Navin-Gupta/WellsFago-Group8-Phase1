package com.wf.training.bootrestfulcrud.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class EmployeeInputDto {
	
	@NotBlank(message = "Name is required!")
	private String name;
	
	@Email
	private String email;
	
	@Length(max = 10, min = 10)
	private String contact;
	
	@Min(value = 1000)
	private Double basicPay;
	
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
	
	
}
