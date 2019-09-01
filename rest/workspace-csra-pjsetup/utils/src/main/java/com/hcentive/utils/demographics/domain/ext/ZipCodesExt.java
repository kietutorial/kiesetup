package com.hcentive.utils.demographics.domain.ext;

import javax.persistence.JoinColumn;

import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.OneToOne;

@NamedQueries(value = {
		@NamedQuery(name = "zipCodesList.findAll", query = "select distinct a from ZipCodes a",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.findByStateCode", query = "select distinct a from ZipCodes a where UPPER(a.stateCode)=:stateCode order by a.county asc",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.findByCounty", query = "select distinct a from ZipCodes a where UPPER(a.county)=:county",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.findCountiesByZipCode", query = "select distinct a from ZipCodes a where a.code=:code",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.findAllExceptStateCode", query = "select distinct a from ZipCodes a where UPPER(a.stateCode)<>:stateCode order by a.county asc",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.findByZipCountyState", query = "select distinct a from ZipCodes a where a.code=:zipCode and a.hxCounty.countyCode=:countyCode and UPPER(a.stateCode)=:stateCode",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}) })
@MappedSuperclass
public class ZipCodesExt {
	@OneToOne
	@JoinColumn(name = "county_cd", insertable = false, updatable = false)
	private HXCounty hxCounty;

	@OneToOne
	@JoinColumn(name = "state_code", insertable = false, updatable = false)
	private HXState hxState;

	/**
	 * @return the hxCounty
	 */
	public HXCounty getHxCounty() {
		return hxCounty;
	}

	/**
	 * @param hxCounty
	 *            the hxCounty to set
	 */
	public void setHxCounty(HXCounty hxCounty) {
		this.hxCounty = hxCounty;
	}

	/**
	 * @return the hxState
	 */
	public HXState getHxState() {
		return hxState;
	}

	/**
	 * @param hxState
	 *            the hxState to set
	 */
	public void setHxState(HXState hxState) {
		this.hxState = hxState;
	}

}
