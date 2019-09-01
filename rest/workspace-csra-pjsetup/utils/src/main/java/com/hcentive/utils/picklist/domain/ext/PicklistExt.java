package com.hcentive.utils.picklist.domain.ext;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(value = {
		@NamedQuery(name = "picklist.getOrderedPicklistsByPicklistNameAndLocale", query = "SELECT pl from  Picklist pl where picklistName =:picklistName and locale = :locale order by id"),
		@NamedQuery(name = "picklist.getOrderedPicklistsByPicklistNameAndDefaultLocale", query = "SELECT pl from  Picklist pl where picklistName =:picklistName and locale is null order by id"),
		@NamedQuery(name = "picklist.getOrderedPicklistsByPicklistNameSubNameAndLocale", query = "SELECT pl from  Picklist pl where picklistName =:picklistName and picklistSubName =:picklistSubName and locale = :locale order by id"),
		@NamedQuery(name = "picklist.getOrderedPicklistsByPicklistNameSubNameAndDefaultLocale", query = "SELECT pl from  Picklist pl where picklistName =:picklistName and picklistSubName =:picklistSubName and locale is null order by id") })
@MappedSuperclass
public class PicklistExt implements Serializable {

	@Column(name = "picklist_subname")
	String picklistSubName;

	/**
	 * @return the picklistSubName
	 */
	public String getPicklistSubName() {
		return picklistSubName;
	}

	/**
	 * @param picklistSubName
	 *            the picklistSubName to set
	 */
	public void setPicklistSubName(String picklistSubName) {
		this.picklistSubName = picklistSubName;
	}

}
