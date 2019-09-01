package com.sample.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

import com.sample.reservation.dto.Reservation;
import com.sample.reservation.exception.DBConnectionException;
import junit.framework.Assert;

public class ReservationDAOTest {

	@Test
	public void proceedReservation() {
		try {
			ReservationDAO reservationDAO = new ReservationDAO();

			String guest_name = "name367";
			int roomNumber = 199;

			boolean proceed = reservationDAO.proceedReservation(guest_name, roomNumber);
			Assert.assertTrue(proceed);
		} catch (DBConnectionException e) {
			Assert.fail("Reservation failed.");
		}

	}

	@Test
	public void crtReservation() {
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

			ReservationDAO reservationDAO = new ReservationDAO();
			boolean created = reservationDAO.crtReservation(reservation);
			Assert.assertTrue(created);
		} catch (Exception e) {
			Assert.fail("Reservation creation failed.");
		}
	}

	@Test
	public void getReservation() {
		try {
			int roomNumber = 745;

			ReservationDAO reservationDAO = new ReservationDAO();
			Reservation reservation = reservationDAO.getReservation(roomNumber);

			Assert.assertNotNull(reservation);
		} catch (DBConnectionException e) {
			Assert.fail("getting Reservation failed.");
		}
	}

	@Test
	public void deleteReservation() {
		try {
			int id = 2;

			ReservationDAO reservationDAO = new ReservationDAO();
			boolean deleted = reservationDAO.deleteReservation(id);

			Assert.assertTrue(deleted);
		} catch (DBConnectionException e) {
			e.printStackTrace();

			Assert.fail("Reservation deletion failed.");
		}
	}

}
