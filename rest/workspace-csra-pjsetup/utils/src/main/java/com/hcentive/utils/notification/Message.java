/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.notification;

import java.util.HashMap;
import java.util.Map;

/**
 * Models a message domain object for sending notifications. Uses typical email
 * and sms fields, but can be extended to add more attributes. The datamodel
 * also contains data that gets substitued into template placeholders
 * 
 * 
 * @author ashish.jaiswal@hcentive.com
 * 
 */
public abstract class Message {

	private String id;
	private String source;
	private boolean isImmediate = true;

	// Data which may contain attributes needed for populating template
	private Map<String, Object> data = new HashMap<String, Object>();

	public Message(Map<String, Object> data) {
		this.data = data;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void addData(String key, Object value) {
		this.data.put(key, value);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isImmediate() {
		return isImmediate;
	}

	public void setImmediate(boolean isImmediate) {
		this.isImmediate = isImmediate;
	}
}
