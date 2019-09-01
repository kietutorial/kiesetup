/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.dms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author ashishjaiswal
 * 
 */
public class FileSystemBasedDocumentService implements DMSService {

	private static Log logger = LogFactory.getLog(FileSystemBasedDocumentService.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.dms.DMSInterface#addFolder(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void addFolder(String parentFolderPath, String name) throws RuntimeException {
		String fileSeparator = System.getProperty("file.separator");
		File file = new File(parentFolderPath + fileSeparator + name);
		if (file.exists() && file.isDirectory()) {
			logger.info("Directory: " + file + " already exists");
		} else {
			file.mkdir();
			logger.debug("created directory: " + file);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.dms.DMSInterface#putDocument(java.lang.String,
	 * java.lang.String, java.lang.String, java.io.InputStream,
	 * java.util.Properties)
	 */
	@Override
	public String putDocument(String parentFolderPath, String name, String mime, InputStream data, Properties documentProperties)
			throws RuntimeException {
		String fileSeperator = System.getProperty("file.separator");
		File file = new File(parentFolderPath + fileSeperator + name);

		if (file.exists()) {
			logger.info("file: " + file + " already exists");
			file.delete();
			logger.info("file: " + file + " deleted");
		}
		try {
			Boolean created = file.createNewFile();
			logger.debug("file: " + file + " created = " + created);
			// documentProperties.load(data);

			Set<Object> propertyKeySet = documentProperties.keySet();
			Iterator<Object> it = propertyKeySet.iterator();
			while (it.hasNext()) {
				Object key = it.next();
				if (key instanceof String) {
					if (StringUtils.equalsIgnoreCase((String) key, DMSConstants.IS_READBLE)) {
						String value = documentProperties.getProperty((String) key);
						file.setReadable(Boolean.parseBoolean(value));

					} else if (StringUtils.equalsIgnoreCase((String) key, DMSConstants.IS_WRITABLE)) {
						String value = documentProperties.getProperty((String) key);
						file.setWritable(Boolean.parseBoolean(value));

					} else if (StringUtils.equalsIgnoreCase((String) key, DMSConstants.IS_EXECUTABLE)) {
						String value = documentProperties.getProperty((String) key);
						file.setExecutable(Boolean.parseBoolean(value));
					}
				}
			}

			OutputStream fileOutputStream = new FileOutputStream(file);
			byte buf[] = new byte[1024];
			int len;

			while ((len = data.read(buf)) > 0) {
				fileOutputStream.write(buf, 0, len);
			}
			fileOutputStream.close();
			data.close();
			logger.info("File: " + file + " writing process is complete");

		} catch (IOException e) {
			logger.error(e, e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hcentive.utils.dms.DMSInterface#getDocumentList(java.lang.String)
	 */
	@Override
	public List<String> getDocumentList(String parentFolderPath) throws RuntimeException {
		File file = new File(parentFolderPath);
		if (file.exists() && file.isDirectory()) {
			return Arrays.asList(file.list());
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.dms.DMSInterface#getDocument(java.lang.String)
	 */
	@Override
	public InputStream getDocument(String documentPath) throws RuntimeException {
		File file = new File(documentPath);
		if (file.exists()) {
			try {
				return new FileInputStream(file);
			} catch (FileNotFoundException e) {
				logger.error(e, e);
			}
		}
		logger.info("File: " + file + " doesn't exists");
		return null;
	}

	@Override
	public boolean removeDocument(String documentPath) throws RuntimeException {
		File file = new File(documentPath);
		if (file.exists()) {
			return file.delete();
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hcentive.utils.dms.DMSInterface#getDocumentProperties(java.lang.String
	 * )
	 */
	@Override
	public Properties getDocumentProperties(String documentPath) throws RuntimeException {
		File file = new File(documentPath);
		if (file.exists()) {
			logger.debug("filling properties for file: " + file);

			Properties fileProperties = new Properties();
			fileProperties.setProperty(DMSConstants.IS_READBLE, String.valueOf(file.canRead()));
			fileProperties.setProperty(DMSConstants.IS_WRITABLE, String.valueOf(file.canWrite()));
			fileProperties.setProperty(DMSConstants.IS_EXECUTABLE, String.valueOf(file.canExecute()));
			return fileProperties;
		}
		logger.info("File: " + file + " doesn't exixts");
		return null;
	}
}
