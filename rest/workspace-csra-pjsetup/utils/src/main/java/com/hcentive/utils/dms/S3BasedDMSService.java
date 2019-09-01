/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.dms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

/**
 * @author ashishjaiswal
 * 
 */
public class S3BasedDMSService implements DMSService {

	private static Log logger = LogFactory.getLog(S3BasedDMSService.class);

	private static AmazonS3 getAmazonServiceClient() {
		// TODO Auto-generated method stub
		return new AmazonS3Client(new BasicAWSCredentials("", ""));
	}

	private static String getS3SystemSeparator() {
		// System.getProperty("file.separator");
		return "/";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.dms.DMSService#addFolder(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void addFolder(String parentFolderPath, String name) throws RuntimeException {
		// Need to insert credential
		AmazonS3 s3 = getAmazonServiceClient();
		// List<Bucket> bucketList = s3.listBuckets();
		logger.info("Adding bucket named: " + name);
		Bucket createdBucket = s3.createBucket(name);
		logger.info("Added bucket named: " + name + " after creation object:" + createdBucket);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.dms.DMSService#putDocument(java.lang.String,
	 * java.lang.String, java.lang.String, java.io.InputStream,
	 * java.util.Properties)
	 */
	@Override
	public String putDocument(String parentFolderPath, String name, String mime, InputStream data, Properties documentProperties)
			throws RuntimeException {
		// TODO Auto-generated method stub
		AmazonS3 s3 = getAmazonServiceClient();
		if (parentFolderPath == null || StringUtils.isEmpty(parentFolderPath)) {
			logger.info("Please specify parent folder path");
			return "Parent folder path is not specfied";
		}
		String[] splittedParentFolder = StringUtils.split(parentFolderPath, "/");
		if (splittedParentFolder[0] == null) {
			logger.info("No bucket name specified");
			return "Please specify bucket Name";
		}
		boolean bucketExists = s3.doesBucketExist(splittedParentFolder[0]);
		if (!bucketExists) {
			logger.error("Bucket: " + splittedParentFolder[0] + " does not exists.");
			return "Bucket " + splittedParentFolder[0] + " doesn't exists";
		}
		File file = new File(name);
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(file);
			byte buf[] = new byte[1024];
			int len = 0;
			while ((len = data.read(buf)) > 0) {
				outputStream.write(buf, 0, len);
			}
			outputStream.close();
			data.close();
		} catch (FileNotFoundException e) {
			logger.error("File: " + file + "not found. ", e);
		} catch (IOException e) {
			logger.error("IO Exception: ", e);
		}
		String key = StringUtils.removeStartIgnoreCase(parentFolderPath, splittedParentFolder[0] + "/");
		PutObjectRequest putRequest = new PutObjectRequest(splittedParentFolder[0], key, file);
		try {
			putRequest.getMetadata().setContentEncoding(documentProperties.getProperty(DMSConstants.CONTENT_ENCODING));
			putRequest.getFile().setReadable(Boolean.parseBoolean(documentProperties.getProperty(DMSConstants.IS_READBLE)));
			putRequest.getFile().setWritable(Boolean.parseBoolean(documentProperties.getProperty(DMSConstants.IS_WRITABLE)));
			putRequest.getFile().setExecutable(Boolean.parseBoolean(documentProperties.getProperty(DMSConstants.IS_EXECUTABLE)));
			putRequest.setBucketName(putRequest.getBucketName());
		} catch (Exception e) {
			logger.info("Unable to parse metadata for file:" + name);
		}

		PutObjectResult result = s3.putObject(putRequest);
		logger.debug("Added file name:" + file + " with result:" + result);
		return result.getVersionId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.dms.DMSService#getDocumentList(java.lang.String)
	 */
	@Override
	public List<String> getDocumentList(String parentFolderPath) throws RuntimeException {
		AmazonS3 s3 = getAmazonServiceClient();
		if (parentFolderPath == null || StringUtils.isEmpty(parentFolderPath)) {
			logger.info("Please specify parent folder path");
			return null;
		}

		String separator = getS3SystemSeparator();
		String[] splittedParentFolder = StringUtils.split(parentFolderPath, separator);
		String bucketName = splittedParentFolder[0];
		if (bucketName == null) {
			logger.info("No bucket name specified");
			return null;
		}
		boolean bucketExists = s3.doesBucketExist(splittedParentFolder[0]);
		if (!bucketExists) {
			logger.error("Bucket name doesn't exists");
			return null;
		}

		String key = StringUtils.removeStartIgnoreCase(parentFolderPath, bucketName + separator);
		ObjectListing objectListing = s3.listObjects(bucketName, key);
		if (objectListing != null) {
			List<S3ObjectSummary> objectSummaries = objectListing.getObjectSummaries();
			if (objectSummaries != null) {
				List<String> objectList = new ArrayList<String>();
				for (S3ObjectSummary s3Object : objectSummaries) {
					objectList.add(s3Object.getKey());
				}
				logger.info("Returning objects list of size:" + objectList.size());
				return objectList;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.dms.DMSService#getDocument(java.lang.String)
	 */
	@Override
	public InputStream getDocument(String documentPath) throws RuntimeException {
		AmazonS3 s3 = getAmazonServiceClient();

		if (documentPath == null || StringUtils.isEmpty(documentPath)) {
			logger.info("Please specify document folder path");
			return null;
		}

		String separator = getS3SystemSeparator();
		String[] splittedParentFolder = StringUtils.split(documentPath, separator);
		String bucketName = splittedParentFolder[0];
		if (bucketName == null) {
			logger.info("No bucket name specified");
			return null;
		}
		String key = StringUtils.removeStartIgnoreCase(documentPath, bucketName + separator);
		S3Object object = s3.getObject(bucketName, key);
		if (object != null) {
			return object.getObjectContent();
		}
		return null;
	}

	@Override
	public boolean removeDocument(String documentPath) throws RuntimeException {
		// @TODO need to add the implementation
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hcentive.utils.dms.DMSService#getDocumentProperties(java.lang.String)
	 */
	@Override
	public Properties getDocumentProperties(String documentPath) throws RuntimeException {

		AmazonS3 s3 = getAmazonServiceClient();
		if (documentPath == null || StringUtils.isEmpty(documentPath)) {
			logger.info("Please specify document folder path");
			return null;
		}

		String separator = getS3SystemSeparator();
		String[] splittedParentFolder = StringUtils.split(documentPath, separator);
		String bucketName = splittedParentFolder[0];
		if (bucketName == null) {
			logger.info("No bucket name specified");
			return null;
		}
		String key = StringUtils.removeStartIgnoreCase(documentPath, bucketName + separator);
		S3Object object = s3.getObject(bucketName, key);
		if (object != null) {
			Properties properties = new Properties();
			ObjectMetadata metaData = object.getObjectMetadata();

			properties.setProperty(DMSConstants.CONTENT_ENCODING, metaData.getContentEncoding());
			properties.setProperty(DMSConstants.LAST_MODIFIED_TIME,
					DateFormat.getDateTimeInstance().format(metaData.getLastModified()));
			properties.setProperty(DMSConstants.VERSION_ID, metaData.getVersionId());
			properties.setProperty(DMSConstants.BUCKET_NAME, object.getBucketName());
			return properties;
		}
		return null;
	}
}
