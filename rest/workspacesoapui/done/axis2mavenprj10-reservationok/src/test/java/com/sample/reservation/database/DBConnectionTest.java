package com.sample.reservation.database;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import com.sample.reservation.exception.DBConnectionException;
import junit.framework.Assert;

public class DBConnectionTest {
	private static Connection connection;
	
	@Test
	public void getConnection() {
		try {
			Connection con = DBConnection.getConnection();
			Assert.assertNotNull(con);
			con.close();
		} catch (DBConnectionException e) {
			Assert.fail("We did not get the connection");
		} catch (SQLException e) {
			Assert.fail("We did not get the connection");
		}
	}

	@Test
	public void reConnect() {
		try {
			Connection con = DBConnection.getConnection();
			Assert.assertNotNull(con);
			con.close();

			// Get it again
			con = DBConnection.getConnection();
			Assert.assertNotNull(con);
		} catch (DBConnectionException e) {
			Assert.fail("We did not get the connection");
		} catch (SQLException e) {
			Assert.fail("We did not get the connection");
		}
	}
}
