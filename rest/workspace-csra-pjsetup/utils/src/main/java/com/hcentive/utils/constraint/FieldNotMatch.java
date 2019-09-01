/**
 * 
 */
package com.hcentive.utils.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Sunil Chauhan
 * 
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldNotMatchValidator.class)
@Documented
public @interface FieldNotMatch {
	String message() default "{com.hcentive.utils.constraint.fieldNotMatch.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * @return The another field
	 */
	String first();

	String second();

	/**
	 * Defines several <code>@FieldNotMatch</code> annotations on the same
	 * element
	 * 
	 * @see FieldNotMatch
	 */
	@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		FieldNotMatch[] value();
	}
}
