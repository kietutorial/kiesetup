package com.sample.reservation;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import com.sample.reservation.dto.Reservation;
import com.sample.reservation.exception.ReservationManagementException;

import junit.framework.Assert;

public class ReservationServiceTest {

	@Test
	public void addReservation() {
		ReservationService reservationService = new ReservationService();

		String guestName = "name693";
		int roomNumber = 745;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date reserved_from = sdf.parse("12/22/2012");
			Date reserved_to = sdf.parse("12/12/2012");

			Reservation reservation = new Reservation();
			reservation.setRoomNumber(roomNumber);
			reservation.setGuestName(guestName);
			reservation.setReserved_from(reserved_from);
			reservation.setReserved_to(reserved_to);

			boolean created = reservationService.addReservation(roomNumber, guestName, reserved_from, reserved_to);
			Assert.assertTrue(created);
		} catch (Exception e) {
			Assert.fail("Reservation creation failed.");
		}
	}

	@Test
	public void getReservation() {
		try {
			int roomNumber = 745;
			ReservationService reservationService = new ReservationService();
			Reservation reservation = reservationService.getReservation(roomNumber);
			
			Assert.assertNotNull(reservation);
		} catch (ReservationManagementException e) {
			Assert.fail("getting Reservation failed.");
		}
	}
	
	
	@Test
	public void removeReservation() {
		try {
			int id = 2;
			ReservationService reservationService = new ReservationService();
			boolean deleted = reservationService.removeReservation(id);
			
			Assert.assertTrue(deleted);
		} catch (ReservationManagementException e) {
			Assert.fail("getting Reservation failed.");
		}	
	}

}
