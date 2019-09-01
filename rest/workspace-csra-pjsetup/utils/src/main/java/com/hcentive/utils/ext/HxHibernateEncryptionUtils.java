/*******************************************************************************
 * --------------------------------------------
 *  Copyright (c) 2012 hCentive Inc. All Right Reserved.
 * --------------------------------------------
 ******************************************************************************/
/**
 * 
 */
package com.hcentive.utils.ext;

import org.jasypt.hibernate4.encryptor.HibernatePBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Dasappan Balakrishnan
 * 
 */
public class HxHibernateEncryptionUtils {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(HxHibernateEncryptionUtils.class);

	@Autowired
	HibernatePBEStringEncryptor hibernatePBEStringEncryptor;

	/**
	 * encryptString method encrypts the given string
	 * 
	 * @param text
	 * @return String -encrypted format
	 * @throws Exception
	 */
	public String encryptString(String text) throws Exception {
		String encrypted = null;

		encrypted = hibernatePBEStringEncryptor.encrypt(text);

		return encrypted;
	}

	/**
	 * decryptString method decrypts the given string
	 * 
	 * @param encrypted
	 * @return String - decrypted format
	 * @throws Exception
	 */

	public String decryptString(String encrypted) throws Exception {
		String decryptedtxt = null;

		decryptedtxt = hibernatePBEStringEncryptor.decrypt(encrypted);

		return decryptedtxt;

	}

}
