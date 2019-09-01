package com.hcentive.rulesengine.domain;

import java.util.Calendar;
import java.util.Date;

import com.hcentive.rulesengine.domain.RuleKey;

public class RuleKeyValueBean {
	
	private Long id;
	private String key;
	private String value;
	private Date effectiveStartDate;
	private Date effectiveEndDate;
	private String documentShortName;
	private String documentDescription;
	
	public RuleKeyValueBean() {
		
	}

	public RuleKeyValueBean(Long id, String key, String value, Date effectiveStartDate, Date effectiveEndDate) {
		this.id = id; 
		this.key = key;
		this.value = value;
		this.effectiveStartDate = effectiveStartDate;
		this.effectiveEndDate = effectiveEndDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
	
	public Calendar getEffectiveStartDateAsCalendar() {
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(effectiveStartDate);
		return startDate;
	}
	
	public Calendar getEffectiveEndDateAsCalendar() {
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(effectiveEndDate);
		return startDate;
	}

	public String getDocumentShortName() {
		return documentShortName;
	}

	public void setDocumentShortName(String documentShortName) {
		this.documentShortName = documentShortName;
	}

	public String getDocumentDescription() {
		return documentDescription;
	}

	public void setDocumentDescription(String documentDescription) {
		this.documentDescription = documentDescription;
	}	
	
}
