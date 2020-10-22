package com.wf.training.web.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wf.training.web.entity.Student;

/**
 * Servlet implementation class ProfileServ
 */
@WebServlet("/profile")
public class ProfileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// access/fetch the student data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		// any business logic : saving to db, validation check
		
		// assemble data a object
		Student student = new Student(name, email, contact);
		
		// 1. share this data with jsp page
		// 2. scope of access
		
		// request scope
		request.setAttribute("student", student);
		// Student stud1 = (Student) request.getAttribute("student");
		
		/*
		// session scope
		HttpSession session = request.getSession();
		session.setAttribute("student", student);
		Student stud2 = (Student) session.getAttribute("student");
		
		// application scope
		ServletContext context =  this.getServletContext();
		context.setAttribute("student", student);
		Student stud3 = (Student) context.getAttribute("student");
		*/
		
		// a jsp should respond  ( + dynamics)
		response.sendRedirect("profile-show.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
