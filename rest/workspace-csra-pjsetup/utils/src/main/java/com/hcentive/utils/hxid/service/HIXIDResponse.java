package com.hcentive.utils.hxid.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hcentive.utils.ext.HXUtility;

public class HIXIDResponse {

	public static enum CONFIDENCE_LEVEL {
		CL_106, CL_104, CL_103, CL_102, CL_101, CL_100098, CL_100097, CL_100096, CL_100095,CL_99,CL_100087
	};

	private CONFIDENCE_LEVEL conLevel;

	private boolean isFound = false;

	private List<Person> personsFound = new ArrayList<Person>();
	
	private boolean shopOverride=false;
	
	private  List<String> ProababilistichixIDs = new ArrayList<String>();

	private Person personCreated;

	private boolean IsProbabilisticSearchResult=false;

	private boolean pastAvailableStatus = false;
	
	
	public boolean isPastAvailableStatus() {
		return pastAvailableStatus;
	}

	public void setPastAvailableStatus(boolean pastAvailableStatus) {
		this.pastAvailableStatus = pastAvailableStatus;
	}

	public boolean isIsProbabilisticSearchResult() {
		return IsProbabilisticSearchResult;
	}

	public void setIsProbabilisticSearchResult(boolean isProbabilisticSearchResult) {
		IsProbabilisticSearchResult = isProbabilisticSearchResult;
	}

	public CONFIDENCE_LEVEL getConLevel() {
		return conLevel;
	}

	public void setConLevel(CONFIDENCE_LEVEL conLevel) {
		this.conLevel = conLevel;
	}

	public boolean isFound() {
		return isFound;
	}

	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}

	public List<Person> getPersonsFound() {
		return personsFound;
	}
	public Person getThePersonFound() {
		for(Person person:personsFound){
			if(person.isFoundinprevious_elg_enrl()){
				return person;
			}
		}
		return personsFound.get(0);
	}
	public void setPersonsFound(List<Person> personsFound) {
		this.personsFound = personsFound;
	}

	public Person getPersonCreated() {
		return personCreated;
	}

	public void setPersonCreated(Person personCreated) {
		this.personCreated = personCreated;
	}
	public List<String> getProababilistichixIDs() {
		return ProababilistichixIDs;
	}

	public void setProababilistichixIDs(List<String> proababilistichixIDs) {
		ProababilistichixIDs = proababilistichixIDs;
	}

	public boolean isShopOverride() {
		return shopOverride;
	}

	public void setShopOverride(boolean shopOverride) {
		this.shopOverride = shopOverride;
	}
	
}
