package com.sample.reservation;

import java.util.Random;

import org.junit.Test;

import com.sample.reservation.dto.Guest;
import com.sample.reservation.exception.GuestManagementException;

import junit.framework.Assert;

public class GuestManagementServiceTest {

	@Test
	public void addGuest() {
		try {
			GuestManagementService guestManagementService = new GuestManagementService();

			int rnum = new Random().nextInt(1000);
			String name = "name" + rnum;
			String addr = "address" + rnum;

			boolean inserted = guestManagementService.addGuest(name, addr, rnum);

			Assert.assertTrue(inserted);
		} catch (GuestManagementException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void getGuest() {
		try {
			GuestManagementService guestManagementService = new GuestManagementService();

			String name = "name225";

			Guest guest = guestManagementService.getGuest(name);
			Assert.assertNotNull(guest);
		} catch (GuestManagementException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void deleteGuest() {
		try {
			GuestManagementService guestManagementService = new GuestManagementService();

			String name = "name225";

			guestManagementService.deleteGuest(name);
		} catch (GuestManagementException e) {
			Assert.fail(e.getMessage());
		}
	}

}
