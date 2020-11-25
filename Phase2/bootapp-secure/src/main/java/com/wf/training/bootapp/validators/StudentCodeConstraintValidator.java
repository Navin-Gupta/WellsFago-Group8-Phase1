package com.wf.training.bootapp.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StudentCodeConstraintValidator 
		implements ConstraintValidator<StudentCode, String>{

	private String expectedPrefix;
	// allows to access attribute values
	@Override
	public void initialize(StudentCode constraintAnnotation) {
		this.expectedPrefix = constraintAnnotation.prefix();
	}
	
	@Override
	public boolean isValid(String userValue, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		// logic to test the data 
		// userValue must begin with a particular prefix
		if(userValue.startsWith(expectedPrefix))
			return true;
		return false;
	}

	
}
