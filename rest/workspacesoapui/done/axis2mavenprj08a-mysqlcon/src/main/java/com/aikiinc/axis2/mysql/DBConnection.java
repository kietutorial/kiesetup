package com.aikiinc.axis2.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() throws Exception {
		String driverName = "com.mysql.jdbc.Driver";
		String host = null;
		String port = null;
		String userName = null;
		String password = null;
		String conectionURI = null;
		Properties properties = new Properties();
	
		try {
			InputStream propertyInputStream = DBConnection.class.getClassLoader()
					.getResourceAsStream("mysql.properties");
			properties.load(propertyInputStream);
			userName = properties.getProperty("mysql.username");
			password = properties.getProperty("mysql.password");
			host = properties.getProperty("mysql.host");
			port = properties.getProperty("mysql.port");
	
			conectionURI = "jdbc:mysql://" + host + ":" + port + "/HOTEL_RESERVATION_DB";
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		try {
			Class driverClass = Class.forName(driverName);
			Connection connection = DriverManager.getConnection(conectionURI, userName, password);
			connection.setAutoCommit(true);
			return connection;
		} catch (ClassNotFoundException e) {
			throw new Exception("Can not find the driver class ", e);
		} catch (SQLException e) {
			throw new Exception("Can not get the data base conneciton", e);
		}
	}

}