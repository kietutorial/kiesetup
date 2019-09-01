package com.hcentive.utils.demographics.domain.ext;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

/**
 * The persistent class for the "STATE" database table.
 * 
 */
@Entity
@Table(name = "\"STATE\"")
@NamedQueries(value = { 
@NamedQuery(name = "hxState.findAll", query = "SELECT distinct a from HXState a",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}),
@NamedQuery(name = "hxState.findState", query = "SELECT distinct a from HXState a  where UPPER(a.stateCode)=:stateCode"),
@NamedQuery(name = "hxState.findAllExceptState", query = "SELECT distinct a from HXState a  where UPPER(a.stateCode)<>:stateCode",hints={@QueryHint(name="org.hibernate.cacheable",value="true"),@QueryHint(name="org.hibernate.cacheRegion",value="commoncache")}) 
})
public class HXState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODE", nullable = false, length = 2)
	private String stateCode;

	@Column(name = "NAME", nullable = false, length = 25)
	private String stateName;

	public HXState() {
	}

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}