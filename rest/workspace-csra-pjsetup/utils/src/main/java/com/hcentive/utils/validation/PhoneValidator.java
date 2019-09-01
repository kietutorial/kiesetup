package com.hcentive.utils.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.hcentive.utils.utils.ValidateUtils;

public class PhoneValidator implements ConstraintValidator<PhoneConstraint, String> {

	@Override
	public void initialize(PhoneConstraint constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty())
			return true;
		String trimmedValue = value.trim();
		return ValidateUtils.validatePhone(trimmedValue);
	}

}
