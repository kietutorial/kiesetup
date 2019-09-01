package com.hcentive.utils.hxid.service;

import java.util.Date;

import com.hcentive.utils.ext.HXUtility;

public class Person {

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getHxid() {
		return hxid;
	}

	public void setHxid(String hxid) {
		this.hxid = hxid;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	private String firstName;

	private String middleName;

	private String lastName;

	private String gender;

	private Date dob;

	private String ssn;

	private String hxid;

	private String suffix;
	
	private String driverLicenseId;
	
	private String nonDriverId;
	
	private String userCinNumber;
		
	private Long userProfileId;
	
	private String zipCode;
	
	private boolean isShop;

	private PersonSource personSource;
	
	private String nyhxMemberId;

	private boolean Foundinprevious_elg_enrl;
	 
	private String accountId;
	
	/**
	 * this is used for back office search while assign user input hix, this
	 * will invoke both literal and Probabilistic search and merge the result
	 * even if literal search finds a match
	 */
	private boolean searchAll=false;
	
	public Person() {
	}

	public Person(String firstName, String middleName, String lastName, String gender, Date dob, String ssn, String  m           ,
			String suffix, PersonSource personSource) {
		this();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.ssn = ssn;
		this.hxid = hxid;
		this.suffix = suffix;
		this.setPersonSource(personSource);
		this.Foundinprevious_elg_enrl=false;
	}
	
	public Person(String firstName, String middleName, String lastName, String gender, Date dob, String ssn, String  m ,
			String suffix, String zipCode,  PersonSource personSource) {
		this();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.ssn = ssn;
		this.zipCode = zipCode;	
		this.setPersonSource(personSource);
		this.Foundinprevious_elg_enrl=false;
	}

	public Person(String firstName, String middleName, String lastName, String gender, Date dob, String ssn, String  m           ,
			String suffix, String driverLicenseId,String nonLicenseId, String userCinNumber, boolean hixCSROverride , PersonSource personSource  ) {
		this();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.ssn = ssn;
		this.hxid = hxid;
		this.suffix = suffix;
		this.driverLicenseId = driverLicenseId;
		this.nonDriverId = nonLicenseId;
		this.userCinNumber = userCinNumber;
		this.setPersonSource(personSource);
		this.Foundinprevious_elg_enrl=false;
	}
	
	public String getUserCinNumber() {
		return userCinNumber;
	}

	public void setUserCinNumber(String userCinNumber) {
		this.userCinNumber = userCinNumber;
	}

	public String getDriverLicenseId() {
		return driverLicenseId;
	}

	public void setDriverLicenseId(String driverLicenseId) {
		this.driverLicenseId = driverLicenseId;
	}

	public String getNonDriverId() {
		return nonDriverId;
	}

	public void setNonDriverId(String nonDriverId) {
		this.nonDriverId = nonDriverId;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public boolean isShop() {
		return isShop;
	}

	public void setShop(boolean isShop) {
		this.isShop = isShop;
	}

	public PersonSource getPersonSource() {
		return personSource;
	}

	public void setPersonSource(PersonSource personSource) {
		this.personSource = personSource;
	}
	public boolean isFoundinprevious_elg_enrl() {
		return Foundinprevious_elg_enrl;
	}

	public void setFoundinprevious_elg_enrl(boolean foundinprevious_elg_enrl) {
		Foundinprevious_elg_enrl = foundinprevious_elg_enrl;
	}
	
	
	public String getNyhxMemberId() {
		return nyhxMemberId;
	}

	public void setNyhxMemberId(String nyhxMemberId) {
		this.nyhxMemberId = nyhxMemberId;
	}

	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	
	public boolean isSearchAll() {
		return searchAll;
	}

	public void setSearchAll(boolean searchAll) {
		this.searchAll = searchAll;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result	+ ((HXUtility.isEmpty(ssn)) ? 0 : ssn.hashCode());
		result = prime * result + ((HXUtility.isEmpty(middleName)) ? 0 : middleName.hashCode());
		result = prime * result + ((HXUtility.isEmpty(suffix)) ? 0 : suffix.hashCode());
		
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
		Person other = (Person) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		
		String ssnStr = "";
		if (!HXUtility.isEmpty(ssn)) {
			ssnStr = ssn;
		}	
		if (!ssnStr.equals(other.ssn))
				return false;

		String middleStr = "";
		if (!HXUtility.isEmpty(middleName)) {
			middleStr = middleName;
		}
		if (!middleStr.equals(other.middleName))
				return false;
		
		String suffixStr = "";
		if (!HXUtility.isEmpty(suffix)) {
			suffixStr = suffix;
		}
		if (!suffixStr.equals(other.suffix))
			return false;
		return true;
	}
	
	
}
