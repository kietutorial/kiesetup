package com.hcentive.utils.hxid.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcentive.eligibility.individual.domain.HXIDMaster;
import com.hcentive.utils.exception.HCRuntimeException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.ext.HXUtility;
import com.hcentive.utils.generator.IDGeneratorService;
import com.hcentive.utils.generator.IDType;
import com.hcentive.utils.hxid.service.HIXIDResponse.CONFIDENCE_LEVEL;
import com.hcentive.utils.orm.dao.GenericDAO;

/**
 * @author vgudipat
 *
 */
public class HXIDServiceImpl implements HXIDService {

	private IDGeneratorService idGeneratorService;

	public GenericDAO<HXIDMaster> getGenericDAO() {
		return genericDAO;
	}

	public void setGenericDAO(GenericDAO<HXIDMaster> genericDAO) {
		this.genericDAO = genericDAO;
	}

	private GenericDAO<HXIDMaster> genericDAO;
	private static Logger logger = LoggerFactory.getLogger(HXIDServiceImpl.class);

	
	@Override
	public Person getPersonByHXID(String hxid) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hxid", hxid);
		Person person = null;
		List<HXIDMaster> hxidmasters = genericDAO.findByNamedQuery("hxidmaster.findByhxid", map);
		if (CollectionUtils.isNotEmpty(hxidmasters)) {
			HXIDMaster hxidmaster = hxidmasters.get(0);
			if (hxidmaster != null) {
				person = new Person();
				try {
					BeanUtils.copyProperties(person, hxidmaster);
				} catch (Exception e) {
					throw new HCRuntimeException(MessageCode.GENERIC_ERROR, e);
				}
			}
		}
		return person;
	}
	
	@Override
	public HIXIDResponse findOrCreate(Person person) {

		HIXIDResponse hixidResponse = find(person);
		if (hixidResponse != null && !hixidResponse.getConLevel().equals(CONFIDENCE_LEVEL.CL_101))
			return hixidResponse;

		if (hixidResponse != null) {
			hixidResponse.setConLevel(null);
			hixidResponse.setFound(false);
			hixidResponse.setPersonsFound(null);
		}

		HXIDMaster hxidMaster = new HXIDMaster();

		try {
			BeanUtils.copyProperties(hxidMaster, person);
		} catch (Exception e) {

			throw new HCRuntimeException(MessageCode.GENERIC_ERROR, e);
		}
		if (HXUtility.isEmpty(person.getFirstName()) || HXUtility.isEmpty(person.getLastName()) || person.getDob() == null
				|| HXUtility.isEmpty(person.getGender()))
			throw new IllegalArgumentException();

		hxidMaster.setHxid(idGeneratorService.generateID(IDType.HIXID));
		hxidMaster = genericDAO.create(hxidMaster);
		person.setHxid(hxidMaster.getHxid());
		hixidResponse = new HIXIDResponse();
		hixidResponse.setPersonCreated(person);
		return hixidResponse;
	}

	@Override
	public HIXIDResponse find(Person person) {
		trimPerson(person);

		HIXIDResponse hixidResponse = null;
		
		if(!( HXUtility.isEmpty(person.getSsn()) || 
				  HXUtility.isNull(person.getSsn())) )
		{
			hixidResponse = evaluateforCL106(person);

			if (hixidResponse != null)
				return hixidResponse;

			hixidResponse = evaluateForCL104(person);

			if (hixidResponse != null)
				return hixidResponse;

			hixidResponse = evaluateForCL103(person);

			if (hixidResponse != null)
				return hixidResponse;

			hixidResponse = evaluateForCL102(person);

			if (hixidResponse != null)
				return hixidResponse;
		}
		
		hixidResponse = evaluateForCL101(person);

		return hixidResponse;

	}


	@Override
	public List<HIXIDResponse> findAllCL(Person person) {
		trimPerson(person);

		List<HIXIDResponse> hixidResponseList = new ArrayList<HIXIDResponse>();

		HIXIDResponse hixidResponseCL106 = evaluateforCL106(person);

		if (!HXUtility.isNull(hixidResponseCL106)) {
			hixidResponseList.add(hixidResponseCL106);
		}

		HIXIDResponse hixidResponseCL104 = evaluateForCL104(person);

		if (!HXUtility.isNull(hixidResponseCL104)) {

			if (!HXUtility.isNull(hixidResponseCL104) && !HXUtility.isNull(hixidResponseCL106)) {
				filterHIXIDResponse(hixidResponseCL104, hixidResponseCL106.getPersonsFound());
			}

			if (!HXUtility.isEmpty(hixidResponseCL104.getPersonsFound())) {
				hixidResponseList.add(hixidResponseCL104);
			}
		}

		HIXIDResponse hixidResponseCL103 = evaluateForCL103(person);

		if (!HXUtility.isNull(hixidResponseCL103)) {

			if (!HXUtility.isEmpty(hixidResponseCL103.getPersonsFound()) && !HXUtility.isNull(hixidResponseCL106)) {
				filterHIXIDResponse(hixidResponseCL103, hixidResponseCL106.getPersonsFound());
			}

			if (!HXUtility.isEmpty(hixidResponseCL103.getPersonsFound()) && !HXUtility.isNull(hixidResponseCL104)) {
				filterHIXIDResponse(hixidResponseCL103, hixidResponseCL104.getPersonsFound());
			}

			if (!HXUtility.isEmpty(hixidResponseCL103.getPersonsFound())) {
				hixidResponseList.add(hixidResponseCL103);
			}

		}
		
		
		HIXIDResponse hixidResponseCL102 = evaluateForCL102(person);

		if (!HXUtility.isNull(hixidResponseCL102)) {

			if (!HXUtility.isEmpty(hixidResponseCL102.getPersonsFound()) && !HXUtility.isNull(hixidResponseCL106)) {
				filterHIXIDResponse(hixidResponseCL102, hixidResponseCL106.getPersonsFound());
			}

			if (!HXUtility.isEmpty(hixidResponseCL102.getPersonsFound()) && !HXUtility.isNull(hixidResponseCL104)) {

				filterHIXIDResponse(hixidResponseCL102, hixidResponseCL104.getPersonsFound());
			}

			if (!HXUtility.isEmpty(hixidResponseCL102.getPersonsFound()) && !HXUtility.isNull(hixidResponseCL103)) {

				filterHIXIDResponse(hixidResponseCL102, hixidResponseCL103.getPersonsFound());
			}

			if (!HXUtility.isEmpty(hixidResponseCL102.getPersonsFound())) {
				hixidResponseList.add(hixidResponseCL102);
			}
		}
	
		HIXIDResponse hixidResponseCL101 = evaluateForCL101(person);

		if (!HXUtility.isNull(hixidResponseCL101)) {

			if (!HXUtility.isEmpty(hixidResponseCL101.getPersonsFound()) && !HXUtility.isNull(hixidResponseCL106)) {
				filterHIXIDResponse(hixidResponseCL101, hixidResponseCL106.getPersonsFound());
			}

			if (!HXUtility.isEmpty(hixidResponseCL101.getPersonsFound()) && !HXUtility.isNull(hixidResponseCL104)) {
				filterHIXIDResponse(hixidResponseCL101, hixidResponseCL104.getPersonsFound());
			}

			if (!HXUtility.isEmpty(hixidResponseCL101.getPersonsFound()) && !HXUtility.isNull(hixidResponseCL103)) {
				filterHIXIDResponse(hixidResponseCL101, hixidResponseCL103.getPersonsFound());
			}

			if (!HXUtility.isEmpty(hixidResponseCL101.getPersonsFound()) && !HXUtility.isNull(hixidResponseCL102)) {
				filterHIXIDResponse(hixidResponseCL101, hixidResponseCL102.getPersonsFound());
			}
			
			if (!HXUtility.isEmpty(hixidResponseCL101.getPersonsFound())) {
				hixidResponseList.add(hixidResponseCL101);
			}

		}

		return hixidResponseList;

	}
	
	
	public HIXIDResponse filterHIXIDResponse(HIXIDResponse hixIDResponse, List<Person> personHigherCLList) {

		List<Person> personToRemove = new ArrayList<Person>();
		List<Person> lowerCLPersonList = hixIDResponse.getPersonsFound();

		for (Person higherCLPerson : personHigherCLList) {

			for (Person lowerCLPerson : hixIDResponse.getPersonsFound()) {

				if (lowerCLPerson.getHxid().equals(higherCLPerson.getHxid())) {
					personToRemove.add(lowerCLPerson);
				}
			}
		}

		lowerCLPersonList.removeAll(personToRemove);

		return hixIDResponse;
	}
	
	
	private HIXIDResponse evaluateForCL101(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", isFNExactMatchRequired(person.getFirstName())? person.getFirstName() : person.getFirstName()+"%");
		map.put("lastName", isLNExactMatchRequired(person.getLastName())? person.getLastName() : person.getLastName()+"%");

		map.put("exactMatchFN", isFNExactMatchRequired(person.getFirstName())? "1" : "0");
		map.put("exactMatchLN", isLNExactMatchRequired(person.getLastName())? "1" : "0");
		
		map.put("dob", (person.getDob()));
		map.put("gender", (person.getGender()));

		List<HXIDMaster> hxixMasters = genericDAO.findByNamedQuery("hxidmaster.getbylastfirstnamesuffixdobsex", map); // 101

		if (hxixMasters.size() != 0) {
			HIXIDResponse hixidResponse = new HIXIDResponse();
			hixidResponse.setFound(true);
			hixidResponse.setConLevel(CONFIDENCE_LEVEL.CL_101);
			populatePersons(hxixMasters, hixidResponse);
			return hixidResponse;

		}
		return null;
	}

	private HIXIDResponse evaluateForCL102(Person person) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ssn", (person.getSsn()));
		map.put("dob", (person.getDob()));

		List<HXIDMaster> hxixMasters = genericDAO.findByNamedQuery("hxidmaster.getbyssndob", map); // 102

		if (hxixMasters.size() != 0) {
			HIXIDResponse hixidResponse = new HIXIDResponse();
			hixidResponse.setConLevel(CONFIDENCE_LEVEL.CL_102);
			hixidResponse.setFound(true);
			populatePersons(hxixMasters, hixidResponse);
			return hixidResponse;

		}
		return null;
	}

	private HIXIDResponse evaluateForCL103(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HXIDMaster> hxixMasters;
		
		if(person.getDob() == null){
			return null;
		}

		map.put("lastName", isLNExactMatchRequired(person.getLastName())? person.getLastName() : person.getLastName()+"%");
		map.put("exactMatchLN", isLNExactMatchRequired(person.getLastName())? "1" : "0");
		map.put("ssn", (person.getSsn()));
		Calendar cal = Calendar.getInstance();
		cal.setTime(person.getDob());
		map.put("startDateOfMonth", getFirstDateOfMonth(cal));
		map.put("lastDateOfMonth", getLastDateOfMonth(cal));
		
		
		hxixMasters = genericDAO.findByNamedQuery("hxidmaster.getbyssnlastnamepartialdob", map); // 103

		if (hxixMasters.size() != 0) {
			HIXIDResponse hixidResponse = new HIXIDResponse();
			hixidResponse.setConLevel(CONFIDENCE_LEVEL.CL_103);
			hixidResponse.setFound(true);
			populatePersons(hxixMasters, hixidResponse);
			return hixidResponse;

		}
		return null;
	}

	private HIXIDResponse evaluateForCL104(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HXIDMaster> hxixMasters;
		
		map.put("firstName", isFNExactMatchRequired(person.getFirstName())? person.getFirstName() : person.getFirstName()+"%");
		map.put("lastName", isLNExactMatchRequired(person.getLastName())? person.getLastName() : person.getLastName()+"%");
		map.put("ssn", (person.getSsn()));
		map.put("exactMatchFN", isFNExactMatchRequired(person.getFirstName())? "1" : "0");
		map.put("exactMatchLN", isLNExactMatchRequired(person.getLastName())? "1" : "0");

		hxixMasters = genericDAO.findByNamedQuery("hxidmaster.getbyssnlastnamefirstname", map); // 104

		if (hxixMasters.size() != 0) {
			HIXIDResponse hixidResponse = new HIXIDResponse();
			hixidResponse.setConLevel(CONFIDENCE_LEVEL.CL_104);
			hixidResponse.setFound(true);
			populatePersons(hxixMasters, hixidResponse);
			return hixidResponse;

		}
		return null;
	}

	private HIXIDResponse evaluateforCL106(Person person) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gender", (person.getGender()));
		map.put("dob", (person.getDob()));
		map.put("ssn", (person.getSsn()));
		map.put("firstName", isFNExactMatchRequired(person.getFirstName())? person.getFirstName() : person.getFirstName()+"%");
		map.put("lastName", isLNExactMatchRequired(person.getLastName())? person.getLastName() : person.getLastName()+"%");

		map.put("exactMatchFN", isFNExactMatchRequired(person.getFirstName())? "1" : "0");
		map.put("exactMatchLN", isLNExactMatchRequired(person.getLastName())? "1" : "0");

		List<HXIDMaster> hxixMasters = genericDAO.findByNamedQuery("hxidmaster.getbyallattributes", map); // 106

		if (hxixMasters.size() != 0) {
			HIXIDResponse hixidResponse = new HIXIDResponse();
			hixidResponse.setFound(true);
			hixidResponse.setConLevel(CONFIDENCE_LEVEL.CL_106);
			populatePersons(hxixMasters, hixidResponse);
			return hixidResponse;

		}
		return null;
	}

	private static Date getLastDateOfMonth(Calendar cal){
		cal.add(Calendar.MONTH, 1);  
		cal.set(Calendar.DAY_OF_MONTH, 1);  
		cal.add(Calendar.DATE, -1);
		return  cal.getTime();
	}
	
	private static Date getFirstDateOfMonth(Calendar cal){
		cal.set(Calendar.DAY_OF_MONTH, 1);  
		return  cal.getTime();
	}
	
	private void populatePersons(List<HXIDMaster> hxixMasters, HIXIDResponse hixidResponse) {

		for (HXIDMaster hxidMaster : hxixMasters) {

			Person aPerson = new Person();
			try {
				BeanUtils.copyProperties(aPerson, hxidMaster);
				hixidResponse.getPersonsFound().add(aPerson);
			} catch (Exception e) {
				logger.error("EXCEPTION", e);
				//e.printStackTrace();
			}
		}
	}

	private void trimPerson(Person person) {
		person.setFirstName(person.getFirstName() != null ? person.getFirstName().trim() : null);
		person.setMiddleName(person.getMiddleName() != null ? person.getMiddleName().trim() : null);
		person.setLastName(person.getLastName() != null ? person.getLastName().trim() : null);
		person.setSuffix(person.getSuffix() != null ? person.getSuffix().trim() : null);
		person.setGender(person.getGender() != null ? person.getGender().trim() : null);
		person.setSsn(person.getSsn() != null ? person.getSsn().trim() : null); 
	}

	public void setIdGeneratorService(IDGeneratorService idGeneratorService) {
		this.idGeneratorService = idGeneratorService;
	}

	private Boolean isFNExactMatchRequired(String name) {

		Boolean result = Boolean.FALSE;
		
		if(HXUtility.isNull(name)){
			return result;
		}

		if (name.length() < 10) {
			result = Boolean.TRUE;
		}

		return result;
	}

	private Boolean isLNExactMatchRequired(String name) {

		Boolean result = Boolean.FALSE;
		
		if(HXUtility.isNull(name)){
			return result;
		}

		if (name.length() < 17) {
			result = Boolean.TRUE;
		}

		return result;
	}
	
	@Deprecated
	public void saveHXID(Person person) {
		HXIDMaster hxidMaster = new HXIDMaster();

		try {
			BeanUtils.copyProperties(hxidMaster, person);
		} catch (Exception e) {

			throw new HCRuntimeException(MessageCode.GENERIC_ERROR, e);
		}
		if (HXUtility.isEmpty(person.getFirstName()) || HXUtility.isEmpty(person.getLastName()) || person.getDob() == null
				|| HXUtility.isEmpty(person.getGender()))
			throw new IllegalArgumentException();

		hxidMaster.setHxid(person.getHxid());
		genericDAO.create(hxidMaster);
	}
	
	@Override
	@Deprecated
	public void updatePerson(Person person) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hxid", person.getHxid());
		List<HXIDMaster> hxidmasters = genericDAO.findByNamedQuery("hxidmaster.findByhxid", map);
		HXIDMaster hxidMaster = hxidmasters.get(0);
			if(hxidMaster != null && person != null) {
			try {
				BeanUtils.copyProperties(hxidMaster, person);
			} catch (Exception e) {
	
				throw new HCRuntimeException(MessageCode.GENERIC_ERROR, e);
			}
			if (HXUtility.isEmpty(person.getFirstName()) || HXUtility.isEmpty(person.getLastName()) || person.getDob() == null
					|| HXUtility.isEmpty(person.getGender()))
				throw new IllegalArgumentException();
	
			genericDAO.update(hxidMaster);
		}
	}
	
	public List<String> findHXIDBySSNDOBFullName(Person person)
	{
		List<String> hxIdList = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ssn", (person.getSsn()));
		/*String dob=null;
		if(!HXUtility.isNull(person.getDob()))
		{
			dob=HXUtility.convertDateToString(person.getDob(), "yyyy-MM-dd");
		}*/
		String dob=getDOB(person.getDob());
		map.put("dob", dob);
		map.put("firstName", person.getFirstName());
		map.put("lastName", person.getLastName());

		List<HXIDMaster> hxixMasters = genericDAO.findByNamedQuery("hxidmaster.getbyssndobfullname", map);
		if(!HXUtility.isEmpty(hxixMasters))
		{
			for(HXIDMaster hxixMaster : hxixMasters) {
				hxIdList.add(hxixMaster.getHxid());
			}
		}
		return hxIdList;
	}
	
	/* VG:CR#1489
	 * B.	Find a match based on first four of the first name, first six of the last name, DOB, SSN.
	 */
	@Override
	public List<String> findHXIDBySSNDOBTruncatedFullName(Person person)
	{
		List<String> hxIdList = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		String firstName = person.getFirstName();
		String lastName = person.getLastName();
		boolean substrFirst = false;
		boolean substrLast = false;
		if(firstName != null && lastName != null && lastName.length()>=6 || firstName.length() >= 4){
			if(firstName.length() >= 4){
				firstName = firstName.substring(0,4);
				substrFirst=true;
			}				
			
			if(lastName.length() >= 6){
				lastName = lastName.substring(0,6);
				substrLast=true;
			}
			String matchingQueryToCall = "";
			if(substrFirst && substrLast){
				matchingQueryToCall = "hxidmaster.getbyssndobtruncatedfullname";
				//call substring for both first and lastname
			}
			else if (!substrFirst && substrLast){
				//call substring lastname
				//matchingQueryToCall = "hxidmaster.getbyssndobtruncatedfirstname";
				matchingQueryToCall = "hxidmaster.getbyssndobtruncatedlastname";
			}
			else if(substrFirst && !substrLast){
				
				matchingQueryToCall = "hxidmaster.getbyssndobtruncatedfirstname";
				//call substring firstname
			}
			else{
				// goto to step 3 call
				return null;
			}
			
			map.put("ssn", (person.getSsn()));
			//map.put("dob", (person.getDob()));
			String dob=getDOB(person.getDob());
			map.put("dob", dob);
			map.put("firstName", firstName);
			map.put("lastName", lastName);

			List<HXIDMaster> hxixMasters = genericDAO.findByNamedQuery(matchingQueryToCall, map);
			if(!HXUtility.isEmpty(hxixMasters))
			{
				for(HXIDMaster hxixMaster : hxixMasters) {
					hxIdList.add(hxixMaster.getHxid());
				}
			}
		}
		
		return hxIdList;
	}
	
	/*
	 * VG:CR#1489 C. Find a match based on SSN, DOB, Gender
	 */
	@Override
	public List<String> findHXIDBySSNDOBGender(Person person) {
		List<String> hxIdList = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ssn", (person.getSsn()));
		//map.put("dob", (person.getDob()));
		String dob=getDOB(person.getDob());
		map.put("dob", dob);
		map.put("gender", (person.getGender()));
	
		List<HXIDMaster> hxixMasters = genericDAO.findByNamedQuery(
				"hxidmaster.getbyssndobGender", map);

		if (!HXUtility.isEmpty(hxixMasters)) {
			for (HXIDMaster hxixMaster : hxixMasters) {
				hxIdList.add(hxixMaster.getHxid());
			}
		}

		return hxIdList;

	}
	
	public String getDOB(Date dob) {
		String rtnDOB = null;
		if (!HXUtility.isNull(dob)) {
			rtnDOB = HXUtility.convertDateToString(dob, "yyyy-MM-dd");
		}
		return rtnDOB;
	}	
}
