/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.tooltip.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tooltips")
@NamedQueries(value = { @NamedQuery(name = "tooltip.getToolTip", query = "select t FROM ToolTip t WHERE t.identifier = :identifier and t.locale = :locale") })
public class ToolTip {
	@Id
	@Column(name = "identifier")
	private String identifier;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "locale")
	private String locale;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getLocale() {
		return locale;
	}

}
