/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.demographics.domain;

import java.io.Serializable;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.hcentive.utils.demographics.domain.ext.ZipCodesExt;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "zip_codes")
@NamedQueries(value = {
		@NamedQuery(name = "zipCodesList.findByCode", query = "select a from ZipCodes a where a.code=:code  order by a.county asc",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.findByCodeAndCounty", query = "select a from ZipCodes a where a.code=:code and a.county = :county",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.findByStateCounty", query = "select a from ZipCodes a where a.stateCode=:stateCode and a.county = :county",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.findCountiesByCode", query = "select a.county from ZipCodes a where a.code=:code",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.findCountiesByZipSet", query = "select distinct a.county from ZipCodes a where a.code IN (:codeSet) ",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.findNyCountiesByZipSet", query = "select distinct a.county from ZipCodes a where a.code IN (:codeSet) and a.stateCode=:stateCode",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.getDistinctStateCodes", query = "select distinct a.stateCode from ZipCodes a where a.code=:code",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
		@NamedQuery(name = "zipCodesList.findStateByStateCode", query = "select distinct a.stateCode from ZipCodes a where a.stateCode=:stateCode",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}) })
@IdClass(ZipCodesPK.class)
public class ZipCodes extends ZipCodesExt implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@AttributeOverrides({ @AttributeOverride(name = "code", column = @Column(name = "code")),
			@AttributeOverride(name = "county", column = @Column(name = "county")) })
	@Column(name = "code")
	private String code;

	@Column(name = "state_code")
	private String stateCode;

	@Column(name = "county")
	private String county;

	@Column(name = "city")
	private String city;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
