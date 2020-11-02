package com.wf.training.mavenserv.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.training.mavenserv.dao.ProductDao;



/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductDao productDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

      
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String driver = config.getServletContext().getInitParameter("jdbcDriver");
    	String url = config.getServletContext().getInitParameter("jdbcUrl");
    	String username = config.getServletContext().getInitParameter("jdbcUsername");
    	String password = config.getServletContext().getInitParameter("jdbcPassword");
    	
    	this.productDao = new ProductDao(driver, url, username, password);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fetch the action param
		String action = request.getParameter("action");
		String responseRes = "";
		try {
			switch(action) {
			case "add" : break;
			case "delete" : break;
			default : responseRes = "main-menu.jsp"; 
				break;
			}
		}catch(Exception ex) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(responseRes);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



