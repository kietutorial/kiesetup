/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.dms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcentive.utils.dms.DMSConstants;
import com.hcentive.utils.dms.DMSService;
import com.hcentive.utils.dms.FileSystemBasedDocumentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext.xml" })
public class FileSystemBasedDocumentServiceTest {

	public static Logger logger = LoggerFactory.getLogger(FileSystemBasedDocumentServiceTest.class);

	DMSService dmsService = new FileSystemBasedDocumentService();

	String parentFolderPath = "D:\\mytools\\test";

	@Test
	public void testFileSystemDocumentList() {
		logger.info(dmsService.getDocumentList(parentFolderPath).toString());
	}

	@Test
	public void testDirectoryCreation() {
		dmsService.addFolder(parentFolderPath, "test");
	}

	@Test
	public void testAddDocument() {

		String name = "test1.txt";
		String mime = "";
		InputStream is = null;
		try {
			is = new FileInputStream(new File(parentFolderPath + "\\test.txt"));
		} catch (FileNotFoundException e) {
			logger.error("Error in reading file");
		}
		Properties properties = new Properties();
		properties.setProperty(DMSConstants.IS_READBLE, String.valueOf(true));
		properties.setProperty(DMSConstants.IS_WRITABLE, String.valueOf(true));
		properties.setProperty(DMSConstants.IS_EXECUTABLE, String.valueOf(true));
		properties.setProperty(DMSConstants.LAST_MODIFIED_TIME, (new Date()).toString());

		dmsService.putDocument(parentFolderPath, name, mime, is, properties);

	}

	@Test
	public void testGetDocument() {
		String parentFolderPath = "D:\\mytools\\test\\test.txt";
		logger.info("Document stream is:" + dmsService.getDocument(parentFolderPath));
	}

	@Test
	public void testGetDocumentList() {
		logger.info("Document List:" + dmsService.getDocumentList(parentFolderPath));
	}

	@Test
	public void testgetDocumentProperties() {
		logger.info("Document properties:" + dmsService.getDocumentProperties(parentFolderPath));
	}
}
