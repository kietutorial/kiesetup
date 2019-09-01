package com.sample.reservation.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.sample.reservation.exception.DBConnectionException;

public class DBConnection {
	private static Connection connection;

	public static Connection getConnection() throws DBConnectionException {
		if (connection == null)
			setConnection();

		return connection;
	}

	private static void setConnection() throws DBConnectionException {
		String driverName = "com.mysql.jdbc.Driver";
		String host = null;
		String port = null;
		String userName = null;
		String password = null;
		String conectionURI = null;
		String schema = null;
		Properties properties = new Properties();

		try {
			InputStream propertyInputStream = DBConnection.class.getClassLoader()
					.getResourceAsStream("mysql.properties");
			properties.load(propertyInputStream);
			userName = properties.getProperty("mysql.username");
			password = properties.getProperty("mysql.password");
			host = properties.getProperty("mysql.host");
			port = properties.getProperty("mysql.port");
			schema = properties.getProperty("mysql.db");

			conectionURI = "jdbc:mysql://" + host + ":" + port + "/" + schema;
		} catch (IOException e) {
			throw new DBConnectionException(e);
		}

		try {
			Class<?> driverClass = Class.forName(driverName);
			connection = DriverManager.getConnection(conectionURI, userName, password);
			connection.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			throw new DBConnectionException("Can not find the driver class ", e);
		} catch (SQLException e) {
			throw new DBConnectionException("Can not get the data base conneciton", e);
		}
	}

}