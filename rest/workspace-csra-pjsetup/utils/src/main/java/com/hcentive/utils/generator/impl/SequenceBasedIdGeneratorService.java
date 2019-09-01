package com.hcentive.utils.generator.impl;

import java.math.BigDecimal;

import java.math.BigInteger;
import java.util.Random;

import com.hcentive.utils.generator.IDGeneratorService;
import com.hcentive.utils.generator.IDType;
import com.hcentive.utils.orm.dao.GenericDAO;

public class SequenceBasedIdGeneratorService implements IDGeneratorService {

	private GenericDAO genericDAO;
    private final String ZERO_PADDING= "00000000000000000"; 
	public void setGenericDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

	@Override
	public String generateID(IDType idType) {

		String sequenceQuery = "VALUES NEXTVAL FOR  IDGEN_SEQUENCE_NAME_SEQ";
		sequenceQuery = sequenceQuery.replaceAll("SEQUENCE_NAME",
				idType.getName());

		String value = String.valueOf(((BigInteger) (genericDAO
				.getEntityManager().createNativeQuery(sequenceQuery)
				.getResultList().get(0))).longValue());
		
		
		int lastIndex = idType.getLength() - 2 - value.length();
		if (lastIndex < 0)
			lastIndex = 0;
		return idType.getCode() + ZERO_PADDING.substring(0, lastIndex)
				+ String.valueOf(value);

	}

}
