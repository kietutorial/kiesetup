package com.hcentive.event.logging.processor;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcentive.event.logging.domain.EvtReferenceType;
import com.hcentive.event.logging.domain.EvtStatusCd;
import com.hcentive.event.logging.domain.RawPersistEvents;
import com.hcentive.event.logging.domain.RawPersistEventsDTO;
import com.hcentive.event.logging.service.RawPersistEventsService;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.orm.dao.GenericDAO;

/**
 * @author atraikos
 * @version 1.0
 * @created 14-Nov-2013 9:30:24 PM
 */
public class RawPersistEventsProcessorImpl implements
		RawPersistEventsProcessor {
	
	private String entityType;
	private byte[] entity;
	private Long rawPersistEventsId;
			
	private static Logger logger = LoggerFactory.getLogger(RawPersistEventsProcessorImpl.class);
	
	@Autowired
	private RawPersistEventsService rawPersistEventsService;
	
	public byte[] getEntity() {
		return entity;
	}

	public void setEntity(byte[] entity) {
		this.entity = entity;
	}

	public RawPersistEventsProcessorImpl(String entityType) {
		this.entityType = entityType;
	}
	
	@SuppressWarnings("unused")
	private RawPersistEventsProcessorImpl() {
	}
	
	@Override
	public void setRawPersistEventsService(RawPersistEventsService rawPersistEventsService) {
		this.rawPersistEventsService = rawPersistEventsService;
	}
	
	@Override
	public RawPersistEventsService getRawPersistEventsService() {
		return rawPersistEventsService;
	}
	
	private Map<String, Object> gatherCommonAttributes() {
		
		Map<String, Object> attribs = new HashMap<String, Object>();
		String sessionId = MDC.get("EVT:sessionId");
		String referenceId = MDC.get("EVT:referenceId");
		EvtReferenceType referenceType = EvtReferenceType.USER_PROFILE;
		String accountId = MDC.get("EVT:accountId");
		String notes = MDC.get("url");
		String threadName = MDC.get("threadName");
		String httpMethod = MDC.get("httpMethod");
		String ajaxRequest = MDC.get("ajaxRequest");
		String url = MDC.get("url");
	
		attribs.put("accountId",  accountId);
		attribs.put("sessionId",  sessionId);
		attribs.put("referenceType",  referenceType);
		attribs.put("referenceId",  referenceId);
		attribs.put("notes", notes);
		attribs.put("threadName", threadName);
		attribs.put("httpMethod", httpMethod);
		attribs.put("ajaxRequest", ajaxRequest);
		attribs.put("url", url);
		
		return attribs;
	}
	
	private RawPersistEventsDTO buildRawPersistDTO() {
		/**
		 * Gather common attributes from thread-specific MDC hash
		 */
		Map<String, Object> attribs = gatherCommonAttributes();
		String accountId = (String) attribs.get("accountId");
		String sessionId = (String) attribs.get("sessionId");
		String referenceId = (String) attribs.get("referenceId");
		EvtReferenceType referenceType = (EvtReferenceType) attribs.get("referenceType");
		String httpMethod = (String) attribs.get("httpMethod");
		String ajaxRequest = (String) attribs.get("ajaxRequest");
		String url = (String) attribs.get("url");
		
		RawPersistEventsDTO rawPersistEventsDTO = new RawPersistEventsDTO();
		rawPersistEventsDTO.setAccountId(accountId);
		rawPersistEventsDTO.setSessionId(sessionId);
		rawPersistEventsDTO.setReferenceId(referenceId);
		rawPersistEventsDTO.setReferenceType(referenceType);
		rawPersistEventsDTO.setAjaxRequest(ajaxRequest);
		rawPersistEventsDTO.setHttpMethod(httpMethod);
		rawPersistEventsDTO.setUrl(url);
		rawPersistEventsDTO.setEntityPrevious(entity);
		return rawPersistEventsDTO;
	}
	
	private void completeEntityState(long persistId, boolean currentEntityDeleted) {
		
		Map<String, Object> attribs = gatherCommonAttributes();
		String sessionId = (String) attribs.get("sessionId");
		String referenceId = (String) attribs.get("referenceId");
		
		String createdBy = referenceId;
		
		if (logger.isDebugEnabled()) {
			logger.debug("EVT: Just before statement I suspect is bombing !!! completeEntityState!! completeEntityState(Long, Boolean)");
			logger.debug("sessionId: " + sessionId);
			logger.debug("createdBy: " + createdBy);
			logger.debug("entityType: " + entityType);
		}
		
		RawPersistEvents rpeEntity = rawPersistEventsService.getRawPersistEventsById(persistId);
		
		if (rpeEntity == null) return;
		
		if (logger.isDebugEnabled()) {
			logger.debug("in completeEntityState with currentEntityDeleted=" + currentEntityDeleted);
			logger.debug("Did we actually get a record for RawPersistEvents?");
			logger.debug("Here are the parameters:");
			logger.debug("sessionId: " + sessionId);
			logger.debug("createdBy: " + createdBy);
			logger.debug("entityType: " + entityType);
			
			logger.debug("------------------------------");
			logger.debug("And this is what we got back..");
			logger.debug("RawPersistEvent object");
			logger.debug("------------------------------");
			logger.debug("EVT!!!" + MDC.get("EVT:EntityName"));
			logger.debug("EVT!!!" + MDC.get("EVT:" + entityType + "Id"));
			logger.debug("EVT!!!" + MDC.get("EVT:RawPersistEventsId"));
			logger.debug("------------------------------");
			
			logger.debug("accountId: " + rpeEntity.getAccountId());
			logger.debug("sessionId: " + rpeEntity.getSessionId());
			logger.debug("createdBy: " + rpeEntity.getCreatedBy());
			logger.debug("getEntityType: " + rpeEntity.getEntityType());
			logger.debug("actualRunDate: " + rpeEntity.getActualRunDate());
			logger.debug("getId: " + rpeEntity.getId());
			logger.debug("readyForProcessing: " + rpeEntity.getReadyForProcessing());
			logger.debug("statusCd: " + rpeEntity.getStatusCd());
			logger.debug("httpmethod: " + rpeEntity.getHttpMethod());
			logger.debug("ajaxRequest: " + rpeEntity.getAjaxRequest());
			logger.debug("url: " + rpeEntity.getUrl());
		}
		
		rawPersistEventsService.updateRawPersistEventForProcessing(persistId, (!currentEntityDeleted) ? entity : null);
	}

	private void completeEntityState(boolean currentEntityDeleted) {
		
		Map<String, Object> attribs = gatherCommonAttributes();
		String sessionId = (String) attribs.get("sessionId");
		String referenceId = (String) attribs.get("referenceId");
		
		String createdBy = referenceId;
		
		if (logger.isDebugEnabled()) {
			logger.debug("EVT: Just before statement I suspect is bombing !!!");
			logger.debug("sessionId: " + sessionId);
			logger.debug("createdBy: " + createdBy);
			logger.debug("entityType: " + entityType);
		}
		
		RawPersistEvents rpeEntity = rawPersistEventsService.getRawPersistEventForModification(sessionId, referenceId, entityType);
		
		if (rpeEntity == null) return;
		
		if (logger.isDebugEnabled()) {
			logger.debug("in completeEntityState with currentEntityDeleted=" + currentEntityDeleted);
			logger.debug("Did we actually get a record for RawPersistEvents?");
			logger.debug("Here are the parameters:");
			logger.debug("sessionId: " + sessionId);
			logger.debug("createdBy: " + createdBy);
			logger.debug("entityType: " + entityType);
			
			logger.debug("------------------------------");
			logger.debug("And this is what we got back..");
			logger.debug("RawPersistEvent object");
			
			logger.debug("accountId: " + rpeEntity.getAccountId());
			logger.debug("sessionId: " + rpeEntity.getSessionId());
			logger.debug("createdBy: " + rpeEntity.getCreatedBy());
			logger.debug("getEntityType: " + rpeEntity.getEntityType());
			logger.debug("actualRunDate: " + rpeEntity.getActualRunDate());
			logger.debug("getId: " + rpeEntity.getId());
			logger.debug("readyForProcessing: " + rpeEntity.getReadyForProcessing());
			logger.debug("statusCd: " + rpeEntity.getStatusCd());
			logger.debug("httpmethod: " + rpeEntity.getHttpMethod());
			logger.debug("ajaxRequest: " + rpeEntity.getAjaxRequest());
			logger.debug("url: " + rpeEntity.getUrl());
		}
	
		if (!currentEntityDeleted) {
			rpeEntity.setEntityCurrent(entity);
		}
		
		rpeEntity.setStatusCd(EvtStatusCd.READY_FOR_PROCESSING);
		rpeEntity.setReadyForProcessing("Y");
		
		GenericDAO<RawPersistEvents> genericDAO = rawPersistEventsService.getGenericDAO();
		genericDAO.update(rpeEntity);
	}
	
	@Override
	public void createRawPersist() {
		if (logger.isDebugEnabled()) {
			logger.debug("Entering RawPersistEventsProcessorImpl::createRawPersist()");
		}
		
		RawPersistEventsDTO rawPersistEventsDTO = buildRawPersistDTO();
		rawPersistEventsDTO.setEntityType(entityType);
		rawPersistEventsDTO.setStatusCd(EvtStatusCd.NEW);
		rawPersistEventsDTO.setReadyForProcessing("N");
		
		try {
			rawPersistEventsService.createRawPersistEvents(rawPersistEventsDTO);
		} catch (HCException e) {
			logger.warn(e.getMessage());
		}
	}

	@Override
	public void startEntityState() {
		if (logger.isDebugEnabled()) {
			logger.debug("Entering RawPersistEventsProcessorImpl::startEntityState()");
		}
		
		RawPersistEventsDTO rawPersistEventsDTO = buildRawPersistDTO();
		rawPersistEventsDTO.setEntityType(entityType);
		
		rawPersistEventsDTO.setStatusCd(EvtStatusCd.NEW);
		rawPersistEventsDTO.setReadyForProcessing("N");
	
		// Show me what is in rawPersistEventsDTO, since it is complaining about constraint violation now.
		if (logger.isDebugEnabled()) {
			logger.debug("in startEntityState()");
			logger.debug("RawPersistEventDTO object");
			
			logger.debug("accountId: " + rawPersistEventsDTO.getAccountId());
			logger.debug("sessionId: " + rawPersistEventsDTO.getSessionId());
			logger.debug("getEntityType: " + rawPersistEventsDTO.getEntityType());
			logger.debug("actualRunDate: " + rawPersistEventsDTO.getActualRunDate());
			logger.debug("getId: " + rawPersistEventsDTO.getId());
			logger.debug("readyForProcessing: " + rawPersistEventsDTO.getReadyForProcessing());
			logger.debug("statusCd: " + rawPersistEventsDTO.getStatusCd());
			logger.debug("httpMethod: " + rawPersistEventsDTO.getHttpMethod());
			logger.debug("ajaxRequest: " + rawPersistEventsDTO.getAjaxRequest());
			logger.debug("url: " + rawPersistEventsDTO.getUrl());
		}
		
		try {
			Long id = rawPersistEventsService.createRawPersistEvents(rawPersistEventsDTO);
			if (logger.isDebugEnabled()) logger.debug("EVT:RawPersistEventsId - " + Long.toString(id));
			MDC.put("EVT:RawPersistEventsId", Long.toString(id));
		} catch (HCException e) {
			logger.warn(e.getMessage());
		}
	}

	@Override
	public void completeEntityStateAsDeleted() {
		if (logger.isDebugEnabled()) {
			logger.debug("Entering RawPersistEventsProcessorImpl::completeEntityStateAsDeleted()");
		}
		boolean currentEntityDeleted = true;
		completeEntityState(currentEntityDeleted);
	}
	
	@Override
	public void completeEntityStateAsModified() {
		if (logger.isDebugEnabled()) {
			logger.debug("Entering RawPersistEventsProcessorImpl::completeEntityStateAsModified()");
		}
		boolean currentEntityDeleted = false;
		completeEntityState(currentEntityDeleted);
	}
	
	@Override
	public void completeEntityStateAsModified(Long persistId) {
		if (logger.isDebugEnabled()) {
			logger.debug("Entering RawPersistEventsProcessorImpl::completeEntityStateAsModified(Long)");
		}
		
		boolean currentEntityDeleted = false;
		completeEntityState(persistId, currentEntityDeleted);
	}

	@Override
	public void saveEntity(Object entity) {
		if (logger.isDebugEnabled()) {
			logger.debug("Entering RawPersistEventsProcessorImpl::saveEntity()");
		}
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(entity);
			this.entity = baos.toByteArray();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
	}
	
	public Long getRawPersistEventsId() {
		return rawPersistEventsId;
	}

	@Override
	public void setRawPersistEventsId(Long rawPersistEventsId) {
		this.rawPersistEventsId = rawPersistEventsId;
	}
	
}