package com.hcentive.utils.demographics.domain.ext;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The persistent class for the HX_COUNTY database table.
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "HX_COUNTY")
@NamedQueries(value = { 
		@NamedQuery(name = "hxCounty.findAll", query = "SELECT distinct a from HXCounty a  order by a.countyName"), 
		@NamedQuery(name = "hxCounty.findByCountyCode", query = "SELECT a from HXCounty a  where a.countyCode=:countyCode"),
		@NamedQuery(name = "hxCounty.findByCountyCodeAndNotNullMandatoryDate", 
			query = "SELECT a from HXCounty a  where a.countyCode=:countyCode and a.mandatoryDate is not null"),
		@NamedQuery(name = "srvcAreaRef.findSrvcAreaRefCodeByCounty", query = "SELECT a.ukPlanSrvcAreaCdTxt from SrvcAreaRef a where a.planSrvcAreaDescTxt=:planSrvcAreaDescTxt"),
		@NamedQuery(name = "srvcAreaRef.findCountyByCode", query = "SELECT upper(a.planSrvcAreaDescTxt) from SrvcAreaRef a where a.ukPlanSrvcAreaCdTxt=:ukPlanSrvcAreaCdTxt")
		})
public class HXCounty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COUNTY_CD", unique = true, nullable = false, length = 6)
	private String countyCode;

	@Column(name = "COUNTY_NAME", length = 100)
	private String countyName;
	
	@Column(name = "UPSTATE_DOWNSTATE_IND")
	private String upstateDownstateInd;
	
	@Column(name = "SHORT_COUNTY_CD")
	private String shortCountyCode;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "MANDATORY_DATE")
	private Date mandatoryDate;

	public HXCounty() {
	}

	public String getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getCountyName() {
		return this.countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	/**
	 * @return the upstateDownstateInd
	 */
	public String getUpstateDownstateInd() {
		return upstateDownstateInd;
	}

	/**
	 * @param upstateDownstateInd the upstateDownstateInd to set
	 */
	public void setUpstateDownstateInd(String upstateDownstateInd) {
		this.upstateDownstateInd = upstateDownstateInd;
	}

	public String getShortCountyCode() {
		return shortCountyCode;
	}

	public void setShortCountyCode(String shortCountyCode) {
		this.shortCountyCode = shortCountyCode;
	}

	public Date getMandatoryDate() {
		return mandatoryDate;
	}

	public void setMandatoryDate(Date mandatoryDate) {
		this.mandatoryDate = mandatoryDate;
	}
}