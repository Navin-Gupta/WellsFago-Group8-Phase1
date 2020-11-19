package com.wf.training.spring.maven.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.spring.maven.web.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	// url mapping for student dashboard 
	// /home
	@RequestMapping("/home") // /student/home
	public String home() {
		return "student-home";
	}
	
	// url mapping for profile entry
	@RequestMapping("/profile-entry")
	public String profileEntry(Model model) {
		// send a blank/empty student object to map with form
		Student student = new Student();
		student.setName("Dummy");
		model.addAttribute("student", student);
		return "profile-entry";
	}
	
	// @ModelAttribute will save param value into model object
	@RequestMapping("/profile-save")
	public String saveProfile(@ModelAttribute Student student) {
		// data will be shared auto
		return "profile-confirm";
	}
}
