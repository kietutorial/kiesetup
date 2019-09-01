package com.csra.eligibility.domain.rulefact;

/**
 * @author Philip Jahmani Chauvet (philip.chauvet@csra.com)
 */
public class EligibilityResult {
	// Did a rule or processing flow change the eligibility result
	private boolean isTouched;
	private boolean isEligibleStatus;
	private String reason;

	public boolean isEligibleStatus() {
		return isEligibleStatus;
	}

	public void setEligibleStatus(boolean isEligible) {
		this.isEligibleStatus = isEligible;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isTouched() {
		return isTouched;
	}

	public void setTouched(boolean isTouched) {
		this.isTouched = isTouched;
	}

	@Override
	public String toString() {
		return "EligibilityResult [isTouched=" + isTouched + ", isEligibleStatus=" + isEligibleStatus + ", reason="
				+ reason + "]";
	}

}
