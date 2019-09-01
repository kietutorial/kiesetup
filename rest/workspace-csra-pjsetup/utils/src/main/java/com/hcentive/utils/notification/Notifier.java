/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.notification;

/**
 * This Interface defines the contract for issuing notifications based on a
 * Event.
 * 
 * @author ashish.jaiswal@hcentive.com
 * 
 */
public interface Notifier {

	public void notify(String event, Message message);
}
