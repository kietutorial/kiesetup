/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SFTClient {

	private static Logger LOGGER = LoggerFactory.getLogger(SFTClient.class);

	private String host;
	private int port;
	private String userName;
	private String password;

	private JSch jsch = null;
	private Session session = null;
	private ChannelSftp channel = null;

	public SFTClient(String host, int port, String userName, String password) {
		this.host = host;
		this.port = port;
		this.userName = userName;
		this.password = password;
		jsch = new JSch();
	}

	public void connect() throws Exception {
		try {
			// Create a session
			session = jsch.getSession(userName, host, port);
			session.setPassword(password);

			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect();
		} catch (Exception e) {
			LOGGER.error("Unable to connect to FTP server.", e);
			throw e;
		}
	}

	public void disConnect() {
		try {
			if (channel != null && channel.isConnected()) {
				channel.quit();
			}
		} catch (Exception exc) {
			LOGGER.error("Unable to close channel from FTP server. ", exc);
		} finally {
			try {
				if (session != null && session.isConnected()) {
					session.disconnect();
				}
			} catch (Exception exc) {
				LOGGER.error("Unable to close session from FTP server. ", exc);
			}
		}

	}

	public void uploadFile(String localFilePath, String remoteDir, String remoteFileName) throws Exception {
		channel.cd(remoteDir);
		try {
			File f = new File(localFilePath);
			channel.put(new FileInputStream(f), remoteFileName + ".tmp");
			channel.rename(remoteFileName + ".tmp", remoteFileName);
		} catch (Exception e) {
			LOGGER.error("Unable to upload file to sftp server. ", e);
			throw e;
		}
	}

	public static void main(String[] args) throws Exception {
		SFTClient sftpClient = new SFTClient("pdcftp.cvty.com", 21000, "HCENTIVE", "ryNa9xbw");

		LOGGER.info("Starting Upload");
		try {
			sftpClient.connect();
			sftpClient.uploadFile("/Users/ashishjaiswal/temp/sample-app.pdf", "/Incoming/Test", "test-plz-ignore.pdf");
		} catch (Exception e) {
			throw e;
		} finally {
			sftpClient.disConnect();
		}
		LOGGER.info("Upload complete");
	}
}
