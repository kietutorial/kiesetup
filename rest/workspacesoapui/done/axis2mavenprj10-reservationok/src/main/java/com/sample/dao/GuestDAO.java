package com.sample.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sample.reservation.database.DBConnection;
import com.sample.reservation.dto.Guest;
import com.sample.reservation.exception.DBConnectionException;
import com.sample.reservation.exception.GuestManagementException;

public class GuestDAO {
	private static Connection connection;

	public GuestDAO() throws GuestManagementException {
		try {
			connection = DBConnection.getConnection();
		} catch (DBConnectionException e) {
			throw new GuestManagementException(e.getMessage());
		}
	}

	public boolean crtGuest(Guest guest) throws GuestManagementException {
		boolean inserted = false;

		String sql = "INSERT INTO GUEST_T VALUES ('" + guest.getName() + "','" + guest.getAddress() + "', "
				+ guest.getAge() + ")";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);

			inserted = true;
		} catch (SQLException e) {
			throw new GuestManagementException("Can not execute the sql query", e);
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
			}
		}

		return inserted;
	}

	public Guest getGuest(String name) throws GuestManagementException {
		String guestName = null;
		String guestAddress = null;
		int guestAge = 0;
		Statement statement = null;

		String sqlStatement = "SELECT * FROM GUEST_T WHERE name = '" + name + "'";
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sqlStatement);

			Guest guest = null;
			while (rs.next()) {
				guest = new Guest();

				guestName = rs.getString("name");
				guestAddress = rs.getString("address");
				guestAge = rs.getInt("age");

				guest.setName(guestName);
				guest.setAge(guestAge);
				guest.setAddress(guestAddress);
			}
			return guest;
		} catch (SQLException e) {
			throw new GuestManagementException("Can not execute the sql query", e);
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
			}
		}
	}

	public boolean deleteGuest(String name) throws GuestManagementException {
		boolean deleted = false;
		
		String sql = "DELETE FROM GUEST_T WHERE name = '" + name + "'";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			
			deleted = true;
		} catch (SQLException e) {
			throw new GuestManagementException("Can not execute the sql query", e);
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
			}
		}
		
		return deleted;
	}

}
