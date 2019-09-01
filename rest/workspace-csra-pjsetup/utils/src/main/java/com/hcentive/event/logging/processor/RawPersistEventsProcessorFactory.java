package com.hcentive.event.logging.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcentive.event.logging.service.RawPersistEventsService;
import com.hcentive.utils.exception.HCException;

public class RawPersistEventsProcessorFactory {
	
	protected static Logger logger = LoggerFactory.getLogger(RawPersistEventsProcessorFactory.class);

	// the eventsTransactionService object
	private static RawPersistEventsService rawPersistEventsService;

	// Based on the entity passed, we need to return the class that goes along with it.
	public static RawPersistEventsProcessor getProcessorType(String entityName) throws HCException {
		if (logger.isDebugEnabled()) {
			logger.debug("Entering RawPersistEventsProcessorFactory::getProcessorType: " + entityName);
		}
	
		// We may need some error checking to ensure that we are limiting
		// the entity types that RawPersistEventsProcessor can handle
		RawPersistEventsProcessor rawPersistEventsProcessor = new RawPersistEventsProcessorImpl(entityName);
		rawPersistEventsProcessor.setRawPersistEventsService(rawPersistEventsService);
		return rawPersistEventsProcessor;
	}
	
	// method to use to inject spring beans
	@SuppressWarnings("unused")
	private static Object init(RawPersistEventsService rawPersistEventsService) {
		RawPersistEventsProcessorFactory.rawPersistEventsService = rawPersistEventsService;
		return null;
	}
}