package com.hcentive.event.logging.service;

import java.util.List;

import com.hcentive.event.logging.domain.RawPersistEvents;
import com.hcentive.event.logging.domain.RawPersistEventsDTO;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.orm.dao.GenericDAO;

public interface RawPersistEventsService {

	// Need to be able to create the records.  One or more at one shot.
	public Long createRawPersistEvents(RawPersistEventsDTO rawPersistEventsDTO) throws HCException;

	public List<RawPersistEvents> getRawPersistEventsForProcessing();
	public RawPersistEvents getRawPersistEventForModification(String sessionId, String createdBy, String entityType);
	
	public void updateRawPersistEventForProcessing(String sessionId, String createdBy, String entityType, byte[] entityCurrent);
	public void updateRawPersistEventForProcessing(Long id, byte[] entityCurrent);
	public void updateRawPersistEventsToInProgress(List<RawPersistEventsDTO> rawPersistEventsDTOs);
	public void updateRawPersistEventsToSuccess(List<RawPersistEventsDTO> rawPersistEventsDTOs);
	public void updateRawPersistEventsToCancelled(List<RawPersistEventsDTO> rawPersistEventsDTOs);
	public void deleteRawPersistEvents(List<RawPersistEventsDTO> rawPersistEventsDTOs);
	public RawPersistEvents getRawPersistEventsById(Long id);
	
	// The service must have the generic DAO to correctly function.
	public GenericDAO<RawPersistEvents> getGenericDAO();
	public void setGenericDAO(GenericDAO<RawPersistEvents> genericDAO);
	public void createEligibilityRawEvents(String eligibilityId,String accountId) throws HCException ;
	public void createPlanRawEvents(String enrlMbrId,int planId,String accountId) throws HCException ;
	public void createAppealRawEvents(String appealId,String accountId) throws HCException ;
	
}