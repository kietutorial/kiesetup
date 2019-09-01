package com.csra.eligibility.domain.eligibility;

public class EligibilityResult implements java.io.Serializable {
	private static final long serialVersionUID = 524193560516017901L;
	private String reasons;
	private String indicators;

	public EligibilityResult() {
	}

	public EligibilityResult(String reasons, String indicators) {
		super();
		this.reasons = reasons;
		this.indicators = indicators;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

	public String getIndicators() {
		return indicators;
	}

	public void setIndicators(String indicators) {
		this.indicators = indicators;
	}

	@Override
	public String toString() {
		return "EligbilityResult [Indicators=" + indicators  + ", reasons=" + reasons + "]";
	}

}
