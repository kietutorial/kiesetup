/**
 * 
 */
package com.hcentive.utils.demographics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author Sunny Bindal
 * 
 */
@Entity
@Table(name = "country_phone_code")
@NamedQueries(value = { @NamedQuery(name = "CountryPhoneCodes.getByCountryCode", query = "SELECT c FROM CountryPhoneCodes c WHERE countryCode=:countryCode") })
public class CountryPhoneCodes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "country_phone_code")
	private String countryPhoneCode;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the countryPhoneCode
	 */
	public String getCountryPhoneCode() {
		return countryPhoneCode;
	}

	/**
	 * @param countryPhoneCode
	 *            the countryPhoneCode to set
	 */
	public void setCountryPhoneCode(String countryPhoneCode) {
		this.countryPhoneCode = countryPhoneCode;
	}

}
