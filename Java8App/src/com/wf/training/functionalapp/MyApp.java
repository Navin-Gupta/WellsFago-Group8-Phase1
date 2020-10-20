package com.wf.training.functionalapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;


class UpperCaseConsumer implements Consumer<String>{

	@Override
	public void accept(String str) {
		// TODO Auto-generated method stub
		System.out.println(str.toUpperCase());
	}
	
}


public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initiate a collection
		List<String> names = new ArrayList<String>();
		names.add("First");
		names.add("Second");
		names.add("Third");
		names.add("Fourth");
		
		// counter based loops
		/*for(int i=0;i<names.size();i++) {
			System.out.println(names.get(i));
		}*/
		
		// enhanced for loop
		/*for(String name : names) {
			System.out.println(name);
		}*/
		
		// iterator based : editable since 1.5
		// fetch an iterator from collection
		/*Iterator<String> iterator =  names.iterator();
		while(iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}*/
		
		// new methods have been added in API to support function programming
		// walkthrough function
		// names.forEach(<Consumer>);
		
		// OOPs
		/*
		UpperCaseConsumer upConsumer = new UpperCaseConsumer();
		names.forEach(upConsumer);
		*/
		
		// functional
		/*
		Consumer<String> nameConsumer =
					name -> System.out.println(name);
		names.forEach(nameConsumer);
		*/
		// names.forEach(name -> System.out.println(name));
		
		// method reference
		names.forEach(System.out :: println);
		
	}

}




