package com.hcentive.broker;

import java.io.Serializable;
import java.util.Date;

public class AuthorizedBroker implements Serializable{
	
	private static final long serialVersionUID = 6768678062910774891L;
	
	private Long brokerId;
	
	/*Broker Contact Information*/
	
	public Long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	private String primaryPhoneNumber;
	private String faxNumber;
	private String email;
	private String brokerName;
	
	private String stateUID;
	private String nyhxId;  

	private String agencyName;/*Organization Name Associated to Client if there is one*/
	
	private String agentType;
	
	private Date authorizationFrom; 
	private Date authorizationTo;
	

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPrimaryPhoneNumber() {
		return primaryPhoneNumber;
	}

	public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
		this.primaryPhoneNumber = primaryPhoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getNyhxId() {
		return nyhxId;
	}

	public void setNyhxId(String nyhxId) {
		this.nyhxId = nyhxId;
	}

	public String getStateUID() {
		return stateUID;
	}

	public void setStateUID(String stateUID) {
		this.stateUID = stateUID;
	}

	public Date getAuthorizationFrom() {
		return authorizationFrom;
	}

	public void setAuthorizationFrom(Date authorizationFrom) {
		this.authorizationFrom = authorizationFrom;
	}

	public Date getAuthorizationTo() {
		return authorizationTo;
	}

	public void setAuthorizationTo(Date authorizationTo) {
		this.authorizationTo = authorizationTo;
	}
	
}
