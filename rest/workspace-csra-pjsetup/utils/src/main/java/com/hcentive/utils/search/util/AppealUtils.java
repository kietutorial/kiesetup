package com.hcentive.utils.search.util;

import java.util.HashMap;
import java.util.Map;

public class AppealUtils {

	private static final Map<String, String> shopCompanyType = new HashMap<String, String>();
    static {
        shopCompanyType.put("C Corporation","0");
        shopCompanyType.put("S Corporation","1");
        shopCompanyType.put("LLC","2");
        shopCompanyType.put("Sole Proprietorship or Partnership","3");
    }
    
    private static final Map<String, String> phoneType = new HashMap<String, String>();
    static {
    	phoneType.put("HOME","0");
    	phoneType.put("WORK","1");
    	phoneType.put("CELL","2");
    	phoneType.put("FAX","3");
    	phoneType.put("OTHER","4");
    }
    
    private static final Map<String, String> appealFormat = new HashMap<String, String>();
    static {
    	appealFormat.put("DR","0");
    	appealFormat.put("PH","1");
    }
    
    public static String getBusinessType(String description){
    	return shopCompanyType.get(description);
    }
   
    public static String getPhoneType(String description){
    	return phoneType.get(description);
    }

	public static String getAppealformat(String description) {
		return appealFormat.get(description);
	}
    
    
}
