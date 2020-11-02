package com.wf.training.mavenserv.business;

public class BusinessResource {
	
	public int calculateSum(int[] numbers) {
		int sum = 0;
		for(int i : numbers) {
			sum += i;
		}
		return sum;
	}
}
