package com.hcentive.shop.event.logging.service;

import com.hcentive.shop.event.domain.EmployerEventHistory;

public interface EmployerEventService {
	
	public void saveEntity(EmployerEventHistory eventHistory);
	
}
