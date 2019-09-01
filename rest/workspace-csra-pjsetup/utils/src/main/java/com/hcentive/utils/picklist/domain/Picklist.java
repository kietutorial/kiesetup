/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.picklist.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.hcentive.utils.picklist.domain.ext.PicklistExt;

@Entity
@Table(name = "picklist")
@NamedQueries(value = {
		@NamedQuery(name = "picklist.getAllPicklists", query = "SELECT pl from  Picklist pl order by id"),
		@NamedQuery(name = "picklist.getPicklistsByPicklistNameAndLocale", query = "SELECT pl from  Picklist pl where picklistName =:picklistName and locale = :locale and enabled =true order by id"),
		@NamedQuery(name = "picklist.getPicklistsByPicklistNameAndDefaultLocale", query = "SELECT pl from  Picklist pl where picklistName =:picklistName and locale='en' and enabled =true order by id"),
		@NamedQuery(name = "picklist.getPicklistsByPicklistNameAndNameAndLocale", query = "SELECT pl from  Picklist pl where picklistName =:picklistName and name=:name and locale =:locale  and enabled =true order by id"),
		@NamedQuery(name = "picklist.getPicklistsByPicklistNameAndNameAndDefaultLocale", query = "SELECT pl from  Picklist pl where picklistName =:picklistName and name=:name and locale is null and enabled =true order by id"),
		@NamedQuery(name = "picklist.getPicklistsByValueAndLocale", query = "SELECT pl from  Picklist pl where  value=:value and locale =:locale and enabled =true order by id"),
		@NamedQuery(name = "picklist.getPicklistsByValueAndDefaultLocale", query = "SELECT pl from  Picklist pl where  value=:value and locale is null and enabled =true order by id"),
		@NamedQuery(name = "picklist.getPicklistsByNameAndLocale", query = "SELECT pl from  Picklist pl where  name=:name and locale =:locale and enabled =true order by id"),
		@NamedQuery(name = "picklist.getPicklistsByNameAndDefaultLocale", query = "SELECT pl from  Picklist pl where  name=:name and locale is null and enabled =true order by id") })
public class Picklist extends PicklistExt implements Serializable {

	public static final String DEFAULT_LOCALE = "default";

	private static final long serialVersionUID = 1815917068026514745L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@Column(name = "name")
	String name;

	@Column(name = "value")
	String value;

	@Column(name = "picklist_name")
	String picklistName;

	@Column(name = "locale")
	String locale;

	@Column(name = "enabled")
	Boolean enabled;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPicklistName() {
		return picklistName;
	}

	public void setPicklistName(String picklistName) {
		this.picklistName = picklistName;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
