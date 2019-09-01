/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.notification.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "freemarker_template")
@NamedQueries(value = {
		@NamedQuery(name = "freemarkerTemplate.findAllTemplate", query = "SELECT a from FreeMarkerTemplate a"),
		@NamedQuery(name = "freemarkerTemplate.updateUUID", query = "UPDATE FreeMarkerTemplate f SET f.UUID=:UUID WHERE f.templateName=:templateName"),
		@NamedQuery(name = "freemarkerTemplate.getTemplateObjByName", query = "from FreeMarkerTemplate WHERE templateName = :templateName") })
public class FreeMarkerTemplate implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "template_name")
	private String templateName;

	@Column(name = "template_desc")
	private String templateDescription;

	@Column(name = "template_content")
	private String templateContent;

	@Column(name = "editable")
	private Long editable;

	@Column(name = "uuid")
	private String UUID;

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateDescription() {
		return templateDescription;
	}

	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public Long getEditable() {
		return editable;
	}

	public void setEditable(Long editable) {
		this.editable = editable;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FreeMarkerTemplate [templateName=" + templateName + "]";
	}
}
