package com.hcentive.utils.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
	
	private static Logger logger = LoggerFactory.getLogger(FieldMatchValidator.class);
	
	private String first;
	private String second;

	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		first = constraintAnnotation.first();
		second = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			Object firstfield = BeanUtils.getProperty(value, first);
			Object secondfield = BeanUtils.getProperty(value, second);
			if (secondfield != null && firstfield != null) {
				return secondfield.equals(firstfield);
			} else if (secondfield == null && firstfield == null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.error("EXCEPTION", e);
		}
		return false;
	}

}
