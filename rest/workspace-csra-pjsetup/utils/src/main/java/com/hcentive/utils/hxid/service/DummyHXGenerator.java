package com.hcentive.utils.hxid.service;

public class DummyHXGenerator implements HXIDGenerator {

	@Override
	public String generateHXID(Person person) {

		String hixid= System.nanoTime() + "";
		if(hixid.length()>10)
			hixid=hixid.substring(0, 10);
		return hixid;

	}

}
