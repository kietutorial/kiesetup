package com.hcentive.utils.demographics.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.cache.annotation.Cacheable;

import com.hcentive.utils.demographics.DemographicServiceImpl;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.ext.HXConstants;
import com.hcentive.utils.search.model.QuerySearchRequest;
import com.hcentive.utils.search.model.SearchResponse;
import com.hcentive.utils.search.util.SearchUtils;
import com.hcentive.utils.web.WebUtils;

public class DemographicServiceImplExt extends DemographicServiceImpl {

	@Cacheable(value = "commoncache")
	public String getCountyNameByCountyCode(String countyCode) throws HCException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", countyCode);

		QuerySearchRequest searchRequest = SearchUtils.populateSearchRequest(database + ".Meta.getCountyNameByCountyCode", params);
		SearchResponse response = searchService.search(searchRequest); 

		@SuppressWarnings("unchecked")
		List<String> result = (List<String>) response.getResults();
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	/**
	 * getHXStateCode function will lookup state code based on zip code and
	 * county FIPS code.
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
	@Override
	@Cacheable(value = "commoncache")
	public String getHXStateCode(String zip, String countyCode) throws HCException {
		Map<String, String> results = getHXZipDetailsByZipAndCountyCode(zip, countyCode);
		if (results == null) {
			return null;
		}
		return (String) WebUtils.getMapValueForKey(results, "STATE_CODE");
	}

	/**
	 * getHXZipDetailsByZipAndCountyCode function will lookup all state codes
	 * based on zip code and county FIPS code and returns first row only.
	 * 
	 * @param String
	 *            zip
	 * @param String
	 *            countyCode
	 * 
	 * @return Map<String, String> - State Codes Map
	 */
	@Cacheable(value = "commoncache")
	private Map<String, String> getHXZipDetailsByZipAndCountyCode(String zip, String countyCode) throws HCException {

		Map<String, Object> params = new HashMap<String, Object>();
		QuerySearchRequest searchRequest = null;
		params.put("county", countyCode);
		if (zip == null || "".endsWith(zip.trim())) {
			searchRequest = SearchUtils.populateSearchRequest(database + ".Meta.hxZipDetailsByCountyCode", params);
		} else {
			params.put("code", zip);
			searchRequest = SearchUtils.populateSearchRequest(database + ".Meta.hxZipDetailsByCodeAndCountyCode", params);
		}

		SearchResponse response = searchService.search(searchRequest);

		@SuppressWarnings("unchecked")
		List<Map<String, String>> result = (List<Map<String, String>>) response.getResults();
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Cacheable(value = "commoncache")
	public List<String> getCountiesByZipSet(Set<String> zipSet) throws HCException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("codeSet", zipSet);
		params.put("stateCode", HXConstants.NYS_STATE_CODE);
		return genericDAO.findByNamedQuery("zipCodesList.findNyCountiesByZipSet", params);
	}
}
