package com.sample.dao;


import java.util.Random;
import org.junit.Test;
import com.sample.reservation.dto.Room;
import com.sample.reservation.exception.RoomManagementException;
import junit.framework.Assert;

public class RoomDAOTest {

	@Test
	public void crtRoom() throws RoomManagementException {
		try {
			Room room = new Room();

			int roomNo = new Random().nextInt(1000);
			String roomType = "roomtype" + roomNo;
			String roomSize = "roomsize" + roomNo;
			room.setRoomNumber(roomNo);
			room.setRoomType(roomType);
			room.setRoomSize(roomSize);

			RoomDAO roomDAO = new RoomDAO();
			boolean created = roomDAO.crtRoom(room);

			Assert.assertTrue(created);
		} catch (Exception e) {
			Assert.fail("Did not create room");
		}
	}

	@Test
	public void getRoom() throws RoomManagementException {
		try {
			int roomNo = 123;

			RoomDAO roomDAO = new RoomDAO();
			Room room = roomDAO.getRoom(roomNo);

			Assert.assertNotNull(room);
		} catch (Exception e) {
			Assert.fail("Did not create room");
		}
	}

	@Test
	public void deleteRoom() throws RoomManagementException {
		try {
			int roomNo = 123;

			RoomDAO roomDAO = new RoomDAO();
			boolean deleted = roomDAO.deleteRoom(roomNo);

			Assert.assertTrue(deleted);
		} catch (Exception e) {
			Assert.fail("Did not create room");
		}
	}

}
