package com.hcentive.utils.validation;

import java.util.List;

import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.hcentive.utils.demographics.DemographicService;
import com.hcentive.utils.demographics.domain.DemographicRules;

public class ZipCountyStateValidator extends AbstractTransactionAwareContraintValidator<ZipCountyStateConstraint, Object> {

	private String zipField;

	private String countyField;

	private String stateField;

	@Autowired
	private DemographicService demographicService;

	private static Logger logger = LoggerFactory.getLogger(ZipCountyStateValidator.class);

	@Override
	public void initialize(ZipCountyStateConstraint zipCountyStateConstraintAnnotation) {
		this.zipField = zipCountyStateConstraintAnnotation.zip();
		this.countyField = zipCountyStateConstraintAnnotation.county();
		this.stateField = zipCountyStateConstraintAnnotation.state();
	}

	@Override
	public boolean validate(Object value, ConstraintValidatorContext context) {
		try {
			String zip = BeanUtils.getProperty(value, zipField);
			String county = BeanUtils.getProperty(value, countyField);
			String state = BeanUtils.getProperty(value, stateField);
			if (StringUtils.hasText(zip)) {
				List<String> countyList = demographicService.getCountiesByZip(zip);
				if ((countyList == null || countyList.isEmpty()) || (StringUtils.hasText(county) && !countyList.contains(county))) {
					return false;
				}
				DemographicRules demographicRules = demographicService.getDemographicRules(zip, county);
				String stateCode = demographicRules.getStateCode();
				if (!StringUtils.hasText(stateCode) || (StringUtils.hasText(state) && !stateCode.equalsIgnoreCase(state))) {
					return false;
				}
			}

		} catch (Exception ignore) {
			logger.error(ignore.getMessage());
		}
		return true;
	}

}
