package com.hcentive.utils.hxid;

import com.hcentive.utils.exception.HCRuntimeException;
import com.hcentive.utils.hxid.service.Person;

public interface HXManageHXIDExt {

	public String findOrCreateHXId(Person person);

	public Person findByHXID(String hxid) throws HCRuntimeException;
	
	public void saveHXID(Person person) throws HCRuntimeException;
	
	public void updatePerson(Person person) throws HCRuntimeException;
}
