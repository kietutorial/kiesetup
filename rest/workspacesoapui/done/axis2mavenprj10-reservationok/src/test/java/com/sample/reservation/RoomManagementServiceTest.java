package com.sample.reservation;

import java.util.Random;
import org.junit.Test;

import com.sample.dao.RoomDAO;
import com.sample.reservation.dto.Room;
import com.sample.reservation.exception.RoomManagementException;

import junit.framework.Assert;

public class RoomManagementServiceTest {

	@Test
	public void addRoom() {
		RoomManagementService roomManagementService = new RoomManagementService();

		int roomNo = new Random().nextInt(1000);
		String roomType = "roomtype" + roomNo;
		String roomSize = "roomsize" + roomNo;

		try {
			boolean created = roomManagementService.addRoom(roomNo, roomType, roomSize);

			Assert.assertTrue(created);
		} catch (RoomManagementException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void getRoom() throws RoomManagementException {
		RoomManagementService roomManagementService = new RoomManagementService();
		
		try {
			int roomNo = 23;

			Room room = roomManagementService.getRoom(roomNo);
			Assert.assertNotNull(room);
		} catch (Exception e) {
			Assert.fail("Did not create room");
		}
	}
	
	
	@Test
	public void deleteRoom() {
		RoomManagementService roomManagementService = new RoomManagementService();
		
		try {
			int roomNo = 23;

			boolean deleted = roomManagementService.deleteRoom(roomNo);
			Assert.assertNotNull(deleted);
		} catch (Exception e) {
			Assert.fail("Did not create room");
		}
	}
	
}
