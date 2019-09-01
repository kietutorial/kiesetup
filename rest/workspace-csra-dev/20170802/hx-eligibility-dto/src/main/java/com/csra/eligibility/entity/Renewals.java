package com.csra.eligibility.entity;

/**
 * This class was automatically generated by the data modeler tool.
 */

@org.kie.api.definition.type.Description("Renewal processing flow state pojo")
public class Renewals implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	private java.lang.Boolean renewNoshow;
	private java.lang.Boolean currentlyEnrolledInMedicaid;
	private java.lang.Boolean memberRenewalDueUpComingMonth;

	public Renewals() {
	}

	public java.lang.Boolean isRenewNoshow() {
		return this.renewNoshow;
	}

	public void setRenewNoshow(java.lang.Boolean renewNoshow) {
		this.renewNoshow = renewNoshow;
	}

	public java.lang.Boolean isCurrentlyEnrolledInMedicaid() {
		return this.currentlyEnrolledInMedicaid;
	}

	public void setCurrentlyEnrolledInMedicaid(
			java.lang.Boolean currentlyEnrolledInMedicaid) {
		this.currentlyEnrolledInMedicaid = currentlyEnrolledInMedicaid;
	}

	public java.lang.Boolean isMemberRenewalDueUpComingMonth() {
		return this.memberRenewalDueUpComingMonth;
	}

	public void setMemberRenewalDueUpComingMonth(
			java.lang.Boolean memberRenewalDueUpComingMonth) {
		this.memberRenewalDueUpComingMonth = memberRenewalDueUpComingMonth;
	}

	public Renewals(java.lang.Boolean renewNoshow,
			java.lang.Boolean currentlyEnrolledInMedicaid,
			java.lang.Boolean memberRenewalDueUpComingMonth) {
		this.renewNoshow = renewNoshow;
		this.currentlyEnrolledInMedicaid = currentlyEnrolledInMedicaid;
		this.memberRenewalDueUpComingMonth = memberRenewalDueUpComingMonth;
	}

}
