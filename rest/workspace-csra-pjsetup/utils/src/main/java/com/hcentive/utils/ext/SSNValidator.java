package com.hcentive.utils.ext;

import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * This class demonstrates on how to validate a SSN (Social Security Number) in
 * Java
 * 
 * @author Gopinath Kuppuswamy Creation Date Aug 30, 2012
 */

public class SSNValidator {

	/** * Needed to create XMLGregorianCalendar instances */
	private static DatatypeFactory df = null;
	static {
		try {
			df = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException dce) {
			throw new IllegalStateException("Exception while obtaining DatatypeFactory instance", dce);
		}
	}

	/**
	 * isSSNValid: Validate Social Security number (SSN) using Java reg ex. This
	 * method checks if the input string is a valid SSN.
	 * 
	 * @param ssn
	 *            String. Social Security number to validate
	 * @return boolean: true if social security number is valid, false
	 *         otherwise.
	 */
	public static boolean isSsnValid(String ssn) {
		boolean isValid = true;
		String ssnStripOutdashes = "";
		int ssnGrpCode = 0;
		int ssnAreaCode = 0;
		// Initialize reg ex for SSN. </CODECOMMENTS>
		String expression = "^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$";
		CharSequence inputStr = ssn;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher;// = pattern.matcher(inputStr);
		if (ssn == null || "".equalsIgnoreCase(ssn)) {
			isValid = false;
		} else {
			matcher = pattern.matcher(inputStr);
			if (!matcher.matches()) {
				isValid = false;
			} else {

				String ssnTokens[] = ssn.split("-");
				if (ssnTokens.length == 3) {
					ssnStripOutdashes = ssnTokens[0] + ssnTokens[1] + ssnTokens[2];

					// ssn# Should be 9 digits long.
					if (ssnStripOutdashes.length() > 9) {
						isValid = false;
					}
				}

				if (isValid) {
					// Not allowed are SSNs from 987-65-4320 to 987-65-4329.
					for (int i = 0; i < ssnTokens.length; i++) {
						if (ssnTokens.length == 3) {
							// Not allowed are SSNs with Area Numbers (First 3
							// digits)
							// 000 and 666.
							if (ssnTokens[0].equals("000") || ssnTokens[0].equals("666")) {
								isValid = false;
							} else {

								// Not allowed are SSNs with Area Numbers (First
								// 3 digits)
								// 800-899 and 900-999.
								ssnAreaCode = Integer.parseInt(ssnTokens[0]);
								//commented as per latest SSN Rules in EE92 Household Demographics (build 5) FDD
								//if (ssnAreaCode >= 800 && ssnAreaCode <= 999) {
								if (ssnAreaCode >= 900 && ssnAreaCode <= 999) {
									isValid = false;
								} else {
									// Validating "00" in the group code
									if (ssnTokens[1] != null && ssnTokens[1].equals("00")) {
										isValid = false;
									} else {
										// Leading numbers 73 thru 79
										//commented as per latest SSN Rules in EE92 Household Demographics (build 5) FDD										
/*										ssnGrpCode = Integer.parseInt(ssnTokens[1]);
										if (ssnGrpCode >= 73 && ssnGrpCode <= 79) {
											isValid = false;
										} else {
*/
											// Ending in 4 zeroes
											if (ssnTokens[2] != null && ssnTokens[2].equals("0000")) {
												isValid = false;
											}
/*										}*/
									}
								}
							}
						}
					}
				}
				// This is for ssn number without "-"
				if (ssnTokens.length == 1) {
					int ssnGrpCodeOne = 0;
					int ssnAreaCodeOne = 0;
					String ssnStripOutdashesOne = "";
					ssnStripOutdashesOne = ssn.substring(0, 3) + ssn.substring(3, 5) + ssn.substring(5, 9);
					// System.out.println("ssnStripOutdashesOne-----> "+ssnStripOutdashesOne.length());

					// ssn# Should be 9 digits long.
					if (ssnStripOutdashesOne.length() > 9) {
						isValid = false;
					} else {

						// Not allowed are SSNs with Area Numbers (First 3
						// digits) 000
						// and 666.
						if (ssn.substring(0, 3) != null && ssn.substring(0, 3).equals("000") || ssn.substring(0, 3).equals("666")) {
							isValid = false;
						} else {

							// Not allowed are SSNs with Area Numbers (First 3
							// digits)
							// 900-999.
							ssnAreaCodeOne = Integer.parseInt(ssn.substring(0, 3));
							//commented as per latest SSN Rules in EE92 Household Demographics (build 5) FDD
							//if (ssnAreaCodeOne >= 800 && ssnAreaCodeOne <= 999) {
							if (ssnAreaCodeOne >= 900 && ssnAreaCodeOne <= 999) {
								isValid = false;
							} else {
								// Validating "00" in the group code
								if (ssn.substring(3, 5) != null && ssn.substring(3, 5).equals("00")) {
									isValid = false;
								} else {
									// Leading numbers 73 thru 79
									//commented as per latest SSN Rules in EE92 Household Demographics (build 5) FDD									
/*									ssnGrpCodeOne = Integer.parseInt(ssn.substring(3, 5));
									if (ssnGrpCodeOne >= 73 && ssnGrpCodeOne <= 79) {
										isValid = false;
									} else {
*/										// Ending in 4 zeroes
										if (ssn.substring(5, 9) != null && ssn.substring(5, 9).equals("0000")) {
											isValid = false;
										}
/*									}*/
								}
							}
						}
					}
				} //
			}
		}
		return isValid;
	}
	
