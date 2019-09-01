/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * @author ashishjaiswal
 * 
 */
public class EncryptionUtils {

	private static Logger logger = LoggerFactory.getLogger(EncryptionUtils.class);

	private static String key = "er48nsjhwlG593mjhgdb20ih";

	public EncryptionUtils() {

	}

	public EncryptionUtils(String key) {
		Assert.notNull(key, "Key for encryption cannot be null");
		this.key = key;
	}

	/**
	 * encrypt
	 */
	public static String encrypt(String text) throws Exception {
		byte[] seed_key = new String(key).getBytes();
		SecretKeySpec keySpec = new SecretKeySpec(seed_key, "TripleDES");
		Cipher nCipher = Cipher.getInstance("TripleDES");
		nCipher.init(Cipher.ENCRYPT_MODE, keySpec);
		byte[] cipherbyte = nCipher.doFinal(text.getBytes());

		return new String(Base64.encodeBase64URLSafeString(cipherbyte));
	}

	/**
	 * decrypt
	 */
	public static String decrypt(String encrypted) throws Exception {
		byte[] seed_key = new String(key).getBytes();
		SecretKeySpec keySpec = new SecretKeySpec(seed_key, "TripleDES");
		Cipher nCipher = Cipher.getInstance("TripleDES");
		nCipher.init(Cipher.DECRYPT_MODE, keySpec);
		byte[] encData = Base64.decodeBase64(encrypted.getBytes());
		byte[] decryptedtxt = nCipher.doFinal(encData);

		return new String(decryptedtxt);
	}

	public static void main(String[] args) throws Exception {
		EncryptionUtils encUtils = new EncryptionUtils("er48nsjhwlG593mjhgdb20ih");
		String encrytText = encUtils.encrypt("token=QX4mV5MVfTY=;a=dsdadasd");
		logger.info("encrypted Text " + encrytText);
		String decryptText = encUtils.decrypt(encrytText);
		logger.info("decrypted Text " + decryptText);
	}
}
