package com.hcentive.utils.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ZipCountyStateValidator.class)
public @interface ZipCountyStateConstraint {

	String message() default "Invalid zip, state and county combination";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String zip() default "zip";

	String county() default "county";

	String state() default "state";

}
