package com.hcentive.rulesengine.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcentive.utils.ext.HXUtility;
import com.hcentive.utils.ext.HxDateUtils;

public class ConfigGroupBean {
	
	private static Logger logger = LoggerFactory.getLogger(ConfigGroupBean.class);
	
	private Long id;
	private String version;	
	private String ruleVersion;
	private Date effectiveStartDate;
	private Date effectiveEndDate;	
	private List<RuleKeyValueBean> allKeyValue = new ArrayList<RuleKeyValueBean>();
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}
	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}
	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}
	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}
	public List<RuleKeyValueBean> getAllKeyValue() {
		return allKeyValue;
	}
	public void setAllKeyValue(List<RuleKeyValueBean> allKeyValue) {
		this.allKeyValue = allKeyValue;
	}
	
	public Calendar getEffectiveStartDateAsCalendar() {
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(effectiveStartDate);
		return startDate;
	}
	
	public Calendar getEffectiveEndDateAsCalendar() {
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(effectiveEndDate);
		return endDate;
	}
	
	public Double getValueFor(RuleKey key) {
		for(RuleKeyValueBean eachKVBean : allKeyValue) {
			if(key.toString().equals(eachKVBean.getKey())) {
				return new Double(eachKVBean.getValue());
			}
		}
		return null;
	}
	
	public Integer getIntegerValueFor(RuleKey key) {
		for(RuleKeyValueBean eachKVBean : allKeyValue) {
			if(key.toString().equals(eachKVBean.getKey())) {
				return new Integer(eachKVBean.getValue());
			}
		}
		return null;
	}
	
	public String getStringValueFor(RuleKey key) {
		for(RuleKeyValueBean eachKVBean : allKeyValue) {
			if(key.toString().equals(eachKVBean.getKey())) {
				return eachKVBean.getValue();
			}
		}
		return null;
	}

	public String getStringValueFor(String key) {
		for(RuleKeyValueBean eachKVBean : allKeyValue) {
			if(key.equals(eachKVBean.getKey())) {
				return eachKVBean.getValue();
			}
		}
		return null;
	}
	
	public RuleKeyValueBean getRuleKeyValueBean(String key) {
		for(RuleKeyValueBean eachKVBean : allKeyValue) {
			if(key.equals(eachKVBean.getKey())) {
				return eachKVBean;
			}
		}
		return null;
	}
	public Date getDateValueFor(RuleKey key) {
		for(RuleKeyValueBean eachKVBean : allKeyValue) {
			if(key.toString().equals(eachKVBean.getKey())) {
				return HxDateUtils.formatStringToDate(eachKVBean.getValue());
			}
		}
		return null;
	}
	
	@Deprecated
	/*
	 * This method should never be used at any time from the application.
	 * This method is just to facilitate dbunit test case execution.
	 */
	public void setValueFor(RuleKey key, String value) {
		for(RuleKeyValueBean eachKVBean : allKeyValue) {
			if(key.toString().equals(eachKVBean.getKey())) {
				eachKVBean.setValue(value);
				
			}
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRuleVersion() {
		return ruleVersion;
	}
	public void setRuleVersion(String ruleVersion) {
		this.ruleVersion = ruleVersion;
	}
	
	/*@Override
	public boolean equals(Object obj) {
		if(obj instanceof RuleConfigBean) {
			RuleConfigBean newObj = (RuleConfigBean) obj;
			if(newObj.getEffectiveEndDate().equals(this.getEffectiveEndDate()) &&
				newObj.getEffectiveStartDate().equals(this.getEffectiveStartDate()) &&
				newObj.getVersion().equals(this.getVersion())) {
				return true;
			}
		}
		return false;		
	}
	
	@Override
	public int hashCode() {
		return this.effectiveEndDate.hashCode() + this.effectiveStartDate.hashCode() + this.version.hashCode();
	}*/
	
	public Double getDoubleValueFor(RuleKey key) {
		for(RuleKeyValueBean eachKVBean : allKeyValue) {
			if(key.toString().equals(eachKVBean.getKey())) {
				return new Double(eachKVBean.getValue());
			}
		}
		return null;
	}
}
