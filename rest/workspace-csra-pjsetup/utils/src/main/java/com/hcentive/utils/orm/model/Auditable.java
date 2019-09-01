/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.orm.model;

public interface Auditable {

	AuditLog createAuditLog();

	AuditLog getAuditLog();

	String getEntityId();
}
