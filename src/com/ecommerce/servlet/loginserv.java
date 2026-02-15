package com.ecommerce.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDAO;

@WebServlet("/loginserv")
public class loginserv extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String email = request.getParameter("email");
	     String password = request.getParameter("password");

	        User user = UserDAO.loginUser(email, password);

	        if (user != null) {
	            HttpSession session = request.getSession();
	            session.setAttribute("user", user);

	            response.sendRedirect("home.jsp");
	        } else {
	            response.getWriter().println("Invalid Credentials");
	        }
		
		
		
	}

}
