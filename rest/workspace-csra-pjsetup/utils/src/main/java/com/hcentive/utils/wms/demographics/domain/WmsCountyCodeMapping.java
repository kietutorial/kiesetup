package com.hcentive.utils.wms.demographics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "WMS_COUNTY_CODE_MPNG")
@NamedQueries(value = { 
		@NamedQuery(name = "WmsCountyCodeMapping.getNysohCountyCode", query = "SELECT c FROM WmsCountyCodeMapping c WHERE countyCode=:countyCode"),
		@NamedQuery(name = "WmsCountyCodeMapping.getAllCountyCodes", query = "SELECT c FROM WmsCountyCodeMapping c ")
		})
public class WmsCountyCodeMapping implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "WMS_COUNTY_CD")
	private String countyCode;

	@Column(name = "WMS_COUNTY_NM")
	private String countyName;
	
	@Column(name = "NYHX_COUNTY_CD")
	private String nysohCountyCode;

	@Column(name = "NYHX_COUNTY_NM")
	private String nysohCountyName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getNysohCountyCode() {
		return nysohCountyCode;
	}

	public void setNysohCountyCode(String nysohCountyCode) {
		this.nysohCountyCode = nysohCountyCode;
	}

	public String getNysohCountyName() {
		return nysohCountyName;
	}

	public void setNysohCountyName(String nysohCountyName) {
		this.nysohCountyName = nysohCountyName;
	}
		
}
