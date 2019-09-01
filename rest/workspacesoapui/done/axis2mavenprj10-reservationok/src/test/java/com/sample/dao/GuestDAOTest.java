package com.sample.dao;

import java.util.Random;
import org.junit.Test;
import com.sample.reservation.dto.Guest;
import com.sample.reservation.exception.GuestManagementException;
import junit.framework.Assert;

public class GuestDAOTest {

	@Test
	public void crtGuest() {
		try {
			int rnum = new Random().nextInt(1000);
			String name = "name" + rnum;
			String addr = "address" + rnum;

			Guest guest = new Guest(name, addr, rnum);
			GuestDAO guestDAO = new GuestDAO();

			guestDAO.crtGuest(guest);
		} catch (GuestManagementException e) {
			Assert.fail("Did not create guest");
		}
	}

	@Test
	public void getGuest() {
		try {
			String name = "name878";
			GuestDAO guestDAO = new GuestDAO();

			Guest guest = guestDAO.getGuest(name);
			Assert.assertNotNull(guest);
		} catch (GuestManagementException e) {
			Assert.fail("Did not create guest");
		}
	}

	@Test
	public void deleteGuest() {
		try {
			String name = "name878";
			GuestDAO guestDAO = new GuestDAO();

			boolean deleted = guestDAO.deleteGuest(name);
			Assert.assertTrue(deleted);
		} catch (GuestManagementException e) {
			Assert.fail("Did not create guest");
		}
	}

}
