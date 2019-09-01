package com.sample.reservation;

import com.sample.dao.RoomDAO;
import com.sample.reservation.dto.Room;
import com.sample.reservation.exception.RoomManagementException;

public class RoomManagementService {

	public RoomManagementService() {
	}

	/**
	 * Adding a new room to the system. We create a new Room object and call
	 * addRoom() operation of Storage class to insert the new room record to
	 * ROOM_T table
	 *
	 * @param roomNumber
	 * @param roomType
	 * @param roomSize
	 * @return
	 * @throws RoomManagementException
	 */
	public boolean addRoom(int roomNumber, String roomType, String roomSize) throws RoomManagementException {
		boolean created = false;
		try {
			Room room = new Room();
			room.setRoomNumber(roomNumber);
			room.setRoomType(roomType);
			room.setRoomSize(roomSize);

			RoomDAO roomDAO = new RoomDAO();
			created = roomDAO.crtRoom(room);
		} catch (Exception e) {
			RoomManagementException exception = new RoomManagementException();
			exception.setMessage(e.getMessage());

			throw exception;
		}

		return created;
	}

	public Room getRoom(int roomNumber) throws RoomManagementException {
		Room room;
		try {
			RoomDAO roomDAO = new RoomDAO();
			room = roomDAO.getRoom(roomNumber);
		} catch (Exception e) {
			RoomManagementException exception = new RoomManagementException();
			exception.setMessage(e.getMessage());

			throw exception;
		}

		return room;
	}

	public boolean deleteRoom(int roomNumber) throws RoomManagementException {
		boolean deleted = false;

		try {
			RoomDAO roomDAO = new RoomDAO();
			deleted = roomDAO.deleteRoom(roomNumber);
		} catch (Exception e) {
			RoomManagementException exception = new RoomManagementException();
			exception.setMessage(e.getMessage());

			throw exception;
		}

		return deleted;
	}

}
