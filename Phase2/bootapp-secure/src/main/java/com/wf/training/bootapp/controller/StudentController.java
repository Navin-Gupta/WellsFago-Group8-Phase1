package com.wf.training.bootapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapp.model.Student;



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
		student.setCountry("IN");
		String[] languages = new String[] {"Python","C#"};
		student.setFavoriteLanguages(languages);
		model.addAttribute("student", student);
		return "profile-entry";
	}
	
	// @ModelAttribute will save param value into model object
	// @Valid : Validate the data
	@RequestMapping("/profile-save")
	public String saveProfile(@Valid @ModelAttribute Student student,
							  BindingResult result) {
		if(result.hasErrors()) {
			// decide what to do
			return "profile-entry";
		}
		// data will be shared auto
		return "profile-confirm";
	}
}















