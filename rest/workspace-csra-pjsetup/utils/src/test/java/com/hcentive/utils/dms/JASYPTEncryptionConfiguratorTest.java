/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.dms;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.jasypt.digest.PooledStringDigester;
import org.jasypt.digest.StandardByteDigester;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.util.digest.Digester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/encryption-test.xml" })
public class JASYPTEncryptionConfiguratorTest {

	private static Logger logger = LoggerFactory.getLogger(JASYPTEncryptionConfiguratorTest.class);

	@Autowired
	private PooledPBEStringEncryptor stringEncryptor;
	@Autowired
	private PooledStringDigester stringDigestor;
	@Autowired
	private StandardByteDigester byteDigestor;
	@Autowired
	private Digester digestor;

	@Test
	public void testStringEncryptor() {
		logger.info("Encrypted string:" + stringEncryptor.encrypt("testing"));

	}

	@Test
	public void testHibernateJASYPTEncryptor() {
		logger.info("Hello world");
	}

	@Test
	public void testPasswordEncoder() throws UnsupportedEncodingException {
		String password = "Qwerty1234";

		// String encodedPasswdByJASYPT =
		// Hex.encodeHexString(StringUtils.getBytesUtf8(jasyptPasswordEncoder.encodePassword(
		// password, null)));

		String encodedPassUsingStringDigestor = stringDigestor.digest(password);

		byte[] digestedBytes = byteDigestor.digest(password.getBytes("UTF-8"));
		logger.info("final testing:" + Hex.encodeHexString(digestedBytes));
		String encodedPasswdByDigestUtil = DigestUtils.md5Hex(password);

		logger.info("Encoding passwords : " + encodedPassUsingStringDigestor + "::" + encodedPasswdByDigestUtil);

		// StandardStringDigester testStringDigestor = new
		// StandardStringDigester();
		// String digestedString = testStringDigestor.digest(password);

		logger.info("String digested values:" + Arrays.toString(encodedPassUsingStringDigestor.getBytes("UTF-8")));

		byte[] digested = digestor.digest(password.getBytes());
		logger.info("digested using digestor:" + Arrays.toString(digested));
		logger.info("digested using DigestUtils:" + Arrays.toString(DigestUtils.md5(password)));

		System.out.println("Decode pass:" + stringDigestor.matches(password, DigestUtils.md5Hex(password)));
		logger.info("Decode pass using digester:" + stringDigestor.matches(password, stringDigestor.digest(password)));

		logger.info("Cheching pass is valid:" + stringDigestor.matches(password, "ce5401cd23a7d7213178d12017943e80"));
	}

	@Test
	public void testDigestor() throws UnsupportedEncodingException {
		String password = "Rahul135@";

		logger.info("Digested msg is:" + Hex.encodeHexString(digestor.digest(password.getBytes("UTF-8"))));

		logger.info("");
	}
}
