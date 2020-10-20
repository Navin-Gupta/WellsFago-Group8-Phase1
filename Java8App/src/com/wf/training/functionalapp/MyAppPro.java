package com.wf.training.functionalapp;

import java.util.function.Consumer;
import java.util.function.Predicate;

import com.wf.training.repository.Student;
import com.wf.training.repository.StudentRepository;

public class MyAppPro {

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
							
					
	// display names of all students
	static void displayNames() {
		StudentRepository.getStudents().forEach(nameDisplay);
	}
	
	// display activities of all students
	static void displayActivities() {
		StudentRepository.getStudents().forEach(activityDisplay);
	}
	
	// display name and activities of all students
	static void displayNameAndActivities() {
		/*
		StudentRepository.getStudents().forEach(nameDisplay);
		StudentRepository.getStudents().forEach(activityDisplay);
		*/
		StudentRepository.getStudents().forEach(nameDisplay.andThen(activityDisplay));
	}
	
	// display name and activities of students having grade greater than 2
	static void displayNameAndActivitiesConditional() {
		
		StudentRepository.getStudents().forEach(student -> {
									// if(student.getGrade() > 2) {
									if(gradeCheck.and(gpaCheck).test(student)) {
										// nameDisplay.accept(student);
										// activityDisplay.accept(student);
										nameDisplay.andThen(activityDisplay).accept(student);
									}
								});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// displayNames();
		// displayActivities();
		// displayNameAndActivities();
		displayNameAndActivitiesConditional();

	}

}
