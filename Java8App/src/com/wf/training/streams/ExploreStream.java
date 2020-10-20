package com.wf.training.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.wf.training.repository.Student;
import com.wf.training.repository.StudentRepository;

public class ExploreStream {

	// Consumer : can consume a student object display only name
		static Consumer<Student> nameDisplay =
				student -> System.out.println(student.getName());
		
		// Consumer : can consume a student object display only activities
		static Consumer<Student> activityDisplay =
				student -> System.out.println(student.getActivities());		

				
		// Predicate: check if student is in grade > 2
		static Predicate<Student> gradeCheck = 
						student -> student.getGrade() > 2; 
				
		// Predicate: check if student is has gpa >=3.5
		static Predicate<Student> gpaCheck = 
						student -> student.getGpa() >= 3.5; 
								
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// fetch the stream (sequential)
		/*StudentRepository.getStudents()
					.stream().peek(student->System.out.println("Initiated :" + student))
					.filter(gradeCheck).peek(student->System.out.println("Ist filter :" + student))
					.filter(gpaCheck).peek(student->System.out.println("IInd filter :" + student))
					// .filter(gradeCheck.and(gpaCheck))
					.forEach(nameDisplay.andThen(activityDisplay));*/
		
		   // List<Student> filteredStudent = 
				   long count = StudentRepository.getStudents()
									.stream().peek(student->System.out.println("Initiated :" + student))
									.filter(gradeCheck).peek(student->System.out.println("Ist filter :" + student))
									.filter(gpaCheck).peek(student->System.out.println("IInd filter :" + student))
				   					.count();
									// .collect(Collectors.toList());
		   
		   // System.out.println(filteredStudent);
	}

}
