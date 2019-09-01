package com.sample.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.sample.reservation.database.DBConnection;
import com.sample.reservation.dto.Reservation;
import com.sample.reservation.exception.DBConnectionException;

public class ReservationDAO {
	private static Connection connection;

	public ReservationDAO() throws DBConnectionException {
		try {
			connection = DBConnection.getConnection();
		} catch (DBConnectionException e) {
			throw new DBConnectionException(e.getMessage());
		}
	}

	public boolean crtReservation(Reservation reservation) throws DBConnectionException {

		if (proceedReservation(reservation.getGuestName(), reservation.getRoomNumber())) {
			try {
				Statement statement = connection.createStatement();
				String sql = "insert into RESERVATION_T(guest_name,room_no,reserved_from,reserved_to) values ('"
						+ reservation.getGuestName() + "','" + reservation.getRoomNumber() + "', '"
						+ new java.sql.Date(reservation.getReserved_from().getTime()) + "', '"
						+ new java.sql.Date(reservation.getReserved_to().getTime()) + "')";

				statement.execute(sql);

				return true;
			} catch (SQLException e) {
				throw new DBConnectionException(e);
			}
		} else {
			throw new DBConnectionException("Reservation already Exists");
		}
	}

	/**
	 * This method is used to find out the reservation details of a given room
	 *
	 * @param RoomNumber
	 * @return
	 * @throws ReservationManagementException
	 */
	public Reservation getReservation(int roomNumber) throws DBConnectionException {
		Reservation reservation = null;
		int resID = 0;
		String guestName = null;
		Date reservedFrom = null;
		Date reservedTo = null;
		Statement statement = null;

		String sql = "SELECT * FROM RESERVATION_T where room_no = '" + roomNumber + "'";
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				reservation = new Reservation();

				resID = rs.getInt("res_id");
				guestName = rs.getString("guest_name");
				roomNumber = rs.getInt("room_no");
				reservedFrom = rs.getDate("reserved_from");
				reservedTo = rs.getDate("reserved_to");

				reservation.setReservationID(resID);
				reservation.setGuestName(guestName);
				reservation.setRoomNumber(roomNumber);
				reservation.setReserved_from(reservedFrom);
				reservation.setReserved_to(reservedTo);
			}
			return reservation;
		} catch (SQLException e) {
			throw new DBConnectionException("Can not execute the sql query", e);
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
				throw new DBConnectionException("Error occurred while closing the connection");
			}
		}
	}

	/**
	 * This method is used to remove an existing reesrvation
	 */
	public boolean deleteReservation(int reservationID) throws DBConnectionException {
		try {
			Statement statement = connection.createStatement();

			String sql = "DELETE FROM RESERVATION_T WHERE res_id = " + reservationID + "";
			statement.execute(sql);
		} catch (SQLException e) {
			throw new DBConnectionException("Can not execute the sql query", e);
		}

		return true;
	}

	/**
	 * This method is used to verify whether the pre-requisites are satisfied
	 * before a reservation is done
	 * 
	 * @param guest_name
	 * @param roomNumber
	 * @return
	 * @throws DBConnectionException
	 */
	public boolean proceedReservation(String guest_name, int roomNumber) throws DBConnectionException {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		Statement statement1 = null;
		Statement statement2 = null;
		Statement statement3 = null;
		Statement statement4 = null;

		try {
			statement1 = connection.createStatement();
			statement2 = connection.createStatement();
			statement3 = connection.createStatement();
			statement4 = connection.createStatement();
		} catch (SQLException e) {
			throw new DBConnectionException("Can not execute the sql query", e);
		}
		// Execute the necessary sql queries before adding a new reservation
		String sqlStatement1 = "SELECT guest_name, room_no FROM RESERVATION_T where guest_name='" + guest_name + "'";
		String sqlStatement2 = "SELECT guest_name, room_no FROM RESERVATION_T where room_no='" + roomNumber + "'";
		String sqlStatement3 = "SELECT name FROM GUEST_T where name='" + guest_name + "'";
		String sqlStatement4 = "SELECT room_number FROM ROOM_T where room_number='" + roomNumber + "'";

		boolean proceedReservation;
		try {
			rs1 = statement1.executeQuery(sqlStatement1);
			rs2 = statement2.executeQuery(sqlStatement2);
			rs3 = statement3.executeQuery(sqlStatement3);
			rs4 = statement4.executeQuery(sqlStatement4);
			if (rs3.next() == true && rs4.next() == true && rs1.next() == false && rs2.next() == false) {
				proceedReservation = true;

			} else {
				proceedReservation = false;
			}

		} catch (SQLException e) {
			throw new DBConnectionException("Can not execute the sql query", e);
		} finally {
			try {
				statement1.close();
			} catch (Exception e) {
				throw new DBConnectionException("Error occurred while closing the connection");
			}
		}

		return proceedReservation;
	}
}
