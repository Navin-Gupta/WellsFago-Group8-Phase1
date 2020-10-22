package com.wf.training.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/login")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fetch/access the request data
		String logid = request.getParameter("logid");
		String password = request.getParameter("password");
		
		PrintWriter writer = response.getWriter();
		if(logid.contentEquals("admin") && password.contentEquals("admin")) {
			// respond with a pre-defined html file
			response.sendRedirect("welcome.html"); // static 
			
			// responding with on the fly html
			/*writer.write("<h1>Congratulations!</h1>");  // dynamic
			writer.write("<h2>Successfully logged in!</h2>");*/
		}else {
			response.sendRedirect("invalid.html");
			/*writer.write("<h1>Invalid Credentials!</h1>");
			writer.write("<h2>Please Re-login!</h2>");*/
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
