/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.demographics;

import java.util.List;
import java.util.Set;

import com.hcentive.utils.demographics.domain.DemographicRules;
import com.hcentive.utils.demographics.domain.ext.HXCounty;
import com.hcentive.utils.demographics.ext.DemographicServiceExt;
import com.hcentive.utils.exception.HCException;

public interface DemographicService extends DemographicServiceExt {

	public String getStateCode(String zip, String county) throws HCException;

	public boolean validateZip(String zip) throws HCException;

	public boolean validateZipAndCounty(String zip, String county) throws HCException;

	public List<String> getCountiesByZip(String zip) throws HCException;

	public boolean validateStateCode(String stateCode) throws HCException;

	public DemographicRules getDemographicRules(String zip) throws HCException;

	public DemographicRules getDemographicRules(String zip, String county) throws HCException;

	public List<String> getAllStateCodes() throws HCException;

	public List<String> getAllActiveStateCodes() throws HCException;

	public String getStateByZip(String zip);

	DemographicRules getDemographicRulesByIssuerCode(String zip, String county, String issuerCode) throws HCException;

	DemographicRules getDemographicRulesByIssuerCode(String zip, String issuerCode) throws HCException;

	public String getCountryPhoneCodeByCountryCode(String country);

	List<String> getCountiesByZipSet(Set<String> zip) throws HCException;
	
	public boolean isValidStateCode(String state) throws HCException;
	
	public String getCountyBySrvcAreaRefCode(String countyCode) throws HCException;
	
	public String getSrvcAreaRefCodeByCounty(String SrvcAreaRefCode) throws HCException;
}