	/**
	 * isEmployeeSsnValid: Validate Employee's Social Security number (SSN) using Java reg ex. This
	 * method checks if the input string is a valid SSN and also allows valid ITIN's.
	 * 
	 * @param ssn
	 *            String. Social Security number to validate
	 * @return boolean: true if social security number and ITIN  is valid, false
	 *         otherwise.
	 */
	public static boolean isEmployeeSsnValid(String ssn) {
		boolean isValid = true;
		String ssnStripOutdashes = "";
		int ssnGrpCode = 0;
		int ssnAreaCode = 0;
		// Initialize reg ex for SSN. </CODECOMMENTS>
		String expression = "^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$";
		CharSequence inputStr = ssn;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher;// = pattern.matcher(inputStr);
		if (ssn == null || "".equalsIgnoreCase(ssn)) {
			isValid = false;
		} else {
			matcher = pattern.matcher(inputStr);
			if (!matcher.matches()) {
				isValid = false;
			} else {

				String ssnTokens[] = ssn.split("-");
				if (ssnTokens.length == 3) {
					ssnStripOutdashes = ssnTokens[0] + ssnTokens[1] + ssnTokens[2];

					// ssn# Should be 9 digits long.
					if (ssnStripOutdashes.length() > 9) {
						isValid = false;
					}
				}

				if (isValid) {
					// Not allowed are SSNs from 987-65-4320 to 987-65-4329.
					for (int i = 0; i < ssnTokens.length; i++) {
						if (ssnTokens.length == 3) {
							// Not allowed are SSNs with Area Numbers (First 3
							// digits)
							// 000 and 666.
							if (ssnTokens[0].equals("000") || ssnTokens[0].equals("666")) {
								isValid = false;
							} else {

								// Not allowed are SSNs with Area Numbers (First
								// 3 digits)
								// 800-899 and 900-999.
								ssnAreaCode = Integer.parseInt(ssnTokens[0]);
								//commented as per latest SSN Rules in EE92 Household Demographics (build 5) FDD
								//if (ssnAreaCode >= 800 && ssnAreaCode <= 999) {
								/*if (ssnAreaCode >= 900 && ssnAreaCode <= 999) {
									isValid = false;
								} {*/
									// Validating "00" in the group code
									if (ssnTokens[1] != null && ssnTokens[1].equals("00")) {
										isValid = false;
									} else {
										// Leading numbers 73 thru 79
										//commented as per latest SSN Rules in EE92 Household Demographics (build 5) FDD										
/*										ssnGrpCode = Integer.parseInt(ssnTokens[1]);
										if (ssnGrpCode >= 73 && ssnGrpCode <= 79) {
											isValid = false;
										} else {
*/
											// Ending in 4 zeroes
											if (ssnTokens[2] != null && ssnTokens[2].equals("0000")) {
												isValid = false;
											}
/*										}*/
									}
								//}
							}
						}
					}
				}
				// This is for ssn number without "-"
				if (ssnTokens.length == 1) {
					int ssnGrpCodeOne = 0;
					int ssnAreaCodeOne = 0;
					String ssnStripOutdashesOne = "";
					ssnStripOutdashesOne = ssn.substring(0, 3) + ssn.substring(3, 5) + ssn.substring(5, 9);
					// System.out.println("ssnStripOutdashesOne-----> "+ssnStripOutdashesOne.length());

					// ssn# Should be 9 digits long.
					if (ssnStripOutdashesOne.length() > 9) {
						isValid = false;
					} else {

						// Not allowed are SSNs with Area Numbers (First 3
						// digits) 000
						// and 666.
						if (ssn.substring(0, 3) != null && ssn.substring(0, 3).equals("000") || ssn.substring(0, 3).equals("666")) {
							isValid = false;
						} else {

							// Not allowed are SSNs with Area Numbers (First 3
							// digits)
							// 900-999.
							ssnAreaCodeOne = Integer.parseInt(ssn.substring(0, 3));
							//commented as per latest SSN Rules in EE92 Household Demographics (build 5) FDD
							//if (ssnAreaCodeOne >= 800 && ssnAreaCodeOne <= 999) {
							/*if (ssnAreaCodeOne >= 900 && ssnAreaCodeOne <= 999) {
								isValid = false;
							} else  {*/
								// Validating "00" in the group code
								if (ssn.substring(3, 5) != null && ssn.substring(3, 5).equals("00")) {
									isValid = false;
								} else {
									// Leading numbers 73 thru 79
									//commented as per latest SSN Rules in EE92 Household Demographics (build 5) FDD									
/*									ssnGrpCodeOne = Integer.parseInt(ssn.substring(3, 5));
									if (ssnGrpCodeOne >= 73 && ssnGrpCodeOne <= 79) {
										isValid = false;
									} else {
*/										// Ending in 4 zeroes
										if (ssn.substring(5, 9) != null && ssn.substring(5, 9).equals("0000")) {
											isValid = false;
										}
/*									}*/
								}
							//}
						}
					}
				} //
			}
		}
		return isValid;
	}
	

	public static String formatSSN(String ssn) {
		String ssnTokens[] = ssn.split("-");
		String ssnStripOutdashes = "";
		if (ssnTokens.length == 3) {
			ssnStripOutdashes = ssnTokens[0] + ssnTokens[1] + ssnTokens[2];

		}
		return ssnStripOutdashes;
	}

	public static XMLGregorianCalendar asXMLGregorianCalendar(java.util.Date date) {
		if (date == null) {
			return null;
		} else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			return df.newXMLGregorianCalendar(gc);
		}
	}

}
