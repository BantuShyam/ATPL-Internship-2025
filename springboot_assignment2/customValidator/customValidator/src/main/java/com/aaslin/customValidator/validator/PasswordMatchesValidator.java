package com.aaslin.customValidator.validator;

import com.aaslin.customValidator.annotation.PasswordMatches;
import com.aaslin.customValidator.dto.UserRegistration;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,UserRegistration> {

	@Override
	public boolean isValid(UserRegistration dto, ConstraintValidatorContext context) {
		if(dto.getPassword()==null || dto.getConfirmPassword()==null) {
			return false;
		}
		return dto.getPassword().equals(dto.getConfirmPassword());
		
	}
	

}
