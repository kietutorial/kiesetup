package com.hcentive.cs.override;


public final class BackOfficeOverrideEnums {

	public enum OverrideStatusEnum {
		ACTIVE("1"), OBSOLETE("0"),ALL("2");

		private String overrideStatusEnum;

		private OverrideStatusEnum(String s) {
			overrideStatusEnum = s;
		}

		public String getOverrideStatusEnum() {
			return overrideStatusEnum;
		}
	
	 
	}
	
	
	
	public enum OverrideValueEnum {
		ALIVE("ALIVE"), NOTALIVE("NOTALIVE"), IGNORE("IGNORE"),NOTAVAILABLE("NOTAVAILABLE") ,VALID("VALID"),INVALID("INVALID"),USER_CONSENT_ALIVE("USER_CONSENT_ALIVE"), USER_CONSENT_NOTALIVE("USER_CONSENT_NOTALIVE"),;
		

		private String overrideValueEnum;

		private OverrideValueEnum(String s) {
			overrideValueEnum = s;
		}

		public String getOverrideValueEnum() {
			return overrideValueEnum;
		}

		public static Boolean isAliveStatus(String overrideStatus){
			if(ALIVE.getOverrideValueEnum().equalsIgnoreCase(overrideStatus)
					|| USER_CONSENT_ALIVE.getOverrideValueEnum().equalsIgnoreCase(overrideStatus)){
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
		
		public static Boolean isNotAliveStatus(String overrideStatus){
			if(NOTALIVE.getOverrideValueEnum().equalsIgnoreCase(overrideStatus)
					|| USER_CONSENT_NOTALIVE.getOverrideValueEnum().equalsIgnoreCase(overrideStatus)){
				return Boolean.TRUE;
			}
			return Boolean.FALSE;			
		}
		
		public static OverrideValueEnum fromValue(String value){
			for(OverrideValueEnum overrideType : OverrideValueEnum.values()){
				if(overrideType.name().equalsIgnoreCase(value)){
					return overrideType;
				}
			}
			return null;
		}
	}
	
	public enum SsaResponseEnum {
		ALIVE("A"), NOTALIVE("N"),NOTAVAILABLE("NA"),NULL("NULL");

		private String value;

		private SsaResponseEnum(String s) {
			value = s;
		}

		public String getSsaResponseEnum() {
			return value;
		}
	 
	}
	
	
	public enum OverrideTypeEnum {

		EMAILOVERRIDE("EMAILOVERRIDE"), MAILINGADDR("MAILINGADDR"), PERSONLIVINGIND("PERSONLIVINGIND"), ACCOUNT_STATUS_OVERRIDE("ACCOUNT_STATUS_OVERRIDE"),BO_RETRO_MMC_OVERRIDE("BO_RETRO_MMC_OVERRIDE"),BO_RETRO_FFS_OVERRIDE("BO_RETRO_FFS_OVERRIDE"), VLPOVERRIDE("VLPOVERRIDE"),ELIGIBILITY_OVERRIDDEN("ELIGIBILITY_OVERRIDDEN"),
		CITIZENVERIFYOVERRIDE("CITIZENVERIFYOVERRIDE"),CBIC_REPLACEMENT_REQUEST("CBIC_REPLACEMENT_REQUEST");

		private String val;

		private OverrideTypeEnum(String value){
			val = value;
		}

		/**
		 * @param value String
		 * @return OverrideTypeEnum
		 */
		public static OverrideTypeEnum getEnum(String value){
			for(OverrideTypeEnum overrideType : OverrideTypeEnum.values()){
				if(overrideType.name().equalsIgnoreCase(value)){
					return overrideType;
				}
			}
			return null;
		}

		public static OverrideTypeEnum getEnumbyValue(String value){
			for(OverrideTypeEnum overrideType : OverrideTypeEnum.values()){
				if(overrideType.getVal().equalsIgnoreCase(value)){
					return overrideType;
				}
			}
			return null;
		}

		public String getVal() {
			return val;
		}

		public void setVal(String val) {
			this.val = val;
		}

	}

}