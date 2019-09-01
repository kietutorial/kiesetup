package com.sample.reservation.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import org.junit.Test;

import com.aikiinc.axis2.mysql.DBConnection;

import junit.framework.Assert;

public class HelloTest {

	@Test
	public void getConnection() {
		try {
			Connection con = DBConnection.getConnection();
			Assert.assertNotNull(con);
		} catch (Exception e) {
			Assert.fail("We did not get the connection");
		}
	}

	@Test
	public void showData() {
		try {
			Connection con = DBConnection.getConnection();
			getHello(con);
		} catch (Exception e) {
			Assert.fail("We did not get the connection");
		}
	}

	@Test
	public void addHello() {
		try {
			Connection con = DBConnection.getConnection();
			addHello(con);

			showData();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("We did not add hello");
		}
	}

	private void getHello(Connection connection) throws Exception {
		Statement statement = null;
		String guestName = null;
		String guestAddress = null;
		int age = 0;
		String sqlStatement = "SELECT * FROM GUEST_T";

		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sqlStatement);

			getRecordCount(rs);

			System.out.println("");

			int r = 1;
			while (rs.next()) {
				guestName = rs.getString("name");
				guestAddress = rs.getString("address");
				age = rs.getInt("age");

				System.out.format("%d name:%s, address:%s, age:%d", r++, guestName, guestAddress, age);
				System.out.println();
			}
		} catch (SQLException e) {
			throw new Exception("Can not execute the sql query", e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (Exception e) {
			}
		}

	}

	private void getRecordCount(ResultSet rs) {
		int size = 0;
		try {
			rs.last();
			size = rs.getRow();
			rs.beforeFirst();
			System.out.format("record size:%d", size);
		} catch (Exception ex) {
		}
	}

	private void addHello(Connection connection) throws Exception {
		int rnum = new Random().nextInt(1000);
		String data = "hello " + rnum;

		String sql = "insert into GUEST_T(name, age) value('" + data + "'," + rnum + ")";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			statement.execute(sql);

			System.out.format("Inserted entry: %s ", data);
		} catch (SQLException e) {
			throw new Exception("Can not execute the sql query", e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (Exception e) {
			}
		}
	}

}
