package com.wf.training.changestyle;

public interface ICheck {

	public void fun();
	
	default public void test() {
		System.out.println("Inside default definition of interface");
	}
	
	public static void sfun() {
		System.out.println("Inside static definition of interface");
	}
}
