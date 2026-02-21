package com.ecommerce.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.UserDAO;
import com.ecommerce.model.User;


@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String pass=request.getParameter("pass");
		
		User user=new User(name, mail, pass);
	
		boolean status = false;
		try {
			status = UserDAO.registeruser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(status){
			response.sendRedirect("login.jsp");
		}
		else{
			response.sendRedirect("register.jsp");
		}
		
		
		
		
		
		
	}

}
