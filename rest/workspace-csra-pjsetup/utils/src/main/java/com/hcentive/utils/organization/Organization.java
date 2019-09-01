/**
 * 
 */
package com.hcentive.utils.organization;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.hcentive.utils.orm.model.Persistent;

/**
 * Organization entity
 * 
 * @author Anshu
 * 
 */
@Entity
@Table(name = "organization")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "organization_type", discriminatorType = DiscriminatorType.STRING)
@NamedQueries(value = {
		@NamedQuery(name = "organization.findAll", query = "SELECT DISTINCT a from BrokerOrganization a " +
				"where id in (select brokerOrganizationId from  UserProfileBrokerOrganizationMpng up)"),
		@NamedQuery(name = "organization.findById", query = "SELECT a from Organization a WHERE a.id in (:organizationIdList)"),
		@NamedQuery(name = "organization.findObjectById", query = "SELECT a from Organization a WHERE a.id=:organizationId") })

public class Organization extends Persistent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1124123412L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "website_url")
	private String websiteUrl;

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String wesiteUrl) {
		this.websiteUrl = wesiteUrl;
	}

	// @Enumerated(EnumType.STRING)
	// @Column(name = "organization_type")
	// private OrganizationTypeEnum organizationType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public OrganizationTypeEnum getOrganizationType() {
	// return organizationType;
	// }
	//
	// public void setOrganizationType(OrganizationTypeEnum organizationType) {
	// this.organizationType = organizationType;
	// }

}
