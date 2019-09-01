package com.csra.eligibility.workflow.medicalincome;

import java.util.Calendar;

import com.csra.eligibility.domain.entity.member.Member;

/**
 * Test data while testing
 * 
 * @author pchauvet
 */
public class WFTestData {

	public static Member basicMember() {
		Calendar date = Calendar.getInstance();
		// Go back 30 years
		Calendar dob = Calendar.getInstance();
		int year = (365) * 30;
		dob.add(Calendar.DAY_OF_YEAR, -year);

		return new Member("Little", "Marcy", dob.getTime());
	}

	public static Member getNewBorn() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, -30);

		return new Member("Little", "Marcy", date.getTime());
	}

	public static Member getHouseHoldIncomeGreateThan50000() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, -30);

		Member mem = new Member("Tracy", "Lylu", date.getTime());
		mem.setHouseHoldIncome(55500);

		return mem;
	}

	public static Member getHouseHoldIncomeZero() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, -30);

		Member mem = new Member("Tracy", "Lylu", date.getTime());
		mem.setHouseHoldIncome(0);

		return mem;
	}

	public static Member getNewBornIncomeGreaterThan50000() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, -30);

		Member mem = new Member("Tracy", "Lylu", date.getTime());
		mem.setHouseHoldIncome(55500);

		return mem;
	}

	public static Member getNewBornIncome10000() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, -30);

		Member mem = new Member("Tracy", "Lylu", date.getTime());
		mem.setHouseHoldIncome(10000);

		return mem;
	}

}
