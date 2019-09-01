package com.hcentive.utils.ext;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * ReadExcel class is responsible for Reading excel file and create HashMap of
 * the same. Each sheet in the excel file will represent one type of POJO. The
 * first row of the excel sheet will represent the attribute of the POJO and
 * further rows will represent the data. The Map will have key as the sheet name
 * and value as List of the POJOs of the data records on that particular sheet.
 * 
 * User will provide the File Name of the excel file and the SheetName and
 * corresponding qualified class Name as input data.
 */
public class ReadExcel {

	/**
	 * ReadExcel is responsible for Reading excel file and creating HashMap of
	 * the same. Each sheet in the excel file will represent one type of POJO.
	 * The first row of the excel sheet will represent the attribute of the POJO
	 * and further rows will represent the data. The Map will have key as the
	 * sheet name and value as List of the POJOs of the data records on that
	 * particular sheet.
	 * 
	 * User will provide the File Name of the excel file and the SheetName and
	 * corresponding qualified class Name as input data.
	 * 
	 * @param String
	 *            inputFileName - Name of the excel file.
	 * @param Map
	 *            <String, String> mappings - SheetName and corresponding
	 *            qualified class Name as input data
	 * 
	 * @return Map<String, List> -key as the sheet name and value as List of the
	 *         instances of POJOs of the data records on that particular sheet.
	 * 
	 * @throws IOException
	 */
	private static Logger logger = LoggerFactory.getLogger(ReadExcel.class);
	
	public static Map<String, List> populateDataFromExcel(Class parent, String inputFileName, Map<String, String> mappings)
			throws IOException {

		// File inputWorkbook = new File(inputFileName);

		/*
		 * if (!inputWorkbook.exists()) {
		 * System.out.println("File does not exist. Returning null data.");
		 * return null; }
		 */

		InputStream in = parent.getClassLoader().getResourceAsStream(inputFileName);

		if (in == null) {
			//System.out.println(inputFileName + " file does not exist. Returning null data.");
			logger.info(inputFileName + " file does not exist. Returning null data.");
			return null;
		}

		Map<String, List> testDataMasterMap = new HashMap<String, List>();
		try {
			Workbook w;
			w = Workbook.getWorkbook(in);
			Sheet[] sheetsArray = w.getSheets();

			for (int x = 0; x < sheetsArray.length; x++) {
				Sheet sheet = w.getSheet(x);
				String sheetName = sheet.getName();

				List sheetData = null;
				if (testDataMasterMap.get(sheetName) != null) {
					sheetData = testDataMasterMap.get(sheetName);
				} else {
					sheetData = new ArrayList();
				}

				for (int i = 1; i < sheet.getRows(); i++) {
					Object dataObject = null;
					String clazzNameFromMappings = null;
					try {
						clazzNameFromMappings = mappings.get(sheetName);
						if (clazzNameFromMappings == null) {
							//System.out.println("Problem creating object of type " + sheetName);
							//System.out.println("Please make sure sheet name mappings is properly defined.");
							logger.info("Problem creating object of type " + sheetName);
							logger.info("Please make sure sheet name mappings is properly defined.");
							continue;
						}
						dataObject = Class.forName(clazzNameFromMappings).newInstance();
					} catch (Exception e) {
						//System.out.println("Something is seriously wrong for sheet " + sheetName);
						logger.info("Something is seriously wrong for sheet " + sheetName);
						//e.printStackTrace();
						logger.error("EXCEPTION", e);
						//System.out.println("continue reading next sheet.");
						logger.info("continue reading next sheet.");
						continue;
					}
					Cell[] record = sheet.getRow(i);
					for (int j = 0; j < record.length; j++) {
						Cell cell = sheet.getCell(j, i);
						try {
							Method[] methodArray = dataObject.getClass().getMethods();

							for (int k = 0; k < methodArray.length; k++) {
								Method method = methodArray[k];
								String methodName = method.getName();

								if (!methodName.equalsIgnoreCase("set" + sheet.getCell(j, 0).getContents())) {
									continue;
								} else {
									// System.out.println(cell.getContents());
									Class[] zz1 = method.getParameterTypes();
									if (zz1 == null || zz1.length == 0) {
										continue;
									}

									Class zz = zz1[0];
									Object paramVal = null;

									if (zz.equals(String.class)) {
										paramVal = cell.getContents();
									} else if (zz.equals(Boolean.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Boolean.parseBoolean("" + HXUtility.getBooleanValue(cell.getContents()));
										}
									} else if (zz.equals(Integer.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Integer.parseInt(cell.getContents());
										}
									} else if (zz.equals(Long.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Long.parseLong(cell.getContents());
										}
									} else if (zz.equals(Float.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Float.parseFloat(cell.getContents());
										}
									} else if (zz.equals(Double.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Double.parseDouble(cell.getContents());
										}
									} else if (zz.equals(int.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Integer.parseInt(cell.getContents());
										}
									} else if (zz.equals(long.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Long.parseLong(cell.getContents());
										}
									} else if (zz.equals(boolean.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Boolean.parseBoolean("" + HXUtility.getBooleanValue(cell.getContents()));
										}
									} else if (zz.equals(float.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Float.parseFloat(cell.getContents());
										}
									} else if (zz.equals(double.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Double.parseDouble(cell.getContents());
										}
									} else if (zz.equals(Date.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											try {
												paramVal = new Date(Date.parse(cell.getContents()));
											} catch (IllegalArgumentException exception) {
												//System.out.println("Error parsing date for " + methodName);
												logger.info("Error parsing date for " + methodName);
												logger.error("EXCEPTION", exception);
											}

										}
									} else {
										// System.out.println("SKIP:" +
										// methodName);
										continue;
									}
									if (paramVal != null) {
										method.invoke(dataObject, paramVal);
									}
								}
							}
						} catch (Exception e) {
							//e.printStackTrace();
							logger.error("EXCEPTION", e);
						}
					}
					// System.out.println();
					// System.out.println();
					sheetData.add(dataObject);
				}
				testDataMasterMap.put(sheetName, sheetData);
			}
		} catch (BiffException e) {
			//e.printStackTrace();
			logger.error("EXCEPTION", e);
		} finally {
			in.close();
		}
		return testDataMasterMap;
	}

