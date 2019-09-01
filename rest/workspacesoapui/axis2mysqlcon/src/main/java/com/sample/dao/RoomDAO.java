package com.sample.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sample.reservation.database.DBConnection;
import com.sample.reservation.dto.Room;
import com.sample.reservation.exception.DBConnectionException;
import com.sample.reservation.exception.RoomManagementException;

public class RoomDAO {
	private static Connection connection;

	public RoomDAO() throws RoomManagementException {
		try {
			connection = DBConnection.getConnection();
		} catch (DBConnectionException e) {
			throw new RoomManagementException(e.getMessage());
		}
	}

	public boolean crtRoom(Room room) throws RoomManagementException {
		boolean inserted = false;

		String sql = "insert into ROOM_T values ('" + room.getRoomNumber() + "','" + room.getRoomType() + "', '"
				+ room.getRoomSize() + "')";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);

			inserted = true;
		} catch (SQLException e) {
			throw new RoomManagementException("Can not execute the sql query", e);
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
			}
		}

		return inserted;
	}

	public Room getRoom(int roomNumber) throws RoomManagementException {
		int roomNo = 0;
		String roomType = null;
		String roomSize = null;
		Statement statement = null;

		String sql = "SELECT * FROM ROOM_T where room_number = '" + roomNumber + "'";
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			Room room = null;
			while (rs.next()) {
				room = new Room();

				roomNo = rs.getInt("room_number");
				roomType = rs.getString("room_type");
				roomSize = rs.getString("room_size");

				room.setRoomNumber(roomNo);
				room.setRoomType(roomType);
				room.setRoomSize(roomSize);
			}
			return room;
		} catch (SQLException e) {
			throw new RoomManagementException("Can not execute the sql query", e);
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
			}
		}
	}

	public boolean deleteRoom(int roomNumber) throws RoomManagementException {
		boolean deleted = false;

		String sql = "delete from ROOM_T where room_number = '" + roomNumber + "'";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);

			deleted = true;
		} catch (SQLException e) {
			throw new RoomManagementException("Can not execute the sql query", e);
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
			}
		}

		return deleted;
	}

}
