package com.hcentive.utils.hxid.service;

import java.util.List;

public interface HXIDService {

	public HIXIDResponse findOrCreate(Person person);

	public HIXIDResponse find(Person person);

	public Person getPersonByHXID(String hxid);
	
	public List<HIXIDResponse> findAllCL(Person person);
	
	public void saveHXID(Person person);

	public void updatePerson(Person person);
	
	public List<String> findHXIDBySSNDOBFullName(Person person);
	
	public List<String> findHXIDBySSNDOBTruncatedFullName(Person person);
	
	public List<String> findHXIDBySSNDOBGender(Person person);
	
}
