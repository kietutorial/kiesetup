/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.dms;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class JackRabbitDMSService implements DMSService {

	@Override
	public void addFolder(String parentFolderPath, String name) throws RuntimeException {
		// TODO Auto-generated method stub

	}

	@Override
	public String putDocument(String parentFolderPath, String name, String mime, InputStream data, Properties documentProperties)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getDocumentList(String parentFolderPath) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getDocument(String documentPath) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeDocument(String documentPath) throws RuntimeException {
		// @TODO need to add the implementation
		return false;
	}

	@Override
	public Properties getDocumentProperties(String documentPath) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
