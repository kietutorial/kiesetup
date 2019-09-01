/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.hcentive.utils.ext.HXUtility;

public class UtilityFunctions {

	private static Logger logger = LoggerFactory.getLogger(UtilityFunctions.class);

	public static String readFileAsString(String filePath) throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}

	public static void writeToFile(String dataXML2, String fileName) throws IOException {
		File outFile = new File(fileName);
		FileWriter out = new FileWriter(outFile);
		// out.write
		out.write(dataXML2);
		out.close();
	}

	public static void writeToFile(byte[] dataXML, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(fileName));
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write(dataXML);
		bos.close();
	}

	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		// Get the size of the file
		long length = file.length();

		// You cannot create an array using a long type.
		// It needs to be an int type.
		// Before converting to an int type, check
		// to ensure that file is not larger than Integer.MAX_VALUE.
		if (length > Integer.MAX_VALUE) {
			// File is too large
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}

		// Close the input stream and return bytes
		is.close();
		return bytes;
	}

	public static String getStringFromInputStream(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

	public static boolean isFutureDate(Date date) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		Calendar cal2 = Calendar.getInstance();
		if (cal1.after(cal2)) {
			return true;
		}
		return false;
	}

	public static boolean isCurrentDate(Date date) {
		String date1 = ConversionUtils.convertToString(date);
		String date2 = ConversionUtils.convertToString(new Date());
		if (date1.equals(date2)) {
			return true;
		}
		return false;
	}

	public static boolean isPastDate(Date date) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		Calendar cal2 = Calendar.getInstance();
		if (cal1.before(cal2)) {
			return true;
		}
		return false;
	}

	public static boolean isValisFileURL(String path) {
		return new File(path).exists();
	}

	public static long calculateDays(Date dateEarly, Date dateLater) {
		return (long) Math.ceil((double) (dateLater.getTime() - dateEarly.getTime()) / (24 * 60 * 60 * 1000));
	}

	public static long calculateAddedDays(long dateEarly, long dateLater) {
		return (dateLater + dateEarly) / (24 * 60 * 60 * 1000);
	}

	public static Date convertStringToDate(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date convertedDate = null;
		try {
			convertedDate = dateFormat.parse(dateString);
		} catch (ParseException e) {
			logger.error("Error occured while parsing date: ", e);
		}
		return convertedDate;
	}

	public static String join(Collection<?> list, String delimiter) {
		StringBuilder str = new StringBuilder();
		for (Object obj : list) {
			str.append(obj).append(delimiter);
		}
		str.setLength(str.length() - delimiter.length());
		return str.toString();
	}

	public static int[] convert(String[] arr) throws NumberFormatException {
		if (arr == null) {
			return null;
		}
		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = Integer.parseInt(arr[i]);
		}
		return intArr;
	}

	public static Integer getYearFromDate(Date date) {
		return extractFromDate(date, Calendar.YEAR);
	}

	public static Integer getMonthFromDate(Date date) {
		return extractFromDate(date, Calendar.MONTH) + 1;
	}

	public static Integer getDayFromDate(Date date) {
		return extractFromDate(date, Calendar.DAY_OF_MONTH);
	}

	public static Integer extractFromDate(Date date, int field) {
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal.get(field);
		}
		return null;
	}

	public static void cropImage(String sourceFilePath, String targetFilePath, int targetWidth, int targetHeight) {
		try {
			File originalImage = new File(sourceFilePath);
			byte[] imageArray = getByteArray(originalImage);
			InputStream imageStream = new BufferedInputStream(new ByteArrayInputStream(imageArray));
			Image image = ImageIO.read(imageStream);
			BufferedImage thumbImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics2D = thumbImage.createGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			graphics2D.setPaint(Color.WHITE);
			graphics2D.fill(new Rectangle2D.Double(0, 0, targetWidth, targetHeight));
			graphics2D.fillRect(0, 0, targetWidth, targetHeight);
			graphics2D.drawImage(image, 0, 0, targetWidth, targetHeight, null);
			graphics2D.dispose();
			graphics2D.setComposite(AlphaComposite.Src);
			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			File tempFile = new File(targetFilePath);
			ImageIO.write(thumbImage, "jpg", tempFile);
		} catch (IOException ioe) {
			logger.error("Error occured while croping the image logo: ", ioe);
		}
	}

	private static byte[] getByteArray(File file) throws IOException {
		byte[] dataArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(dataArray);
		fis.close();
		return dataArray;
	}

	public static Boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	public static Date getCurrentDateWithoutTimestamp() {
		Calendar c = GregorianCalendar.getInstance();
		c.clear(Calendar.HOUR);
		c.clear(Calendar.HOUR_OF_DAY);
		c.clear(Calendar.MINUTE);
		c.clear(Calendar.SECOND);
		c.clear(Calendar.MILLISECOND);
		c.clear(Calendar.AM_PM);
		return c.getTime();
	}

	/**
	 * A utility method that converts a comma delimited string to List of
	 * strings.
	 */
	public static List<String> convertCommaDelimitedStringToList(String value) {
		if (StringUtils.hasText(value)) {
			String[] commaDelimitedArray = StringUtils.commaDelimitedListToStringArray(value);
			return Arrays.asList(commaDelimitedArray);
		} else {
			return Collections.EMPTY_LIST;
		}

	}

	public static int getSmallerNumber(int num1, int num2) {
		if (num1 < num2)
			return num1;
		return num2;
	}
	
	public static String convertToUpperCase(String str) {
		if (!HXUtility.isEmpty(str)) {
			return str.toUpperCase();
		}
		return null;
	}
	
	public static <T> Iterable<T> emptyIfNull(Iterable<T> iterable){
		return iterable == null ? Collections.<T>emptyList() : iterable;
	}
}
