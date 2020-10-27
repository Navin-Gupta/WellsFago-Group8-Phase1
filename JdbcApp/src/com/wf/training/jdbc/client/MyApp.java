package com.wf.training.jdbc.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// load the DB driver class in memory
			Class.forName("com.mysql.jdbc.Driver");
			// set up connection
			// DriverManager.getConnection("<url>","<username>","<password>");
			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
			// By default get an open connection
			
			// create a statement
			// Customize the ResultSet behavior
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
														ResultSet.CONCUR_UPDATABLE);
			
			
			
			
			
			// Transaction Block
			try {
				// to set auto commit off
				connection.setAutoCommit(false);
				// all changes will be affective in view
				stmt.executeUpdate(""); 
				stmt.executeUpdate("");
				stmt.executeUpdate("");
				stmt.executeUpdate("");
				stmt.executeUpdate("");
				stmt.executeUpdate("");
				
				connection.commit(); // update the actual table
			}catch(Exception ex) {
				// rollback the effect
				connection.rollback();
			}finally {
				connection.setAutoCommit(true);
			}
			
			
			
			
			
			// Batch 
			stmt.clearBatch();
			stmt.addBatch(""); // insert/update/delete
			stmt.addBatch("");
			stmt.addBatch("");
			stmt.addBatch("");
			stmt.addBatch("");
			stmt.addBatch("");
			
			int arr[] = stmt.executeBatch();
			
			stmt.clearBatch();
			stmt.addBatch("");
			
			
			
			// Prepared Statement : predefined templated query
			// Preffered 
			PreparedStatement pstmt =  connection
					.prepareStatement("insert into employee (empname,email,age) values(?,?,?)");
			
			// insert into employee (empname,email,age) values('" + name + "','" + email + "'," + age + ")"
			
			// similar req multiple time, multiple set of data
			// embedding dynamic data becomes easier
			// Lengthy complex queries, template mode is preferred
			// Easily modify a frequently used query, from one location
			// Much easier to handle dialect
			// Can eliminate the possibility of SQL INJECTIONS
			
			
			// plugin data in placeholders
			pstmt.setString(1, ""); // ',;--
			pstmt.setString(2, "");
			pstmt.setInt(3, 23);
			
			
			// fire the query
			pstmt.executeUpdate();
			
			
			
			
			// SQL Queries
			// int n = stmt.executeUpdate(""); // DMQ/DDL : insert,update,delete
			// n : number of rows affected : DMQ
			// DDL : status code
			
			ResultSet rs = stmt.executeQuery("select * from employee"); // select
			
			// Navigation : return boolean
			rs.next();
			rs.previous();
			rs.first();
			rs.last();
			rs.beforeFirst();
			rs.afterLast();
			rs.relative(2); // forward
			rs.relative(-2); // backward
			rs.absolute(3); // 4 record
			
			
			// Updating the record
			
			// Cursor must at active link
			rs.updateString(2, ""); // views 
			rs.updateString(3, "");
			rs.updateRow(); // commit changes to actual table
			rs.refreshRow(); // refresh the RS
			
			
			// Deleting the record
			
			// Cursor must be at active link
			rs.deleteRow();
			rs.refreshRow();
			
			// Inserting a record
			
			// Cursor may be at any location
			rs.insertRow(); //blank row
			rs.moveToInsertRow();
			rs.updateString(2, ""); // views 
			rs.updateString(3, "");
			rs.updateRow(); // commit changes to actual table
			rs.refreshRow(); // refresh the RS
			rs.moveToCurrentRow(); // cursor goes back to original/old location
			
			
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) 
								+ " | " + rs.getString(2) 
								+ " | " + rs.getString(3) 
								+ " | " + rs.getInt(4));
			}
			
			
			// move the cursor one step
			/*if(rs.next()) {
				String name = rs.getString("empname");
				// or
				String data = rs.getString(1); // 1 based indexing
			}
			
			while(rs.next()) {
				// new record in each iteration
			}*/
			
			
			rs.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
