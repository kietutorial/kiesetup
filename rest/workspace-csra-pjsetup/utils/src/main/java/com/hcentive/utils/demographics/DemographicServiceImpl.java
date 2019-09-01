/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.demographics;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.hcentive.utils.demographics.domain.CountryPhoneCodes;
import com.hcentive.utils.demographics.domain.DemographicRules;
import com.hcentive.utils.demographics.domain.ZipCodes;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.ext.HXUtility;
import com.hcentive.utils.orm.dao.GenericDAO;
import com.hcentive.utils.search.service.SearchService;

@Transactional(readOnly = true)
public abstract class DemographicServiceImpl implements DemographicService {
	
	private static Logger logger = LoggerFactory.getLogger(DemographicServiceImpl.class);

	@Autowired
	@SuppressWarnings("rawtypes")
	protected GenericDAO genericDAO;

	@Autowired
	protected SearchService searchService;

	@Value("${database}")
	protected String database;

	protected DemographicDataHandlerLookup demographicDataHandlerLookup;
	// private static Logger logger =
	// LoggerFactory.getLogger(DemographicServiceImpl.class);
	protected Properties defaultProperties;
	protected static final MessageCode demo_GraphicService_County_LookUp_Failed = new MessageCode(
			"demoGraphicService.countyLookUp", "No County information found for input Zip.");
	protected String issuer;

	@Override
	@SuppressWarnings("unchecked")
	@Cacheable(value = "countyCache")
	public List<String> getCountiesByZip(String zip) throws HCException {
		logger.debug("Getting Counties for zip "+zip);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", zip);
		return genericDAO.findByNamedQuery("zipCodesList.findCountiesByCode", params);
	}

