package com.hcentive.shop.event.logging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcentive.shop.event.domain.EmployerEventHistory;
import com.hcentive.utils.orm.dao.GenericDAO;

@Service
public class EmployerEventServiceImpl implements EmployerEventService {

	@SuppressWarnings("rawtypes")
	@Autowired
	private GenericDAO genericDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public void saveEntity(EmployerEventHistory eventHistory) {
		genericDAO.create( eventHistory );
	}

}
