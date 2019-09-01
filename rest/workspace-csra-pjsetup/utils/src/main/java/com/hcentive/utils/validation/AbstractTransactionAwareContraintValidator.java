package com.hcentive.utils.validation;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public abstract class AbstractTransactionAwareContraintValidator<A extends Annotation, T> implements ConstraintValidator<A, T> {

	@Autowired
	private PlatformTransactionManager txManager;

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		TransactionTemplate txTemplate = new TransactionTemplate(txManager);
		txTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		return (Boolean) txTemplate.execute(new TransactionCallback<Object>() {
			public Object doInTransaction(TransactionStatus status) {
				return validate(value, context);
			}
		});
	}

	abstract boolean validate(Object value, ConstraintValidatorContext context);

}
