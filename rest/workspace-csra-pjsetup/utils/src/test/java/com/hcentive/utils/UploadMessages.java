package com.hcentive.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class UploadMessages {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Connection connection = null;
		Properties props = new Properties();
		String sqlQuery = "insert into messages_i18n values (?,?,?)";
		// String query =
		// "insert into messages_i18n (id, locale, message_key, message_value) values ";
		String locale = "en";
		String message_key = "";
		String message_value = "";

		System.out.println("Running...");
		try {

			// Load the JDBC driver
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);

			// Create a connection to the database
			String url = "jdbc:mysql://localhost:3306/prvex";
			String username = "root";
			String password = "";
			connection = DriverManager.getConnection(url, username, password);

			PreparedStatement updateQuery = connection.prepareStatement(sqlQuery);

			String path = "/Users/Anshu/Documents/workspace/private-exchange/applications/individual-hix-portal/target/individual-webapp-public-3.0.10-SNAPSHOT/WEB-INF/classes/META-INF/";
			//
			System.out.println("Loading Files...");
			FileInputStream in = new FileInputStream(path + "labels-bundle/messages.properties");
			props.load(in);
			// System.out.println(props.keySet());

			@SuppressWarnings("rawtypes")
			Set<String> set = new TreeSet(props.keySet());
			Iterator<String> iter = set.iterator();
			while (iter.hasNext()) {
				message_key = iter.next();
				message_value = props.getProperty(message_key);
				System.out.println("Key is : " + message_key);
				updateQuery.setString(1, locale);
				updateQuery.setString(2, message_key);
				updateQuery.setString(3, message_value);
				updateQuery.addBatch();
			}
			updateQuery.executeBatch();

			// connection.commit();
			connection.close();
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}catch (IOException e) {
			System.out.println(e);
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
}
