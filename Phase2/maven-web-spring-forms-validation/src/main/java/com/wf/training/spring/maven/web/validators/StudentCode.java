package com.wf.training.spring.maven.web.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


// where is the logic of this annotation + this is annotation for validation
@Constraint(validatedBy = StudentCodeConstraintValidator.class)
// Target : class,method,param...
@Target({ElementType.FIELD, ElementType.METHOD})
// retention policy (runtime/compile)
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentCode { // treat it as annotation

	// attributes(2)
	// attributes are declare as method
	// mandatory
	public String prefix();
	public String message();

	// boiler-plate requirements for validation annotation
	// two mandatory attribute
	
	// optional
	// chain multiple constraint
	public Class<?>[] groups() default {};
	
	// additional info about validations (severity level, error code..)
	public Class<? extends Payload>[] payload() default {};
}









