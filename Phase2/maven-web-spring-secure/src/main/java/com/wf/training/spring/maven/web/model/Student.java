package com.wf.training.spring.maven.web.model;

import java.util.LinkedHashMap;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.wf.training.spring.maven.web.validators.StudentCode;



public class Student {

	@NotBlank(message = "Name is required!")
	// @Pattern(regexp = "")
	private String name;
	
	// @Email
	private String email;
	
	private String country;
	
	// @NotBlank(message = "Free passes are required!") // work for string
	// always go for wrapper types
	@NotNull(message = "Free passes are required!")
	@Min(value = 1, message = "At least 1 free pass is required!")
	private Integer freePasses;
	
	// eg : begin with prefix = ""
	@StudentCode(prefix = "WF", message = "Invalid Student Code!")
	private String studentCode;
	
	private String[] favoriteLanguages;
	
	private LinkedHashMap<String, String> countries;
	
	public Student() {
		// use dao class to initialize the collection
		// dummy list
		this.countries = new LinkedHashMap<String, String>();
		this.countries.put("FR", "France");
		this.countries.put("IN", "India");
		this.countries.put("GR", "Germany");
		this.countries.put("US", "USA");
	}
	
	
	
	
	public Integer getFreePasses() {
		return freePasses;
	}



	
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}




	public String getStudentCode() {
		return studentCode;
	}




	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}




	public String[] getFavoriteLanguages() {
		return favoriteLanguages;
	}



	public void setFavoriteLanguages(String[] favoriteLanguages) {
		this.favoriteLanguages = favoriteLanguages;
	}



	public LinkedHashMap<String, String> getCountries() {
		return countries;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
