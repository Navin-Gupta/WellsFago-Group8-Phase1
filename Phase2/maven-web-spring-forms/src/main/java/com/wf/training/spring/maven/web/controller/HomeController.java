package com.wf.training.spring.maven.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Shall contain processing logic

// Bean created
// Register with Handler Mapper
@Controller
public class HomeController {

	
	// to respond to root URL
	@RequestMapping("/")
	public String home() {
		// add business logic
		
		// respond back with view page name
		return  "index";
	}
	

}
