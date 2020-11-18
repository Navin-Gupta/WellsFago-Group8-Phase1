package com.wf.training.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Shall contain processing logic

// Bean created
// Register with Handler Mapper
@Controller
public class HomeController {

	// processing logic goes into method
	// Action/Handler method ~ service
	/*
	 * 1. methods must be mapped to a url (for which it contains logic)
	 * 2. Access modifier : public
	 * 3. Return type : String (view name)
	 * 4. Name : any
	 * 5. Parameter : depends on req
	 */
	
	// to respond to root URL
	@RequestMapping("/")
	public String home() {
		// add business logic
		
		// respond back with view page name
		return  "index";
	}
	
	@RequestMapping("/profile")
	public String profile() {
		return "profile-page"; // ~forward
	}
	
}
