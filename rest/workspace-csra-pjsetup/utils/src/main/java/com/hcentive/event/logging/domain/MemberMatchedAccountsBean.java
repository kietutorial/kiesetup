package com.hcentive.event.logging.domain;


public class MemberMatchedAccountsBean {

	private String accountId;

	private String cin;

	private Long eligibilityId;
	
	private Long eligibilityStatus;

	private Long enrollmentId;
	
	private Long enrollmentStatus;
	
	private boolean matchedHOHIndicator;

	private boolean shopAccountIndicator;
	
	private boolean subSetWMSAcctIndicator;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Long getEligibilityId() {
		return eligibilityId;
	}

	public void setEligibilityId(Long eligibilityId) {
		this.eligibilityId = eligibilityId;
	}

	public Long getEligibilityStatus() {
		return eligibilityStatus;
	}

	public void setEligibilityStatus(Long eligibilityStatus) {
		this.eligibilityStatus = eligibilityStatus;
	}

	public Long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Long getEnrollmentStatus() {
		return enrollmentStatus;
	}

	public void setEnrollmentStatus(Long enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}

	public boolean isMatchedHOHIndicator() {
		return matchedHOHIndicator;
	}

	public void setMatchedHOHIndicator(boolean matchedHOHIndicator) {
		this.matchedHOHIndicator = matchedHOHIndicator;
	}

	public boolean isShopAccountIndicator() {
		return shopAccountIndicator;
	}

	public void setShopAccountIndicator(boolean shopAccountIndicator) {
		this.shopAccountIndicator = shopAccountIndicator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberMatchedAccountsBean other = (MemberMatchedAccountsBean) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		return true;
	}

	public boolean isSubSetWMSAcctIndicator() {
		return subSetWMSAcctIndicator;
	}

	public void setSubSetWMSAcctIndicator(boolean subSetWMSAcctIndicator) {
		this.subSetWMSAcctIndicator = subSetWMSAcctIndicator;
	}

	
}
