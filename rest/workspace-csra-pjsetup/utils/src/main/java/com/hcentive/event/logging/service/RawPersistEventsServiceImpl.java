package com.hcentive.event.logging.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.hcentive.event.logging.domain.EvtReferenceType;
import com.hcentive.event.logging.domain.EvtStatusCd;
import com.hcentive.event.logging.domain.RawPersistEvents;
import com.hcentive.event.logging.domain.RawPersistEventsDTO;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.exception.HCRuntimeException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.ext.HXLogMsgConstants;
import com.hcentive.utils.ext.HXUtility;
import com.hcentive.utils.orm.dao.GenericDAO;

public class RawPersistEventsServiceImpl implements RawPersistEventsService {
	
	protected static Logger logger = LoggerFactory.getLogger(RawPersistEventsServiceImpl.class);

	@Autowired
	private GenericDAO<RawPersistEvents> genericDAO;

	@Override
	@Transactional
	public Long createRawPersistEvents(RawPersistEventsDTO rawPersistEventsDTO) throws HCException {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Begin createRawPersistEvents()");
		}
		
		String sessionId = rawPersistEventsDTO.getSessionId();
		String referenceId = rawPersistEventsDTO.getReferenceId();
		String accountId = rawPersistEventsDTO.getAccountId();
		EvtReferenceType referenceType = rawPersistEventsDTO.getReferenceType();
		
		byte[] entityPrevious = rawPersistEventsDTO.getEntityPrevious();
		String entityType = rawPersistEventsDTO.getEntityType();
		
