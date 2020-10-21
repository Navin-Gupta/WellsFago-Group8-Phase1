package com.wf.training.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.wf.training.repository.Student;
import com.wf.training.repository.StudentRepository;

public class ParallelStream {

	// Predicate: check if student is in grade > 2
	static Predicate<Student> gradeCheck = 
					student -> student.getGrade() > 2; 
			
	// Predicate: check if student is has gpa >=3.5
	static Predicate<Student> gpaCheck = 
					student -> student.getGpa() >= 3.5; 
							
	
	
    // sequential stream
	public static List<Student> sequentialStream(){
		long start = System.currentTimeMillis();
		
		List<Student> filteredStudents = StudentRepository.getStudents()
						.stream().peek(student->System.out.println("Initiated :" + student))
						.filter(gradeCheck).peek(student->System.out.println("Ist filter :" + student))
						.filter(gpaCheck).peek(student->System.out.println("IInd filter :" + student))
						.collect(Collectors.toList());
		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Sequential Time : " + diff);
		
		return filteredStudents;
	}
	
	// parallel stream
	public static List<Student> parallelStream(){
		
		long start = System.currentTimeMillis();
		List<Student> filteredStudents = StudentRepository.getStudents()
						.parallelStream().peek(student->System.out.println("Initiated :" + student))
						.filter(gradeCheck).peek(student->System.out.println("Ist filter :" + student))
						.filter(gpaCheck).peek(student->System.out.println("IInd filter :" + student))
						.collect(Collectors.toList());
		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Parallel Time : " + diff);
		return filteredStudents;
	}
					
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sequential Result : " + sequentialStream());
		System.out.println("\n-----------------------\n");
		System.out.println("Parallel Result : " + parallelStream());
	}

}













