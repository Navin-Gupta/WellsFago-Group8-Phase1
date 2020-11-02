package com.wf.training.mavenserv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wf.training.mavenserv.entity.Product;



public class ProductDao {

	private String driverName;
	private String url;
	private String username;
	private String password;
	
	private Connection connection;
	
	public ProductDao(String driverName, String url, String username, String password) {
		this.driverName = driverName;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	// connect
	private void connect() throws ClassNotFoundException, SQLException {
		if(this.connection == null || this.connection.isClosed()) {
			Class.forName(this.driverName);
			this.connection = DriverManager.getConnection(this.url,this.username,this.password);
		}
	}
	// disconnect
	private void disConnect() throws SQLException {
		if(this.connection!=null && !this.connection.isClosed())
			this.connection.close();
	}
	
	public List<Product> getAllProducts() throws SQLException, ClassNotFoundException{
		String sql = "select * from products";
		this.connect();
		
		Statement stmt = this.connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		// map it to our class
		List<Product> products = new ArrayList<Product>();
		while(rs.next()) {
			Product product = new Product(rs.getString(2),
											rs.getString(3),
											rs.getInt(4));
			products.add(product);
		}
		
		rs.close();
		stmt.close();
		this.disConnect();
		return products;
	}
	
	// add more methods for DAO activity
}




















