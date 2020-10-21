package com.wf.training.streams;

import java.util.stream.IntStream;

public class CalculatorClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calculator = new Calculator();
		
		// Sequential 
		/*IntStream.rangeClosed(1, 1000)
			.forEach(value -> calculator.performSum(value));
		System.out.println("Sequential Result : " + calculator.getResult());*/
		
		// Parallel
		IntStream.rangeClosed(1, 1000).parallel()
			.forEach(value -> calculator.performSum(value));
		System.out.println("Parallel Result : " + calculator.getResult());
	}

}
