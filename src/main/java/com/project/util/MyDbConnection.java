package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConnection {

	static Connection con;
	public static Connection getMyConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expenses","root","Piyush@2203");
			System.out.println("Connection established");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		getMyConnection();
	}
}
