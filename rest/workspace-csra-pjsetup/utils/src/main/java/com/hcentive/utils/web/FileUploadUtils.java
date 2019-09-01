/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.utils.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * The Class FileUploadUtils.
 */
public class FileUploadUtils {

	public static void copyFile(InputStream source, String location, String fileName) throws Exception {
		File docLocationDir = new File(location);
		if (!docLocationDir.exists()) {
			docLocationDir.mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(location + "/" + fileName);
		try {
			byte[] buf = new byte[1024];
			int i = 0;
			while ((i = source.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} finally {
			fos.flush();
			fos.close();
		}
	}

	/**
	 * Copy file.
	 * 
	 * @param source
	 *            the source
	 * @param location
	 *            the location
	 * @param fileName
	 *            the file name
	 * @throws Exception
	 *             the exception
	 */
	public static void copyFile(String source, String location, String fileName) throws Exception {
		File docLocationDir = new File(location);
		if (!docLocationDir.exists()) {
			docLocationDir.mkdirs();
		}
		File file = new File(source);

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(location + "/" + fileName);

			byte[] buf = new byte[(int) file.length()];
			int i = 0;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.flush();
				fos.close();
			}
		}
	}
}