	@SuppressWarnings("unchecked")
	protected List<ZipCodes> getZipDetailsByZip(String zip) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", zip);
		return genericDAO.findByNamedQuery("zipCodesList.findByCode", params);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getAllStateCodes() throws HCException {

		// * PLATFORM-9618 *
		// QuerySearchRequest searchRequest =
		// SearchUtils.populateSearchRequest(database +
		// ".Meta.getAllStateCodes", null);
		// SearchResponse response = searchService.search(searchRequest);
		// return (List<String>) response.getResults();

		return genericDAO.findByNamedQuery("state.getAllStateCodes");
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getAllActiveStateCodes() throws HCException {

		// * PLATFORM-9618 *
		// QuerySearchRequest searchRequest =
		// SearchUtils.populateSearchRequest(database +
		// ".Meta.getAllActiveStateCodes", null);
		// SearchResponse response = searchService.search(searchRequest);
		// return (List<String>) response.getResults();

		return genericDAO.findByNamedQuery("state.getAllActiveStateCodes");
	}

	// @Cacheable(value = "zipDetailsCache")
	/*
	 * private Map<String, String> getZipDetailsByZipAndCounty(String zip,
	 * String county) throws HCException { Map<String, Object> params = new
	 * HashMap<String, Object>(); params.put("code", zip); params.put("county",
	 * county);
	 * 
	 * QuerySearchRequest searchRequest =
	 * SearchUtils.populateSearchRequest(database +
	 * ".Meta.zipDetailsByCodeAndCounty", params); SearchResponse response =
	 * searchService.search(searchRequest);
	 * 
	 * @SuppressWarnings("unchecked") List<Map<String, String>> result =
	 * (List<Map<String, String>>) response.getResults(); if (result != null &&
	 * result.size() > 0) { return result.get(0); } return null; }
	 */

	@SuppressWarnings("unchecked")
	@Override
	@Cacheable(value = "stateCache")
	public String getStateCode(String zip, String county) throws HCException {
		boolean criteriaZip = (HXUtility.isEmpty(zip)) ? false : true;
		boolean criteriaCounty = (HXUtility.isEmpty(county)) ? false : true;

		// * PLATFORM-9618 *
		/*
		 * Map<String, String> results = getZipDetailsByZipAndCounty(zip,
		 * county); if (results == null) { return null; } return
		 * WebUtils.getMapValueForKey(results, "STATE_CODE");
		 */

		Map<String, Object> params = new HashMap<String, Object>();

		if (criteriaZip && criteriaCounty) {
			params.put("code", zip);
			params.put("county", county.toUpperCase());
			List<ZipCodes> list = genericDAO.findByNamedQuery("zipCodesList.findByCodeAndCounty", params);
			if (list != null && list.size() > 0) {
				return list.get(0).getStateCode();
			}
		} else if (criteriaZip) {
			params.put("code", zip);
			List<ZipCodes> list = genericDAO.findByNamedQuery("zipCodesList.findByCode", params);
			if (list != null && list.size() > 0) {
				return list.get(0).getStateCode();
			}
		} else {
			params.put("county", county.toUpperCase());
			List<ZipCodes> list = genericDAO.findByNamedQuery("zipCodesList.findByCounty", params);
			if (list != null && list.size() > 0) {
				return list.get(0).getStateCode();
			}
		}
		return null;
	}

	@Override
	//@Cacheable(value = "zipCache")
	public boolean validateZip(String zip) throws HCException {
		List<ZipCodes> zipDetails = getZipDetailsByZip(zip);
		return zipDetails != null && !zipDetails.isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateZipAndCounty(String zip, String county) throws HCException {

		// * PLATFORM-9618 *
		// Map<String, String> results = getZipDetailsByZipAndCounty(zip,
		// county);
		// return results != null && !results.isEmpty();

		Map<String, Object> params = new HashMap<String, Object>();
		if (county != null && !county.isEmpty()) {
			params.put("code", zip);
			params.put("county", county);
			List<ZipCodes> list = genericDAO.findByNamedQuery("zipCodesList.findByCodeAndCounty", params);
			if (list != null && list.size() > 0) {
				return true;
			}
		} else {
			params.put("code", zip);
			List<ZipCodes> list = genericDAO.findByNamedQuery("zipCodesList.findByCode", params);
			if (list != null && list.size() > 0) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateStateCode(String stateCode) throws HCException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", stateCode);

		// * PLATFORM-9618 *
		// QuerySearchRequest searchRequest =
		// SearchUtils.populateSearchRequest(database +
		// ".Meta.stateDetailsByCode", params);
		// SearchResponse response = searchService.search(searchRequest);

		// @SuppressWarnings("unchecked")
		// List<Map<String, Object>> result = (List<Map<String, Object>>)
		// response.getResults();
		List<Map<String, Object>> result = genericDAO.findByNamedQuery("state.stateDetailsByCode", params);

		if (result != null && result.size() > 0) {
			return result.get(0) != null && !result.get(0).isEmpty();
		}
		return false;
	}

	@Override
	@Cacheable(value = "demographicCache")
	public DemographicRules getDemographicRules(String zip) throws HCException {
		DemographicRules dr = createAndintializeDefaultRules();// form property
																// files
		addDefaultDetails(dr, zip);// DB look up stuff

		String issuerKey = null;
		if (issuer != null && issuer.length() > 0) {
			dr.setCarrierCode(issuer);
			issuerKey = issuer;
		} else {
			issuerKey = "default";
		}

		if (dr.getCounties() == null) {
			throw new HCException(demo_GraphicService_County_LookUp_Failed);
		} else if (dr.getCounties().size() > 1) {
			DemographicDataHandler ddh = demographicDataHandlerLookup.getDemographicDataHandler(issuerKey);
			ddh.modifyDemographicData(dr);
		} else if (dr.getCounties().size() == 1) {
			addDefaultDetails(dr, zip, dr.getCounties().get(0));
			DemographicDataHandler ddh = demographicDataHandlerLookup.getDemographicDataHandler(issuerKey);
			ddh.modifyDemographicData(dr);
		}
		return dr;
	}

	protected DemographicRules createAndintializeDefaultRules() {
		DemographicRules dr = new DemographicRules();
		dr.setMaxCoveragestartDate(Integer.valueOf((String) defaultProperties.get("default.maxCoveragestartDate")));
		dr.setCurrentDate(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		dr.setAllowedCoverageStartDates(null); // we ensure that this is NULL.
		dr.setCarrierCode(null);
		return dr;
	}

	protected void addDefaultDetails(DemographicRules dr, String zip) {
		List<ZipCodes> zipDetailsList = getZipDetailsByZip(zip);
		List<String> counties = new ArrayList<String>();
		if (zipDetailsList != null && zipDetailsList.size() > 0) {
			for (ZipCodes zd : zipDetailsList) {
				counties.add(zd.getCounty());
			}
			if (counties.size() > 1) {
				Collections.sort(counties);
			}
			dr.setCounties(counties);
			dr.setZip(zip);
		}
	}

	@Override
	@Cacheable(value = "stateCache")
	public String getStateByZip(String zip) {
		List<ZipCodes> zipDetailsList = getZipDetailsByZip(zip);
		if (zipDetailsList != null && zipDetailsList.size() > 0) {
			for (ZipCodes zd : zipDetailsList) {
				return zd.getStateCode();
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected void addDefaultDetails(DemographicRules dr, String zip, String county) throws HCException {
		dr.setCounties(Arrays.asList(new String[] { county }));

		// * PLATFORM-9618 *
		/*
		 * Map<String, String> results = getZipDetailsByZipAndCounty(zip,
		 * county); String stateCode = WebUtils.getMapValueForKey(results,
		 * "STATE_CODE");// if there is a data error!! we have a problem String
		 * city = WebUtils.getMapValueForKey(results, "CITY");// if there is a
		 * data error!! we have a problem
		 */

		String stateCode = "";
		String city = "";
		Map<String, Object> params = new HashMap<String, Object>();
		if (county != null && !county.isEmpty()) {
			params.put("code", zip);
			params.put("county", county);
			List<ZipCodes> list = genericDAO.findByNamedQuery("zipCodesList.findByCodeAndCounty", params);
			if (list != null && list.size() > 0) {
				stateCode = list.get(0).getStateCode();
				city = list.get(0).getCity();
			}
		} else {
			params.put("code", zip);
			List<ZipCodes> list = genericDAO.findByNamedQuery("zipCodesList.findByCode", params);
			if (list != null && list.size() > 0) {
				stateCode = list.get(0).getStateCode();
				city = list.get(0).getCity();
			}
		}

		dr.setStateCode(stateCode);
		dr.setCity(city);
		dr.setZip(zip);
	}

	@Override
	@Cacheable(value = "demographicCache")
	public DemographicRules getDemographicRules(String zip, String county) throws HCException {
		DemographicRules dr = createAndintializeDefaultRules();// form property
																// files
		addDefaultDetails(dr, zip, county);

		String issuerKey = null;
		if (issuer != null && issuer.length() > 0) {
			dr.setCarrierCode(issuer);
			issuerKey = issuer;
		} else {
			issuerKey = "default";
		}
		DemographicDataHandler ddh = demographicDataHandlerLookup.getDemographicDataHandler(issuerKey);
		ddh.modifyDemographicData(dr);
		return dr;
	}

	@Override
	@Cacheable(value = "demographicCache")
	public DemographicRules getDemographicRulesByIssuerCode(String zip, String issuerCode) throws HCException {
		DemographicRules dr = createAndintializeDefaultRules();// form property
																// files
		addDefaultDetails(dr, zip);
		dr.setCarrierCode(issuerCode);
		String issuerKey = null;
		if (issuer != null && issuer.length() > 0) {
			issuerKey = issuer;
		} else {
			issuerKey = "default";
		}
		DemographicDataHandler ddh = demographicDataHandlerLookup.getDemographicDataHandler(issuerKey);
		ddh.modifyDemographicData(dr);
		return dr;
	}

	@Override
	@Cacheable(value = "demographicCache")
	public DemographicRules getDemographicRulesByIssuerCode(String zip, String county, String issuerCode) throws HCException {
		DemographicRules dr = createAndintializeDefaultRules();// form property
																// files
		addDefaultDetails(dr, zip, county);
		dr.setCarrierCode(issuerCode);
		String issuerKey = null;
		if (StringUtils.hasText(issuer)) {
			issuerKey = issuer;
		} else {
			issuerKey = "default";
		}
		DemographicDataHandler ddh = demographicDataHandlerLookup.getDemographicDataHandler(issuerKey);
		ddh.modifyDemographicData(dr);
		return dr;
	}

	@Override
	public String getCountryPhoneCodeByCountryCode(String countryCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("countryCode", countryCode);
		CountryPhoneCodes countryPhoneCodes = null;
		countryPhoneCodes = (CountryPhoneCodes) genericDAO.findObjectByNamedQuery("CountryPhoneCodes.getByCountryCode", params);
		if (countryPhoneCodes != null) {
			return countryPhoneCodes.getCountryPhoneCode();
		} else {
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean isValidStateCode(String state) throws HCException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("stateCode", state);
		Object stateCode = genericDAO.findObjectByNamedQuery("zipCodesList.findStateByStateCode", params);
		return !HXUtility.isEmpty( ObjectUtils.toString(stateCode) );
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public String getCountyBySrvcAreaRefCode(String countyCode) throws HCException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ukPlanSrvcAreaCdTxt", countyCode);
		return (String) genericDAO.findObjectByNamedQuery("srvcAreaRef.findCountyByCode", params);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public String getSrvcAreaRefCodeByCounty(String SrvcAreaRefCode) throws HCException {
		Map<String, Object> params = new HashMap<String, Object>();
		if(SrvcAreaRefCode!=null){
		SrvcAreaRefCode=SrvcAreaRefCode.toLowerCase();
		SrvcAreaRefCode = Character.toUpperCase(SrvcAreaRefCode.charAt(0)) + SrvcAreaRefCode.substring(1); 
		}
		params.put("planSrvcAreaDescTxt", SrvcAreaRefCode);
		return (String) genericDAO.findObjectByNamedQuery("srvcAreaRef.findSrvcAreaRefCodeByCounty", params);
	}
	
	
	public DemographicDataHandlerLookup getDemographicDataHandlerLookup() {
		return demographicDataHandlerLookup;
	}

	public void setDemographicDataHandlerLookup(DemographicDataHandlerLookup demographicDataHandlerLookup) {
		this.demographicDataHandlerLookup = demographicDataHandlerLookup;
	}

	public Properties getDefaultProperties() {
		return defaultProperties;
	}

	public void setDefaultProperties(Properties defaultProperties) {
		this.defaultProperties = defaultProperties;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
}
