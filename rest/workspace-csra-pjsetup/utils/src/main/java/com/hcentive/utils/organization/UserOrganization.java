package com.hcentive.utils.organization;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_organization")
@DiscriminatorValue("USER")
public class UserOrganization extends Organization {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6351495220155480438L;

}
