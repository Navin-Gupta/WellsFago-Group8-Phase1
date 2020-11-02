package com.wf.training.patterns.factory;

enum CoordinateSystem{
	CARTESIAN,
	POLAR
}

// should be able to create point Cartesian,Polar
class Point{
	private double x,y;
	
	public Point(double x, double y) {
		this.x= x;
		this.y = y;
	}
	
	public Point(double x, double y, CoordinateSystem cs) {
		switch(cs) {
		case CARTESIAN :
			this.x = x;
			this.y = y;
			break;
		case POLAR :
			this.x= x * Math.cos(y);
			this.y = x * Math.sin(y);
			break;
		}
	}
	
	// factory methods
	public static Point newCartesianPoint(double x, double y) {
		return new Point(x, y);
	}
	
	public static Point newPolarPoint(double x, double y) {
		return new Point(x * Math.cos(y), x * Math.sin(y));
	}
}

public class MyApp {
	public static void main(String args[]) {
		// old way
		Point point = new Point(2, 3, CoordinateSystem.CARTESIAN);
		
		// factory way
		Point polarPoint = Point.newPolarPoint(1, 2);
		
	}
}














