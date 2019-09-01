package com.sample.reservation;

import java.util.Date;

import com.sample.dao.ReservationDAO;
import com.sample.reservation.dto.Reservation;
import com.sample.reservation.exception.DBConnectionException;
import com.sample.reservation.exception.ReservationManagementException;

public class ReservationService {

	public ReservationService() {
	}

	/**
	 * This method is used to add a new reservation for a given guest
	 *
	 * @param roomNumber
	 * @param guestName
	 * @param reserved_from
	 * @param reserved_to
	 * @return
	 * @throws ReservationManagementException
	 */
	public boolean addReservation(int roomNumber, String guestName, Date reserved_from, Date reserved_to)
			throws ReservationManagementException {
		Reservation reservation = new Reservation();
		reservation.setRoomNumber(roomNumber);
		reservation.setGuestName(guestName);
		reservation.setReserved_from(reserved_from);
		reservation.setReserved_to(reserved_to);

		try {
			ReservationDAO reservationDAO = new ReservationDAO();
			reservationDAO.crtReservation(reservation);
		} catch (DBConnectionException e) {
			throw new ReservationManagementException(e);
		}

		return true;
	}

	/**
	 * This method is used to find out the reservation details of a given room
	 *
	 * @param RoomNumber
	 * @return
	 * @throws ReservationManagementException
	 */
	public Reservation getReservation(int roomNumber) throws ReservationManagementException {
		Reservation reservation = null;

		try {
			ReservationDAO reservationDAO = new ReservationDAO();
			reservation = reservationDAO.getReservation(roomNumber);
		} catch (DBConnectionException e) {
			throw new ReservationManagementException(e);
		}

		return reservation;
	}

	/**
	 * This method is used to remove an existing reesrvation
	 *
	 * @param reservationID
	 * @throws ReservationManagementException
	 */
	public boolean removeReservation(int reservationID) throws ReservationManagementException {
		boolean deleted = false;

		try {
			ReservationDAO reservationDAO = new ReservationDAO();
			deleted = reservationDAO.deleteReservation(reservationID);
		} catch (DBConnectionException e) {
			throw new ReservationManagementException(e);
		}

		return deleted;
	}

}
