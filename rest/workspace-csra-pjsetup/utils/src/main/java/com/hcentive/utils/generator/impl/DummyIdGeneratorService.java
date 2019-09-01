package com.hcentive.utils.generator.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.hcentive.utils.generator.IDGeneratorService;
import com.hcentive.utils.generator.IDType;
import com.hcentive.utils.orm.dao.GenericDAO;

public class DummyIdGeneratorService implements IDGeneratorService {

	private GenericDAO genericDAO;

	public void setGenericDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

	@Override
	public String generateID(IDType idType) {

		return System.currentTimeMillis()+"";

	}
}
