package com.hcentive.event.logging.service;

import java.util.List;

import com.hcentive.event.logging.domain.EventsTransaction;
import com.hcentive.event.logging.domain.EventsTransactionDTO;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.orm.dao.GenericDAO;

public interface EventsTransactionService {
	
	// Need to be able to create the records.  One or more at one shot.
	public void createEventsTransaction(EventsTransactionDTO eventsTransactionDTO) throws HCException;
	public void createEventsTransaction(List<EventsTransactionDTO> eventsTransactionDTOs) throws HCException;
	
	// Implement the following methods -- Currently not yet complete in the implementing class
	public List<EventsTransaction> getEventsTransactionByAccountId(String accountId);
	public List<EventsTransaction> getEventsTransactionByReferenceId(String referenceId);
	public List<EventsTransaction> getEventsTransactionBySessionId(String sessionId);
	
	// The service must have the generic DAO to correctly function.
	public GenericDAO<EventsTransaction> getGenericDAO();
	public void setGenericDAO(GenericDAO<EventsTransaction> genericDAO);
	
	// Updates to these records will likely not be required since we would not want to change
	// these records once they are created for audit purposes.
}