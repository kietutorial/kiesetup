package com.hcentive.utils.ui.screen.config.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * This class represents the user_reg_screen_config table. The object stores the
 * visibility configuration for a HTML field.
 * 
 * @author Ankit Khattar
 * 
 */
@Entity
@Table(name = "ui_screen_config")
@NamedQueries(value = { @NamedQuery(name = "irsc.loadConfig.forscreen", query = "SELECT uisc from  UiScreenConfiguration uisc where screenName = :screenName") })
public class UiScreenConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2422813989197396156L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "html_field_id")
	private String htmlFieldId;

	@Column(name = "visible")
	private Boolean visible;

	@Column(name = "screen_name")
	@Enumerated(EnumType.STRING)
	private UiScreenNames screenName;

	@Column(name = "parent_html_field_id")
	private String parentHtmlFieldId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHtmlFieldId() {
		return htmlFieldId;
	}

	public void setHtmlFieldId(String htmlFieldId) {
		this.htmlFieldId = htmlFieldId;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public UiScreenNames getScreenName() {
		return screenName;
	}

	public void setScreenName(UiScreenNames screenName) {
		this.screenName = screenName;
	}

	public String getParentHtmlFieldId() {
		return parentHtmlFieldId;
	}

	public void setParentHtmlFieldId(String parentHtmlFieldId) {
		this.parentHtmlFieldId = parentHtmlFieldId;
	}

	@Override
	public String toString() {
		return "UiScreenConfiguration [id=" + id + ", htmlFieldId=" + htmlFieldId + ", visible=" + visible + ", screenName="
				+ screenName + ", parentHtmlFieldId=" + parentHtmlFieldId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((htmlFieldId == null) ? 0 : htmlFieldId.hashCode());
		result = prime * result + ((parentHtmlFieldId == null) ? 0 : parentHtmlFieldId.hashCode());
		result = prime * result + ((screenName == null) ? 0 : screenName.hashCode());
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
		UiScreenConfiguration other = (UiScreenConfiguration) obj;
		if (htmlFieldId == null) {
			if (other.htmlFieldId != null)
				return false;
		} else if (!htmlFieldId.equals(other.htmlFieldId))
			return false;
		if (parentHtmlFieldId == null) {
			if (other.parentHtmlFieldId != null)
				return false;
		} else if (!parentHtmlFieldId.equals(other.parentHtmlFieldId))
			return false;
		if (screenName == null) {
			if (other.screenName != null)
				return false;
		} else if (!screenName.equals(other.screenName))
			return false;
		return true;
	}

}
