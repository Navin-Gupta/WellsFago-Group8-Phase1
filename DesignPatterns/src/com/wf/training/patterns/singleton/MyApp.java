package com.wf.training.patterns.singleton;

class DbConnection{
	private static DbConnection instance;
	// block the object created
	private DbConnection() {}
	
	// create an object
	// invoked only once
	static {
		instance = new DbConnection();
	}
	
	// expose object
	public static DbConnection getInstance() {
		return instance;
 	}
	
	// all regular resource
	
}


public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConnection conn = DbConnection.getInstance();
	}

}
