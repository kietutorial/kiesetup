package com.hcentive.event.logging.processor;

import com.hcentive.event.logging.service.RawPersistEventsService;

public interface RawPersistEventsProcessor {
	public void setRawPersistEventsService(RawPersistEventsService rawPersistEventsService);
	public RawPersistEventsService getRawPersistEventsService();
	
	// Main methods that are called from each of the methods from the entity
	// listener classes
	public void createRawPersist();
	public void startEntityState();
	public void completeEntityStateAsDeleted();
	public void completeEntityStateAsModified();
	
	public void saveEntity(Object entity);
	public void setRawPersistEventsId(Long rawPersistEventsId);
	public void completeEntityStateAsModified(Long persistId);
}
