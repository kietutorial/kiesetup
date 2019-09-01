package com.sample.reservation;

import com.sample.dao.GuestDAO;
import com.sample.reservation.dto.Guest;
import com.sample.reservation.exception.GuestManagementException;

public class GuestManagementService {

	public GuestManagementService() {
	}

	public boolean addGuest(String name, String address, int age) throws GuestManagementException {
		boolean inserted = false;
		Guest guest = new Guest();
		guest.setName(name);
		guest.setAddress(address);
		guest.setAge(age);

		try {
			GuestDAO guestDAO = new GuestDAO();
			guestDAO.crtGuest(guest);

			inserted = true;
		} catch (GuestManagementException e) {
			e.setMessage("Guest " + guest.getName() + " was not processed. Reason: " + e.getMessage());
			throw new GuestManagementException(e);
		}

		return inserted;
	}

	public Guest getGuest(String name) throws GuestManagementException {
		Guest guest = null;

		try {
			GuestDAO guestDAO = new GuestDAO();
			guest = guestDAO.getGuest(name);
		} catch (GuestManagementException e) {
			e.setMessage("Guest " + name + " was not processed. Reason: " + e.getMessage());
			throw new GuestManagementException(e);
		}

		return guest;
	}

	/**
	 * Deleting an existing guest. We call deleteGuest() method of Storage class
	 * to delete a guest from GUEST_T table
	 *
	 * @param guestName
	 * @throws GuestManagementException
	 */
	public boolean deleteGuest(String name) throws GuestManagementException {
		boolean deleted = false;

		try {
			GuestDAO guestDAO = new GuestDAO();
			Guest guest = guestDAO.getGuest(name);
			if (guest != null) {
				deleted = guestDAO.deleteGuest(guest.getName());
			}
		} catch (GuestManagementException e) {
			e.setMessage("Guest " + name + " was not processed. Reason: " + e.getMessage());
			throw new GuestManagementException(e);
		}

		return deleted;
	}

}
