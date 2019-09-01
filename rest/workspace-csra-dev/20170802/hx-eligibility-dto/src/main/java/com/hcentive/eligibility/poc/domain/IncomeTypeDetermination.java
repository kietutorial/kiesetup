package com.hcentive.eligibility.poc.domain;

@org.kie.api.definition.type.Description("Income Type Determination processing flow state hanlding")
public class IncomeTypeDetermination implements java.io.Serializable {
	private boolean LSC;
	private boolean LSCLastThreeMonths;
	private boolean ineligible;
	private boolean proposed;
	private boolean previousStandard;
	private boolean previousDataSource;
	private boolean previousNoIncome;

	public boolean isLSC() {
		return LSC;
	}

	public void setLSC(boolean lSC) {
		LSC = lSC;
	}

	public boolean isLSCLastThreeMonths() {
		return LSCLastThreeMonths;
	}

	public void setLSCLastThreeMonths(boolean lSCLastThreeMonths) {
		LSCLastThreeMonths = lSCLastThreeMonths;
	}

	public boolean isIneligible() {
		return ineligible;
	}

	public void setIneligible(boolean ineligible) {
		this.ineligible = ineligible;
	}

	public boolean isProposed() {
		return proposed;
	}

	public void setProposed(boolean proposed) {
		this.proposed = proposed;
	}

	public boolean isPreviousStandard() {
		return previousStandard;
	}

	public void setPreviousStandard(boolean previousStandard) {
		this.previousStandard = previousStandard;
	}

	public boolean isPreviousDataSource() {
		return previousDataSource;
	}

	public void setPreviousDataSource(boolean previousDataSource) {
		this.previousDataSource = previousDataSource;
	}

	public boolean isPreviousNoIncome() {
		return previousNoIncome;
	}

	public void setPreviousNoIncome(boolean previousNoIncome) {
		this.previousNoIncome = previousNoIncome;
	}

	public IncomeTypeDetermination() {
	}

	public IncomeTypeDetermination(boolean LSC, boolean LSCLastThreeMonths,
			boolean ineligible, boolean proposed, boolean previousStandard,
			boolean previousDataSource, boolean previousNoIncome) {
		this.LSC = LSC;
		this.LSCLastThreeMonths = LSCLastThreeMonths;
		this.ineligible = ineligible;
		this.proposed = proposed;
		this.previousStandard = previousStandard;
		this.previousDataSource = previousDataSource;
		this.previousNoIncome = previousNoIncome;
	}
}
