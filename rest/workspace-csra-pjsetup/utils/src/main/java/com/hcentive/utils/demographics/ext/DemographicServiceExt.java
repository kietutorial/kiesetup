package com.hcentive.utils.demographics.ext;

import com.hcentive.utils.exception.HCException;

public interface DemographicServiceExt {
	public String getCountyNameByCountyCode(String countyCode) throws HCException;

	/**
	 * getHXStateCode function will lookup state code based on zip code and
	 * county FIPS code
	 * 
	 * @param String
	 *            zip
	 * @param String
	 *            countyCode
	 * 
	 * @return String - State Code
	 * 
	 * @throws HCException
	 */
	public String getHXStateCode(String zip, String countyCode) throws HCException;
}
