package com.wf.training.comparestyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(1,2,3,4,4,5,5,5,6,7,7,8,8,9);
		
		// Imperative style
		List<Integer> uniqueNumbers = new ArrayList<Integer>();
		for(Integer i : numbers) {
			if(!uniqueNumbers.contains(i)) {
				uniqueNumbers.add(i);
			}
		}
		
		System.out.println("Unique Numbers : " + uniqueNumbers);
		
		// Declarative style
		List<Integer> uniqueNumbersPro = numbers
										.stream()
										.distinct()
										.collect(Collectors.toList());
		System.out.println("Unique Numbers : " + uniqueNumbersPro);								
	}
}










