package com.hcentive.rulesengine.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcentive.rulesengine.domain.ConfigCategoryEnum;
import com.hcentive.rulesengine.domain.ConfigGroupBean;
import com.hcentive.rulesengine.domain.RuleKey;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.ext.HXUtility;
import com.hcentive.utils.ext.HxDateUtils;
import com.hcentive.utils.orm.dao.GenericDAO;

public class RuleConfigServiceImpl implements RuleConfigService {

	private static Logger logger = LoggerFactory.getLogger(RuleConfigServiceImpl.class);
	
	@Autowired
	private ConfigDataLoader configDataLoader;
	
	@Autowired
	private GenericDAO genericDAO;
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	private static Map<String, List<ConfigGroupBean>> allconfigs = null;
	
	@Override
	public ConfigGroupBean getRuleConfigBean(Date runDate, ConfigCategoryEnum configCategory) throws HCException {
		
		List<ConfigGroupBean> allConfigGroupBeansForCategory = configDataLoader.loadRuleConfigBeansByCategory(configCategory.toString());
		
		ConfigGroupBean retConfigGroupBean = getConfigGroupBeanForDate(runDate, allConfigGroupBeansForCategory);
		
		return retConfigGroupBean;
	}
	
	private ConfigGroupBean getConfigGroupBeanForDate(Date runDate, List<ConfigGroupBean> allConfigGroupBeansForCategory) {
		
		Calendar calRunDate = HxDateUtils.convertDateToCalendar(runDate);
		
		for(ConfigGroupBean eachBean : allConfigGroupBeansForCategory) {
			Calendar calStartDate = HxDateUtils.convertDateToCalendar(eachBean.getEffectiveStartDate());
			Calendar calEndDate = HxDateUtils.convertDateToCalendar(eachBean.getEffectiveEndDate());
			
			if((calStartDate.before(calRunDate) || calStartDate.equals(calRunDate)) && (calEndDate.after(calRunDate) || calEndDate.equals(calRunDate))) {
				return eachBean;
			}
		}
		
		return null;
	}	
	
	/**
	 * CR1140 This method is added to find the value of Rule Config table based
	 * on the key For e.g. If the value of APTC PP to EPP Switch need to be
	 * found. The method will return the date if the key passed is
	 * "APTC_PP_TO_EPP_SWITCH_DATE". This method can also be used for the other
	 * keys in Rule Config table.
	 * @param RuleKey 
	 * @author sbhandari9
	 * @version 1.0
	 * @since 2015-06-09
	 */
	@Override
	public String getRuleConfigValueForKey(RuleKey key) throws HCException {
		String value = null;

		ConfigGroupBean configGroupBean = getRuleConfigBean(HXUtility.getCurrentDate(), ConfigCategoryEnum.INDIVIDUAL);
		value = configGroupBean.getStringValueFor(key);

		return value;
	}
}
