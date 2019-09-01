package com.hcentive.event.logging.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hcentive.event.logging.domain.EventsTransaction;
import com.hcentive.event.logging.domain.EventsTransactionDTO;
import com.hcentive.event.logging.domain.EvtBaseEventName;
import com.hcentive.event.logging.domain.EvtEventEntityName;
import com.hcentive.event.logging.domain.EvtEventName;
import com.hcentive.event.logging.domain.EvtReferenceType;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.ext.HXLogMsgConstants;
import com.hcentive.utils.ext.HXUtility;
import com.hcentive.utils.orm.dao.GenericDAO;


/**
 * EventsTransactionServiceImpl is the service layer class implementation that
 * the Event Logging Processor will use for storing the records in the
 * database.
 * 
 * The rest of the application will use this service layer class for reading
 * the records from the database.
 *
 * @author Angelo Traikos
 *
 */
public class EventsTransactionServiceImpl implements EventsTransactionService
{
	protected static Logger logger = LoggerFactory.getLogger(EventsTransactionServiceImpl.class);

	@Autowired
	private GenericDAO<EventsTransaction> genericDAO; // injected

	public EventsTransactionServiceImpl() {
	}

	/** 
	 * This function is responsible for persisting input event transaction 
	 * information to the database.
	 *
	 * @param EventsTransactionDTO eventsTransactionDTO
	 *
	 */
	@Transactional(readOnly = false)
	@Override
	public void createEventsTransaction(EventsTransactionDTO eventsTransactionDTO) throws HCException {

		/**
		 * Validate Input Data Start
		 */

		EvtEventEntityName eventEntityName = eventsTransactionDTO.getEventEntityName();
		EvtBaseEventName baseEventName = eventsTransactionDTO.getBaseEventName();
		EvtEventName eventName = eventsTransactionDTO.getEventName();

		String accountId = eventsTransactionDTO.getAccountId();
		String referenceId = eventsTransactionDTO.getReferenceId();
		String sessionId = eventsTransactionDTO.getSessionId();
		String notes = eventsTransactionDTO.getNotes();
		String initiatedBy = eventsTransactionDTO.getInitiatedBy();
		EvtReferenceType referenceType = eventsTransactionDTO.getReferenceType();
		Date eventDate = eventsTransactionDTO.getEventDate();
		String eventDescription = eventsTransactionDTO.getEventDescription();
		//CR555
		String enrlPlanTranActionReasonCode = eventsTransactionDTO.getEnrlPlanTranActionReasonCode();

		if (HXUtility.isEmpty(accountId)) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EVENTLOGGER_ACCTID_MISSING));
		} else if (eventEntityName == null) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EVENTLOGGER_EVT_ENTITY_NAME_MISSING));
		} else if (baseEventName == null) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EVENTLOGGER_EVT_BASE_EVENT_NAME_MISSING));
		} else if (eventName == null) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EVENTLOGGER_EVT_EVENT_NAME_MISSING));
		}
		
		/**
		 * Create and populate EventsTransaction object - Start
		 */
		EventsTransaction eventsTransaction = new EventsTransaction();
		eventsTransaction.setEventEntityName(eventEntityName);
		eventsTransaction.setBaseEventName(baseEventName);
		eventsTransaction.setEventName(eventName);
		eventsTransaction.setAccountId(accountId);
		eventsTransaction.setReferenceType(referenceType);
		eventsTransaction.setReferenceId(referenceId);
		eventsTransaction.setSessionId(sessionId);
		eventsTransaction.setNotes(notes);
		eventsTransaction.setEventDate(eventDate);
		eventsTransaction.setInitiatedBy(initiatedBy);
		eventsTransaction.setEventDescription(eventDescription);
		eventsTransaction.setEnrlPlanTranActionReasonCode(enrlPlanTranActionReasonCode);
		/**
		 * Create and populate EventsTransaction object - End
		 */

		genericDAO.create(eventsTransaction);
	}

	/**
	 * 
	 * @see com.hcentive.event.logging.service.EventsTransactionService#
	 *      createEventsTransaction(java.util.List)
	 */
	@Transactional(readOnly = false)
	@Override
	public void createEventsTransaction(List<EventsTransactionDTO> eventsTransactionDTOs) throws HCException {
		for (EventsTransactionDTO et : eventsTransactionDTOs) {
			createEventsTransaction(et);
		}
	}
	
	/**
	 * This function will convert EventsTransaction Entities into EventsTransaction DTOs
	 * 
	 * @param eventsTransactions
	 * @return List<EventsTransactionDTO>
	 */
	public List<EventsTransactionDTO> convertEventsTransactionToDTO(List<EventsTransaction> eventsTransactions) {
	
		List<EventsTransactionDTO> eventsTransactionDTOs = new ArrayList<EventsTransactionDTO>();
		for (EventsTransaction eventsTransaction : eventsTransactions) {
			EventsTransactionDTO eventsTransactionDTO = new EventsTransactionDTO();
			eventsTransactionDTO.setEventEntityName(eventsTransaction.getEventEntityName());
			eventsTransactionDTO.setBaseEventName(eventsTransaction.getBaseEventName());
			eventsTransactionDTO.setEventName(eventsTransaction.getEventName());
			eventsTransactionDTO.setAccountId(eventsTransaction.getAccountId());
			eventsTransactionDTO.setReferenceId(eventsTransaction.getReferenceId());
			eventsTransactionDTO.setSessionId(eventsTransaction.getSessionId());
			eventsTransactionDTO.setNotes(eventsTransaction.getNotes());
			eventsTransactionDTOs.add(eventsTransactionDTO);
		}
		
		return eventsTransactionDTOs;
	}
	
	// Now need to do the appropriate read methods, since the UI will require this.
	// Implement the following methods -- Currently not yet complete in the implementing class
	
	@Transactional(readOnly = false)
	@Override
	public List<EventsTransaction> getEventsTransactionByAccountId(String accountId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		return genericDAO.findByNamedQuery("getEventsTransactionByAccountId", params);
	}
	
	@Transactional(readOnly = false)
	@Override
	public List<EventsTransaction> getEventsTransactionByReferenceId(String referenceId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("referenceId", referenceId);
		return genericDAO.findByNamedQuery("getEventsTransactionByReferenceId", params);
	}
	
	@Transactional(readOnly = false)
	@Override
	public List<EventsTransaction> getEventsTransactionBySessionId(String sessionId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sessionId", sessionId);
		return genericDAO.findByNamedQuery("getEventsTransactionBySessionId", params);
	}

	@Override
	public GenericDAO<EventsTransaction> getGenericDAO() {
		return genericDAO;
	}

	@Override
	public void setGenericDAO(GenericDAO<EventsTransaction> genericDAO) {
		this.genericDAO = genericDAO;
	}
}