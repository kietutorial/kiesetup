/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author ashish.jaiswal
 */
public class CSVUtils {

	public static List<Map<String, String>> parseCSV(Reader reader, String[] columnHeaders, char columnSeparator)
			throws IOException {
		List<Map<String, String>> rowMap = new ArrayList<Map<String, String>>();

		CSVReader csvReader = new CSVReader(reader, columnSeparator);
		List<String[]> myEntries = csvReader.readAll();

		for (Iterator<String[]> iterator = myEntries.iterator(); iterator.hasNext();) {
			Map<String, String> colMap = new HashMap<String, String>();
			String[] cols = iterator.next();
			for (int i = 0; i < cols.length; i++) {
				colMap.put(columnHeaders[i], cols[i]);
			}
			rowMap.add(colMap);
		}
		return rowMap;
	}
}
