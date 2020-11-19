package com.wf.training.spring.web.controller;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wf.training.spring.web.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	// handler for employee dashboard
	// url : /home
	// @RequestMapping("/home")  // /employee/home
	@RequestMapping(value = {"/home", "/dashboard", "index"})  // /employee/home
	public String home() {
		// business logic
		
		return "employee-home";
	}
	
	// default method for parent level url
	@RequestMapping()
	public String defaultResponse() {
		// redirect control to another url (eg: /dashboard) ~sendRedirect
		return "redirect:/employee/home";
		// return "employee-home";
		// return "employee-base";
	}
	
	// fallback mapping (bad url)
	/*@RequestMapping("*")
	public String fallback() {
		// return "employee-error";
		return "redirect:/employee/home";
	}*/
	
	// show the entry form
	@RequestMapping("/profile")
	public String profile() {
		return "employee-profile-entry";
	}
	
	// recieve/save the profile info
	// by default support all HTTP VERBS
	/*@RequestMapping("/save-profile")
	public String saveProfile(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		System.out.println(name + " | " + email + " | " + contact);
		return "employee-profile-confirm";
	}*/
	
	// @RequestMapping(value = { "/save-profile"}, method = RequestMethod.POST)
	// Verb specific mapping
	// Servlet way
	/*@PostMapping("/save-profile")
	public String saveProfile(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		System.out.println("FROM POST :" + name + " | " + email + " | " + contact);
		return "employee-profile-confirm";
	}*/
	
	// Spring way
	/*@PostMapping("/save-profile")
	// public String saveProfile(String name, String email, String contact) {
	public String saveProfile(@RequestParam("name") String empName, 
							  @RequestParam String email, 
							  @RequestParam(value="contact", required = false, defaultValue = "111111" ) String contact) {		
		System.out.println("FROM POST :" + empName + " | " + email + " | " + contact);
		return "employee-profile-confirm";
	}*/
	
	// spring abstract way
	/*@PostMapping("/save-profile")
	public String saveProfile(Employee employee, Model model) {		
		// System.out.println("FROM POST :" + employee.getName() + " | " + employee.getEmail() + " | " + employee.getContact());

		// place the data in model container
		model.addAttribute("employee", employee);
		return "employee-profile-confirm";
	}*/
	
	// clubbed class : View Page name and model data
	@PostMapping("/save-profile")
	public ModelAndView saveProfile(Employee employee) {		
		// Create an instance of ModelAndView
		ModelAndView mv = new ModelAndView("employee-profile-confirm");
		// mv.setViewName("employee-profile-confirm");
		// place the data in model container
		mv.addObject("employee", employee);
		return mv;
	}
	
	@GetMapping("/save-profile")
	public String saveProfilePro(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		System.out.println("FROM GET :" + name + " | " + email + " | " + contact);
		return "employee-profile-confirm";
	}
}













