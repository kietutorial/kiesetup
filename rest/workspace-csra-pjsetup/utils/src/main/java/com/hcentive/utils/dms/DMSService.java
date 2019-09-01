/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.dms;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author ashishjaiswal
 * 
 */
public interface DMSService {

	/**
	 * Adds a folder of given name at the parentFolderPath.
	 * 
	 * @param parentFolderPath
	 *            : absolute path of the parent folder
	 * @param name
	 *            : name of the folder
	 * @throws RuntimeException
	 *             : if parentFolderPath does not exist or unable to create a
	 *             folder
	 */
	public void addFolder(String parentFolderPath, String name) throws RuntimeException;

	/**
	 * Add/update a document with the given name at the parentFolderPath. Also
	 * attach the given properties with the document.
	 * 
	 * @param parentFolderPath
	 *            : absolute path of the parent folder
	 * @param name
	 *            : name of the document
	 * @param mime
	 *            : mime type of the document
	 * @param data
	 *            : document data stream
	 * @param documentProperties
	 *            : various properties which needs to be saved with document ex.
	 *            author, lastModifiedDate,
	 * @return uuid of the created document
	 * @throws RuntimeException
	 */
	public String putDocument(String parentFolderPath, String name, String mime, InputStream data, Properties documentProperties)
			throws RuntimeException;

	/**
	 * Return the name of all the documents for a given parentFolder
	 * 
	 * @param parentFolderPath
	 * @return
	 * @throws RuntimeException
	 */
	public List<String> getDocumentList(String parentFolderPath) throws RuntimeException;

	/**
	 * Returns the datastream for the given documentPath
	 * 
	 * @param documentPath
	 * @return
	 * @throws RuntimeException
	 */
	public InputStream getDocument(String documentPath) throws RuntimeException;

	/**
	 * Delete the document for the given documentPath
	 * 
	 * @param documentPath
	 * @return true if document is deleted successfully
	 * @throws RuntimeException
	 */
	public boolean removeDocument(String documentPath) throws RuntimeException;

	/**
	 * Returns the list of Properties attached with this document
	 * 
	 * @param documentPath
	 * @return
	 * @throws RuntimeException
	 */
	public Properties getDocumentProperties(String documentPath) throws RuntimeException;
}
