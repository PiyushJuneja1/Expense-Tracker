package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.model.Expense;
import com.project.util.MyDbConnection;

public class ExpenseDaoImpl implements ExpenseDao{
	Connection con;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	
	@Override
	public void addExpense(Expense exp) {
		try {
			con = MyDbConnection.getMyConnection();
			con.setAutoCommit(false);
			
			psmt=con.prepareStatement(
				"Insert into expenses(name,amount,category,date,mode) VALUES (?,?,?,?,?)"
			);
			
			psmt.setString(1, exp.getName());
			psmt.setDouble(2,exp.getAmount());
			psmt.setString(3, exp.getCategory());
			psmt.setString(4, exp.getDate());
			psmt.setString(5, exp.getMode());
			
			int rows = psmt.executeUpdate();
			System.out.println(rows+"Row(s) Inserted");
			con.commit();
		}catch(SQLException e) {
			try {
				if(con!=null)con.rollback();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			closeResources();
		}
	}
	
	@Override
	public void showExpenses() {
		try {
			con=MyDbConnection.getMyConnection();
			stmt= con.createStatement();
			rs= stmt.executeQuery("SELECT * FROM expenses");
			while(rs.next()) {
				System.out.println("Name :"+rs.getString("name"));
				System.out.println("Amount :"+rs.getDouble("amount"));
				System.out.println("Category :"+rs.getString("category"));
				System.out.println("Date :"+rs.getString("date"));
				System.out.println("Mode :"+rs.getString("mode"));
				System.out.println("------------------------------------");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
	}
	
	@Override
	public void totalExpense() {
		try {
			con=MyDbConnection.getMyConnection();
			stmt = con.createStatement();
	        rs = stmt.executeQuery("SELECT SUM(amount) AS total FROM expenses");
	        
	        if (rs.next()) {
	            double total = rs.getDouble("total");
	            System.out.println("Total Expense = " + total);
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeResources();
	    }
		
	}
	 private void closeResources() {
	        try { if(rs != null) rs.close(); } catch(Exception e) {}
	        try { if(psmt != null) psmt.close(); } catch(Exception e) {}
	        try { if(stmt != null) stmt.close(); } catch(Exception e) {}
	        try { if(con != null) con.close(); } catch(Exception e) {}
	    }
}
