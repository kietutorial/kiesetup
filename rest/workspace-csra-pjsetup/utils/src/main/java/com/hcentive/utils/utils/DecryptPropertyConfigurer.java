package com.hcentive.utils.utils;

import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.ObjectUtils;

import com.hcentive.utils.ext.HXUtility;


public class DecryptPropertyConfigurer  extends PropertyPlaceholderConfigurer implements InitializingBean {
	  	   
   Logger logger = LoggerFactory.getLogger(DecryptPropertyConfigurer.class);
   
   String encodeDecodeKey;
   
   	
   @Override
   protected void convertProperties(Properties props)
   {

	   Enumeration<?> propertyNames = props.propertyNames();
	   String encodeDecodeType = null;
	   try {
		   while (propertyNames.hasMoreElements()) {
			    String propertyName = (String) propertyNames.nextElement();
			    String propertyValue = props.getProperty(propertyName);
				
					if(HXUtility.isEmpty(propertyValue)){
						continue;
					}				
					encodeDecodeType= encodeDecodeType != null?encodeDecodeType :getEncodeType(propertyValue);				
					if(HXUtility.isEmpty( encodeDecodeType)){
						logger.debug("Property Decryption Type is missing.");
						continue;
					}				
					propertyValue = propertyValue.substring((propertyValue.indexOf("|")+1));
					//logger.error("propertyValue ="+propertyValue+"=====encodeDecodeKey="+encodeDecodeKey);
					//String encryptProperty = CryptographyEnum.BASE64.encrypt(propertyValue,encodeDecodeKey);
					String convertedValue = CryptographyEnum.getCryptoType(encodeDecodeType.toUpperCase()).decrypt(propertyValue,encodeDecodeKey);	
					//logger.error("convertedValue ="+convertedValue+"=====encodeDecodeKey="+encodeDecodeKey);
				    //if (!ObjectUtils.nullSafeEquals(propertyValue, convertedValue)) {
				     props.setProperty(propertyName, convertedValue);
				    //}				    
				    
	   		}    
		} catch (Exception cryptoExp) {			
			try {
				logger.debug("Property Decryption Failed :"+cryptoExp.getMessage());
				throw cryptoExp ;
			} catch (Exception e) {}				
		}
	  
   }

	public String getEncodeDecodeKey() {
		return encodeDecodeKey;
	}
	
	public void setEncodeDecodeKey(String encodeDecodeKey) {
		this.encodeDecodeKey = encodeDecodeKey;
	}
	
	private String getEncodeType(String propertyValue){
		String[] encodeTypes = propertyValue.split("\\|");
		return encodeTypes.length > 1 ? encodeTypes[0]:null;		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

   
}
