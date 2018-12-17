package com.luv2code.springsecurity.demo.Custvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeContraintValidator implements ConstraintValidator<CourseContent, String> {

	private String coursePrefix;
	@Override
	public void initialize(CourseContent cc) {
		coursePrefix = cc.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		if(theCode!= null) {
			return theCode.startsWith(coursePrefix);
		}
		return false;
	}

}
