package com.hcentive.utils.validation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hcentive.utils.picklistprovider.PickListProvider;

public class PicklistValidator implements ConstraintValidator<PicklistConstraint, Object> {

	private boolean isMandatory;

	private String picklistName;

	private String separator;

	@Autowired
	private PickListProvider pickListProvider;

	@Override
	public void initialize(PicklistConstraint constraintAnnotation) {
		this.picklistName = constraintAnnotation.name();
		this.separator = constraintAnnotation.separator();
		this.isMandatory = constraintAnnotation.mandatory();
	}

	@Override
 	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value == null) {
			return !isMandatory;
		}
		Map<String, String> pickList = pickListProvider.getPickList(picklistName);
		Collection<String> keySet = pickList.keySet();
		List<String> valueList = null;

		if (value instanceof String) {
			valueList = Arrays.asList(((String) value).split(separator));
		} else if (value instanceof List) {
			valueList = (List) value;
		}

		return keySet.containsAll(valueList);

	}
}
