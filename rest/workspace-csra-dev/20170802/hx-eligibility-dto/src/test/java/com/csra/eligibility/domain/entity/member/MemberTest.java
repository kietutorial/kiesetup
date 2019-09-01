package com.csra.eligibility.domain.entity.member;

import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

import org.junit.Test;

public class MemberTest {
	private final static Logger LOG = LoggerFactory.getLogger(MemberTest.class);

	@Test
	public void isNewBorn() {
		Calendar date = Calendar.getInstance();
		// Go back 30 days
		date.add(Calendar.DAY_OF_MONTH, -30);

		Member mem = new Member("Little", "Marcy", date.getTime());
		// LOG.info(mem.toString());
		assertNotNull(mem);
		assertEquals(mem.getFirstName(), "Little");
		assertEquals(mem.getLastName(), "Marcy");
		assertTrue(mem.isNewBorn());

	}

	@Test
	public void isInfant() {
		Calendar date = Calendar.getInstance();
		// Go back 4 years
		date.add(Calendar.YEAR, -4);

		Member mem = new Member("Little", "Marcy", date.getTime());
		// LOG.info(mem.toString());
		assertNotNull(mem);
		assertEquals(mem.getFirstName(), "Little");
		assertEquals(mem.getLastName(), "Marcy");
		assertTrue(mem.isInfant());
	}

	@Test
	public void isYouth() {
		Calendar date = Calendar.getInstance();
		// Go back 4 years
		date.add(Calendar.YEAR, -10);

		Member mem = new Member("Little", "Marcy", date.getTime());
		// LOG.info(mem.toString());
		assertNotNull(mem);
		assertEquals(mem.getFirstName(), "Little");
		assertEquals(mem.getLastName(), "Marcy");
		assertTrue(mem.isYouth());
	}

	@Test
	public void isTeen() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, -17);

		Member mem = new Member("Little", "Marcy", date.getTime());
		LOG.info(mem.toString());
		assertNotNull(mem);
		assertEquals(mem.getFirstName(), "Little");
		assertEquals(mem.getLastName(), "Marcy");
		assertTrue(mem.isTeen());
	}

	@Test
	public void isAdult() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, -35);

		Member mem = new Member("Linda", "Marcy", date.getTime());
		assertNotNull(mem);
		assertEquals(mem.getFirstName(), "Linda");
		assertEquals(mem.getLastName(), "Marcy");
		assertTrue(mem.isAdult());
	}

	@Test
	public void isSenior() {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, -55);

		Member mem = new Member("Linda", "Marcy", date.getTime());
		assertNotNull(mem);
		assertEquals(mem.getFirstName(), "Linda");
		assertEquals(mem.getLastName(), "Marcy");
		assertTrue(mem.isAdult());
	}

}
