/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.exception;

/*******************************************************************************
 * --------------------------------------------
 *  Copyright (c) 2012 hCentive Inc. All Right Reserved.
 * --------------------------------------------
 ******************************************************************************/
///**
// * 
// */
//package com.hcentive.utils.exception;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Locale;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.orm.ibatis.SqlMapClientTemplate;
//
///**
// * @author ashishjaiswal
// *
// */
//public class ServiceFailureExceptionHandler implements ExceptionHandler {
//
//	private static Logger logger = LoggerFactory.getLogger(ServiceFailureExceptionHandler.class);
//	
//	private SqlMapClientTemplate sqlMapClientTemplate;
//	
//	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
//		this.sqlMapClientTemplate = sqlMapClientTemplate;
//	}
//
//	/* (non-Javadoc)
//	 * @see com.hcentive.utils.exception.ExceptionHandler#handleException(java.lang.Exception, com.hcentive.utils.exception.ExceptionHandler.Level, java.util.Locale)
//	 */
//	@Override
//	public String handleException(Exception ex, Level level, Locale locale) {
//		if(! (ex instanceof ServiceFailureException)) {
//			logger.error("UNKNOWN | " + ex.getMessage() + "| | ");
//			return null;
//		}
//		
//		ServiceFailureException sfe = (ServiceFailureException)ex;
//
//		try {
//			logServiceFailureException(sfe.getName(), sfe.getRequestTime(), sfe.getShortMessage(), sfe.getCustomMessage());
//		} catch (Exception e) {
//			logger.error(sfe.getName() + "|" + sfe.getRequestTime() +  "|" +sfe.getShortMessage() +  "|" +sfe.getCustomMessage());
//		}
//
//		return null;
//	}
//
//	private void logServiceFailureException(String name, Date requestTime,
//			String shortMessage, String customMessage) {
//		Map<String, Object> paramsMap = new HashMap<String, Object>();
//		paramsMap.put("name", name);
//		paramsMap.put("timestamp", requestTime);
//		paramsMap.put("shortMessage", shortMessage);
//		paramsMap.put("customMessage", customMessage);
//		sqlMapClientTemplate.insert("app.insertServiceStatus", paramsMap);		
//	}
//
// }
