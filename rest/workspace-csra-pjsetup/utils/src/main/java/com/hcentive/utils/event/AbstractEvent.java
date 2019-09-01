/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.utils.event;

import java.util.Map;

import org.springframework.context.ApplicationEvent;

/**
 * The Class AbstractEvent.
 */
public abstract class AbstractEvent extends ApplicationEvent {

	/** The event id. */
	protected String eventId;

	/** The event context. */
	protected Object eventContext;

	/**
	 * Instantiates a new abstract event.
	 * 
	 * @param eventId
	 *            the event id
	 * @param eventContext
	 *            the event context
	 */
	public AbstractEvent(String eventId, Object eventContext) {
		super(eventId);
		this.eventId = eventId;
		this.eventContext = eventContext;
	}

	/**
	 * Gets the event id.
	 * 
	 * @return the event id
	 */
	public String getEventId() {
		return eventId;
	}

	/**
	 * Gets the event context.
	 * 
	 * @return the event context
	 */
	public Object getEventContext() {
		return eventContext;
	}

	/**
	 * Gets the context params.
	 * 
	 * @param paramName
	 *            the param name
	 * @return the context params
	 */
	@SuppressWarnings("unchecked")
	public Object getContextParams(String paramName) {
		if (eventContext == null || !(eventContext instanceof Map)) {
			return null;
		}
		return ((Map<String, Object>) eventContext).get(paramName);
	}
}
