package com.hcentive.utils.hxid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hcentive.utils.exception.HCRuntimeException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.hxid.service.HIXIDResponse;
import com.hcentive.utils.hxid.service.HXIDService;
import com.hcentive.utils.hxid.service.Person;

public class HXManageHXIDImplExt implements HXManageHXIDExt {

	@Autowired
	protected HXIDService hxidServiceImpl;

	/**
	 * Function to find and create NYHX ID
	 * 
	 * @param person
	 * @return
	 */
	
	@Override
	@Transactional(readOnly = false)
	public Person findByHXID(String hxid) throws HCRuntimeException {
		return hxidServiceImpl.getPersonByHXID(hxid);
	}
	
	
	@Override
	@Transactional(readOnly = false)
	public String findOrCreateHXId(Person person) throws HCRuntimeException {
		HIXIDResponse hixIdResponse = hxidServiceImpl.findOrCreate(person);

		List<Person> persons = hixIdResponse.getPersonsFound();
		if (persons == null || persons.size() == 0) {
			Person personCreated = hixIdResponse.getPersonCreated();
			if (personCreated == null) {
				throw new HCRuntimeException(new MessageCode("hxid..person.notCreated", "HX Id Could not be created"),
						new IllegalStateException());
			}
			return personCreated.getHxid();
		} else if (persons.size() > 1) {
			throw new HCRuntimeException(new MessageCode("hxid.person.multipleFound", "More than one Person Found"),
					new IllegalStateException());
		}
		return hixIdResponse.getPersonsFound().get(0).getHxid();
	}
	
	@Deprecated
	public void saveHXID(Person person) throws HCRuntimeException {
		hxidServiceImpl.saveHXID(person);
	}
	
	@Deprecated
	public void updatePerson(Person person) throws HCRuntimeException {
		hxidServiceImpl.updatePerson(person);
	}

	/**
	 * @return the hxidServiceImpl
	 */
	public HXIDService getHxidServiceImpl() {
		return hxidServiceImpl;
	}

	/**
	 * @param hxidServiceImpl
	 *            the hxidServiceImpl to set
	 */
	public void setHxidServiceImpl(HXIDService hxidServiceImpl) {
		this.hxidServiceImpl = hxidServiceImpl;
	}

}
