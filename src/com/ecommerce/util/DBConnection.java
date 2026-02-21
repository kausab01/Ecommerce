package com.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static Connection connection;
	public static Connection getconnection(){
		
		try{
			if(connection==null){
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db","root","Angel0951");
				System.out.println("Database Connected Successfully!");
			}	
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return connection;
		
	}
	 
	
	
	

}
