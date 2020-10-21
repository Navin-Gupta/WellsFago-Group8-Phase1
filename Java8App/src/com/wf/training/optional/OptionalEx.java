package com.wf.training.optional;

import java.util.Optional;

import com.wf.training.repository.Student;

public class OptionalEx {

	// method responsible for getting student record
	public static Student getStudent() {
		// logic to initiate student object
		Student student = null;
		return student;
	}
	
	// method responsible for getting student record
		public static Optional<Student> getStudentOptional() {
			// logic to initiate student object
			Student student = null;
			
			Optional<Student> optionalStudent = Optional.ofNullable(student);
			return optionalStudent;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Optional<Student> optionalStudent = getStudentOptional();
		
		// functional
		// Optional<String> name = optionalStudent.map(student -> student.getName());
		// String name = optionalStudent.map(student -> student.getName()).orElse("Default");
		/*String name = optionalStudent.map(student -> student.getName()).orElseGet(()->{
				// logic
				return "Default";
		});*/
		
		/*String name = optionalStudent.map(student -> student.getName()).orElseThrow(()->{
							// logic
							return new RuntimeException("No data found!!");
		});*/
		
		if(optionalStudent.isPresent()) {
			// fetch the data
			Student student = optionalStudent.get();
			String name = student.getName();
		}else {
			// logic 
			String name = "Default";
		}
		
		
		
		Student student = getStudent();
		if(student !=null) {
			String name = student.getName();
		}
	}

}
