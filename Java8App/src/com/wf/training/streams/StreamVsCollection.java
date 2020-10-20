package com.wf.training.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initiate a collection
		List<String> names = new ArrayList<String>();
		names.add("First");
		names.add("Second");
		names.add("Third");
		names.add("Fourth");
		
		// operation directly over collection
		names.forEach(System.out :: println);
		names.forEach(System.out :: println);
		
		System.out.println("\n-----------------------\n");
		
		// operation over streams
		// create /fetch the stream
		Stream<String> namesStream =  names.stream();
		namesStream.forEach(System.out :: println);
		
		// not re-usable
		namesStream.forEach(System.out :: println);
		
	}

}
