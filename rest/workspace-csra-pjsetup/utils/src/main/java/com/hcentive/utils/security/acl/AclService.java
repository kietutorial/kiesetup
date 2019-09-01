/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.security.acl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Sid;

/**
 * This is a dummy ACLService which doesn't do anything but return <b>null</b>
 * for all its methods. ACLService is a mandatory argument for ACLVoters'
 * constructors and hence was created, but this isn't being used from any of the
 * voters as we have not gone with the database-based implementation of ACL
 * 
 * @author Sumit Taneja
 */
public class AclService implements org.springframework.security.acls.model.AclService {

	@Override
	public List<ObjectIdentity> findChildren(ObjectIdentity object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acl readAclById(ObjectIdentity object) throws NotFoundException {
		return readAclById(object, null);
	}

	@Override
	public Acl readAclById(ObjectIdentity object, List<Sid> sids) throws NotFoundException {
		List<ObjectIdentity> objects = new ArrayList<ObjectIdentity>();
		objects.add(object);

		Map<ObjectIdentity, Acl> map = readAclsById(objects, sids);
		if (map == null || map.size() == 0) {
			return null;
		}
		return map.get(object);
	}

	@Override
	public Map<ObjectIdentity, Acl> readAclsById(List<ObjectIdentity> objects) throws NotFoundException {
		return readAclsById(objects, null);
	}

	@Override
	public Map<ObjectIdentity, Acl> readAclsById(List<ObjectIdentity> objects, List<Sid> sids) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
