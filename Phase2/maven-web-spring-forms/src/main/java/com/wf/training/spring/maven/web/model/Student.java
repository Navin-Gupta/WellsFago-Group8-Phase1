package com.wf.training.spring.maven.web.model;

import java.util.LinkedHashMap;

public class Student {

	private String name;
	private String email;
	private String country;
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
