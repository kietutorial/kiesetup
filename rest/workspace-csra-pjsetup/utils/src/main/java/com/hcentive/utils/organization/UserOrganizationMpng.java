/**
 * 
 */
package com.hcentive.utils.organization;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Broker Organization Entity
 * 
 * @author Anshu
 * @version {$Version}
 */
@Entity
@Table(name = "user_organization_mpng")
@NamedQueries(value = {
		@NamedQuery(name = "userOrganizationMpng.findOrganizationIdsByUserProfileId", query = "SELECT a.brokerOrganizationId from UserProfileBrokerOrganizationMpng a WHERE a.userProfileId=:userProfileId"),
		@NamedQuery(name = "userOrganizationMpng.findUserProfileIdsByOrganizationId", query = "SELECT a.userProfileId  		 from UserProfileBrokerOrganizationMpng a WHERE a.brokerOrganizationId=:organizationId") })
public class UserOrganizationMpng implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1080877L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "user_profile_id")
	private Long userProfileId;

	@Column(name = "organization_id")
	private Long organizationId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

}