	public static Map<String, List> populateDataFromExcel(Class parent, InputStream in, Map<String, String> mappings)
			throws IOException {

		if (in == null) {
			logger.info(in + " InputStream. Returning null data.");
			return null;
		}

		Map<String, List> testDataMasterMap = new HashMap<String, List>();
		try {
			Workbook w;
			w = Workbook.getWorkbook(in);
			Sheet[] sheetsArray = w.getSheets();

			for (int x = 0; x < sheetsArray.length; x++) {
				Sheet sheet = w.getSheet(x);
				String sheetName = sheet.getName();

				List sheetData = null;
				if (testDataMasterMap.get(sheetName) != null) {
					sheetData = testDataMasterMap.get(sheetName);
				} else {
					sheetData = new ArrayList();
				}

				for (int i = 1; i < sheet.getRows(); i++) {
					Object dataObject = null;
					String clazzNameFromMappings = null;
					try {
						clazzNameFromMappings = mappings.get(sheetName);
						if (clazzNameFromMappings == null) {
							// System.out.println("Problem creating object of type "
							// + sheetName);
							// System.out.println("Please make sure sheet name mappings is properly defined.");
							logger.info("Problem creating object of type " + sheetName);
							logger.info("Please make sure sheet name mappings is properly defined.");
							continue;
						}
						dataObject = Class.forName(clazzNameFromMappings).newInstance();
					} catch (Exception e) {
						// System.out.println("Something is seriously wrong for sheet "
						// + sheetName);
						logger.info("Something is seriously wrong for sheet " + sheetName);
						// e.printStackTrace();
						logger.error("EXCEPTION", e);
						// System.out.println("continue reading next sheet.");
						logger.info("continue reading next sheet.");
						continue;
					}
					Cell[] record = sheet.getRow(i);
					for (int j = 0; j < record.length; j++) {
						Cell cell = sheet.getCell(j, i);
						try {
							Method[] methodArray = dataObject.getClass().getMethods();

							for (int k = 0; k < methodArray.length; k++) {
								Method method = methodArray[k];
								String methodName = method.getName();

								if (!methodName.equalsIgnoreCase("set" + sheet.getCell(j, 0).getContents())) {
									continue;
								} else {
									// System.out.println(cell.getContents());
									Class[] zz1 = method.getParameterTypes();
									if (zz1 == null || zz1.length == 0) {
										continue;
									}

									Class zz = zz1[0];
									Object paramVal = null;

									if (zz.equals(String.class)) {
										paramVal = cell.getContents();
									} else if (zz.equals(Boolean.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Boolean.parseBoolean("" + HXUtility.getBooleanValue(cell.getContents()));
										}
									} else if (zz.equals(Integer.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Integer.parseInt(cell.getContents());
										}
									} else if (zz.equals(Long.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Long.parseLong(cell.getContents());
										}
									} else if (zz.equals(Float.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Float.parseFloat(cell.getContents());
										}
									} else if (zz.equals(Double.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Double.parseDouble(cell.getContents());
										}
									} else if (zz.equals(int.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Integer.parseInt(cell.getContents());
										}
									} else if (zz.equals(long.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Long.parseLong(cell.getContents());
										}
									} else if (zz.equals(boolean.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Boolean.parseBoolean("" + HXUtility.getBooleanValue(cell.getContents()));
										}
									} else if (zz.equals(float.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Float.parseFloat(cell.getContents());
										}
									} else if (zz.equals(double.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											paramVal = Double.parseDouble(cell.getContents());
										}
									} else if (zz.equals(Date.class)) {
										if (cell.getContents() != null && !"".equals(cell.getContents().trim())) {
											try {
												paramVal = new Date(Date.parse(cell.getContents()));
											} catch (IllegalArgumentException exception) {
												// System.out.println("Error parsing date for "
												// + methodName);
												logger.info("Error parsing date for " + methodName);
												logger.error("EXCEPTION", exception);
											}

										}
									} else {
										// System.out.println("SKIP:" +
										// methodName);
										continue;
									}
									if (paramVal != null) {
										method.invoke(dataObject, paramVal);
									}
								}
							}
						} catch (Exception e) {
							// e.printStackTrace();
							logger.error("EXCEPTION", e);
						}
					}
					// System.out.println();
					// System.out.println();
					sheetData.add(dataObject);
				}
				testDataMasterMap.put(sheetName, sheetData);
			}
		} catch (BiffException e) {
			// e.printStackTrace();
			logger.error("EXCEPTION", e);
		} finally {
			in.close();
		}
		return testDataMasterMap;
	}

	public static void main(String[] args) throws IOException {
		ReadExcel excel = new ReadExcel();
		String inputFile = "Data_UnitTestPlan_HouseholdComposition.xls";
		Map<String, String> sheetClassMappings = new HashMap<String, String>();
		sheetClassMappings.put("EligibilityDTO", "com.hcentive.platform.domain.prescreening.EligibilityDTO");
		sheetClassMappings.put("Member", "com.hcentive.platform.domain.prescreening.Member");
		Map<String, List> outputData = excel.populateDataFromExcel(ReadExcel.class, inputFile, sheetClassMappings);
		// Map<String, List> outputData = populateDataFromExcel(inputFile,
		// sheetClassMappings);
		System.out.println(outputData);
	}
}