		//Need these checks, fill them in later
		if (HXUtility.isEmpty(accountId)) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EVENTLOGGER_ACCTID_MISSING));
		} else if (HXUtility.isEmpty(sessionId)) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EVENTLOGGER_SESSIONID_MISSING));
		} else if (HXUtility.isEmpty(referenceId)) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EVENTLOGGER_LOGINID_MISSING));
		} else if (referenceType == null) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EVENTLOGGER_EVT_REFERENCE_TYPE_MISSING));
		}
		
		// Initial state when creating a new record
		byte[] entityCurrent = null;
		
		EvtStatusCd statusCd = EvtStatusCd.NEW;
		String readyForProcessing = "N";
		
		String httpMethod = rawPersistEventsDTO.getHttpMethod();
		String ajaxRequest = rawPersistEventsDTO.getAjaxRequest();
		String url = rawPersistEventsDTO.getUrl();
		
		/**
		 * Create and populate RawPersistEvents object - Start
		 */
		
		if (logger.isDebugEnabled()) {
			logger.debug("Create and populate RawPersistEvents object - start");
		}
		
		RawPersistEvents rawPersistEvents = new RawPersistEvents();
		rawPersistEvents.setAccountId(accountId);
		rawPersistEvents.setSessionId(sessionId);
		rawPersistEvents.setReferenceId(referenceId);
		rawPersistEvents.setReferenceType(referenceType);
		rawPersistEvents.setEntityPrevious(entityPrevious);
		rawPersistEvents.setEntityType(entityType);
		rawPersistEvents.setEntityCurrent(entityCurrent);
		rawPersistEvents.setStatusCd(statusCd);
		rawPersistEvents.setReadyForProcessing(readyForProcessing);
		rawPersistEvents.setHttpMethod(httpMethod);
		rawPersistEvents.setAjaxRequest(ajaxRequest);
		rawPersistEvents.setUrl(url);
		
		/**
		 * Create and populate RawPersistEvents object - End
		 */
		if(logger.isDebugEnabled()) {
			logger.debug("Create and populate RawPersistEvents object - End");
			logger.debug("Id: " + rawPersistEvents.getId());
			logger.debug("accountId: " + rawPersistEvents.getAccountId());
			logger.debug("sessionId: " + rawPersistEvents.getSessionId());
			logger.debug("referenceId: " + rawPersistEvents.getReferenceId());
			logger.debug("referenceType: " + rawPersistEvents.getReferenceType());
			logger.debug("entityPrevious: " + rawPersistEvents.getEntityPrevious());
			logger.debug("entityCurrent: " + rawPersistEvents.getEntityCurrent());
			logger.debug("entityType: " + rawPersistEvents.getEntityType());
			logger.debug("statusCd: " + rawPersistEvents.getStatusCd());
			logger.debug("readyForProcessing: " + rawPersistEvents.getReadyForProcessing());
			logger.debug("actualRunDate: " + rawPersistEvents.getActualRunDate());
			logger.debug("httpMethod: " + rawPersistEvents.getHttpMethod());
			logger.debug("ajaxRequest: " + rawPersistEvents.getAjaxRequest());
			logger.debug("url: " + rawPersistEvents.getUrl());
		}
		
		// Make sure record doesn't already exit, since there is a potential of
		// constraint violations

		Long id = null;
		try {
			id = genericDAO.create(rawPersistEvents).getId();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		
		return id;
	}

	@Transactional(readOnly = false, value = "txManager")
	@Override
	public RawPersistEvents getRawPersistEventForModification(String sessionId,
			String createdBy, String entityType) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sessionId", sessionId);
		params.put("referenceId", createdBy);
		params.put("entityType", entityType);
		
		String queryName = "rawPersistEvents.getPersistEventForModification";
		List<RawPersistEvents> rpeList = genericDAO.findByNamedQuery(queryName, params);
		
		return rpeList.get(0);
	}
	
	@Override
	@Transactional(readOnly = false, value = "txManager")
	public List<RawPersistEvents> getRawPersistEventsForProcessing() {
		
		Map<String, Object> params = new HashMap<String, Object>();
	
		EvtStatusCd statusCd = EvtStatusCd.READY_FOR_PROCESSING;
		String readyForProcessing = "Y";
		
		params.put("statusCd", statusCd);
		params.put("readyForProcessing", readyForProcessing);
		
		String queryName = "rawPersistEvents.getPersistEventsForProcessing";
		return genericDAO.findByNamedQuery(queryName, params);
	}

	@Override
	@Transactional(readOnly=false)
	public void updateRawPersistEventForProcessing(String sessionId, String createdBy, String entityType, byte[] entityCurrent) {
		
		Map<String, Object> params = new HashMap<String, Object>();
	
		EvtStatusCd statusCd = EvtStatusCd.READY_FOR_PROCESSING;
		String readyForProcessing = "Y";
		
		params.put("statusCd", statusCd);
		params.put("readyForProcessing", readyForProcessing);
		params.put("entityCurrent", entityCurrent);
		params.put("sessionId", sessionId);
		params.put("createdBy",  createdBy);
		params.put("entityType",  entityType);
		
		String queryName = "rawPersistEvents.getPersistEventsForProcessing";
		genericDAO.executeUpdateNamedQuery(queryName, params);
	}

	// New method to update raw persist events table
	@Override
	@Transactional(readOnly=false)
	public void updateRawPersistEventForProcessing(Long id, byte[] entityCurrent) {
		RawPersistEvents persistEvent = getRawPersistEventsById(id);
		persistEvent.setEntityCurrent(entityCurrent);
		persistEvent.setStatusCd(EvtStatusCd.READY_FOR_PROCESSING);
		persistEvent.setReadyForProcessing("Y");
		genericDAO.update(persistEvent);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateRawPersistEventsToInProgress(List<RawPersistEventsDTO> rawPersistEventsDTOs) {
		for (RawPersistEventsDTO rawPersistEventsDTO : rawPersistEventsDTOs) {
			RawPersistEvents persistEvent = getRawPersistEventsById(rawPersistEventsDTO.getId());
			persistEvent.setActualRunDate(new Date());
			persistEvent.setStatusCd(EvtStatusCd.IN_PROGRESS);
			genericDAO.update(persistEvent);
		}
	}
	
	/**
	 * This function is responsible for getting Raw Persist Event object by primary key
	 * 
	 * @param Long
	 *            id primary Key
	 */
	@Override
	public RawPersistEvents getRawPersistEventsById(Long id) {
		return genericDAO.get(RawPersistEvents.class, id);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void updateRawPersistEventsToSuccess(List<RawPersistEventsDTO> rawPersistEventsDTOs) {
		for (RawPersistEventsDTO rawPersistEventsDTO : rawPersistEventsDTOs) {
			RawPersistEvents persistEvent = getRawPersistEventsById(rawPersistEventsDTO.getId());
			persistEvent.setActualRunDate(new Date());
			persistEvent.setStatusCd(EvtStatusCd.SUCCESS);
			genericDAO.update(persistEvent);
		}
	}
	
	@Override
	@Transactional(readOnly = false)
	public void deleteRawPersistEvents(List<RawPersistEventsDTO> rawPersistEventsDTOs) {
		for (RawPersistEventsDTO rawPersistEventsDTO : rawPersistEventsDTOs) {
			RawPersistEvents persistEvent = getRawPersistEventsById(rawPersistEventsDTO.getId());
			genericDAO.delete(persistEvent);
		}
	}
	
	@Override
	@Transactional(readOnly = false)
	public void updateRawPersistEventsToCancelled(List<RawPersistEventsDTO> rawPersistEventsDTOs) {
		for (RawPersistEventsDTO rawPersistEventsDTO : rawPersistEventsDTOs) {
			RawPersistEvents persistEvent = getRawPersistEventsById(rawPersistEventsDTO.getId());
			persistEvent.setActualRunDate(new Date());
			persistEvent.setStatusCd(EvtStatusCd.CANCELLED);
			genericDAO.update(persistEvent);
		}
	}
	
	@Override
	public GenericDAO<RawPersistEvents> getGenericDAO() {
		return genericDAO;
	}

	@Override
	public void setGenericDAO(GenericDAO<RawPersistEvents> genericDAO) {
		this.genericDAO = genericDAO;
	}
	
	@Override
	@Transactional(readOnly = false)
	public void createEligibilityRawEvents(String eligibilityId,String accountId) throws HCException {
		
		if (HXUtility.isEmpty(accountId)) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EVENTLOGGER_ACCTID_MISSING));
		} 
		
		RawPersistEvents rawPersistEvents = new RawPersistEvents();
		rawPersistEvents.setAccountId(accountId);
		rawPersistEvents.setReferenceId(eligibilityId);
		rawPersistEvents.setReferenceType(EvtReferenceType.ELIGIBILITY);
		rawPersistEvents.setEntityType("Eligibility");
		rawPersistEvents.setEntityPrevious(null);
		rawPersistEvents.setEntityCurrent(null);
		rawPersistEvents.setStatusCd(EvtStatusCd.READY_FOR_PROCESSING);
		rawPersistEvents.setReadyForProcessing("Y");
		try {
			genericDAO.create(rawPersistEvents);
		} catch (Exception exp) {
			logger.warn("Error in creating raw persists events:"+exp.fillInStackTrace());
		}
	}
	

	@Override
	@Transactional(readOnly = false)
	public void createPlanRawEvents(String accountID,int planId, String actionType) throws HCException {
		
		if (HXUtility.isEmpty(actionType)) {
			String str = HXLogMsgConstants.LOG_ERROR_EVENTLOGGER_ACCTID_MISSING
					+ " account Id - " + accountID
					+ " plan Id - " + planId
					+ " Action - " + actionType 
					+ ", Method Name - createPlanRawEvents";
			logger.error(str);
			throw new HCException(new MessageCode(str));					
		} 
		
		RawPersistEvents rawPersistEvents = new RawPersistEvents();
		rawPersistEvents.setAccountId(accountID);
		rawPersistEvents.setEnrlPlanID(planId);
		rawPersistEvents.setReferenceId(actionType);
		rawPersistEvents.setReferenceType(EvtReferenceType.PLAN);
		rawPersistEvents.setEntityType("Plan");
		rawPersistEvents.setEntityPrevious(null);
		rawPersistEvents.setEntityCurrent(null);
		rawPersistEvents.setStatusCd(EvtStatusCd.READY_FOR_PROCESSING);
		rawPersistEvents.setReadyForProcessing("Y");
		try {
			genericDAO.create(rawPersistEvents);
		} catch (Exception exp) {
			String str = "Error in creating raw persists events :"
					+ " account Id - " + accountID
					+ " Plan Id - " + planId
					+ " Action - " + actionType 
					+ ", Method Name - createPlanRawEvents";
			logger.error(str, exp);
			throw new HCRuntimeException(new MessageCode(str), exp);		
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void createAppealRawEvents(String appealId,String accountId) throws HCException {
		
		if (HXUtility.isEmpty(accountId)) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EVENTLOGGER_ACCTID_MISSING));
		} 
		
		RawPersistEvents rawPersistEvents = new RawPersistEvents();
		rawPersistEvents.setAccountId(accountId);
		rawPersistEvents.setReferenceId(appealId);
		rawPersistEvents.setReferenceType(EvtReferenceType.APPEAL);
		rawPersistEvents.setEntityType("Appeal");
		rawPersistEvents.setEntityPrevious(null);
		rawPersistEvents.setEntityCurrent(null);
		rawPersistEvents.setStatusCd(EvtStatusCd.READY_FOR_PROCESSING);
		rawPersistEvents.setReadyForProcessing("Y");
		try {
			genericDAO.create(rawPersistEvents);
		} catch (Exception exp) {
			logger.warn("Error in creating raw persists events:"+exp.fillInStackTrace());
		}
	}
	
}