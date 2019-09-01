package com.hcentive.utils.ext;

/**
 * 
 * @author rhasija
 * 
 */
public abstract class MedicaidFFSPlanAttributes {

	/*
	 * public static final Long MEDICAID_FFS_GAPPERIOD_PLAN_ID = -10L; public
	 * static final Long MEDICAID_FFS_GAPPERIOD_ISSUER_ID = -11L; public static
	 * final String MEDICAID_FFS_GAPPERIOD_PLAN_HIOS_ID = "MAFFSGAPHIOSID";
	 * public static final String MEDICAID_FFS_GAPPERIOD_PLAN_PLAN_CODE =
	 * "MAFFSGAPPLANCD";
	 */

	public static final Long MEDICAID_FFS_ANNUAL_PLAN_ID = -20L;
	public static final Long MEDICAID_FFS_ANNUAL_ISSUER_ID = -21L;
	public static final String MEDICAID_FFS_ANNUAL_PLAN_HIOS_ID = "MAFFSANNHIOSID";
	public static final String MEDICAID_FFS_ANNUAL_PLAN_PLAN_CODE = "MAFFSANNPLANCD";

	public static final String MEDICAID_FFS_DEFAULT_COVERAGE_CODE = "01";
	public static final String MEDICAID_MMC_DEFAULT_COVERAGE_CODE = "30";

	public static final String[] MEDICAID_THIRD_PARTY_REE_CODES = {"90"};
	
	public static final String[] MEDICAID_MMC_EXEMPTION_PLAN_SEL_REE_CODES = {"90"};
	
	public static final String MEDICAID_RETRO_MEDICAID_ENROLLMENT_REASON = "RETRO_COVERAGE_PROVIDED";
	
	public static final String MEDICAID_FFS_ANNUAL_PLAN_NAME = "Medicaid-FFS";
	public static final String MEDICAID_FFS_ANNUAL_PLAN_CATEGORY = "MEDICAL";
	
}
