package com.hcentive.rulesengine.service;

import java.util.Date;
import com.hcentive.rulesengine.domain.ConfigCategoryEnum;
import com.hcentive.rulesengine.domain.ConfigGroupBean;
import com.hcentive.utils.exception.HCException;
import com.hcentive.rulesengine.domain.RuleKey;


public interface RuleConfigService {	

	ConfigGroupBean getRuleConfigBean(Date runDate, ConfigCategoryEnum configCategory) throws HCException;
	/**
	* CR1140 Find EPP Coverage Start Date</h1>
	* This method is added to find the  Rule Config based on the key Value
	* @author  Sandeep Bhandari
	* @version 1.0
	* @since   2015-06-09
	*/
	String getRuleConfigValueForKey(RuleKey Key) throws HCException;
	
}
