package com.hcentive.utils.picklistprovider.ext;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.hcentive.utils.picklist.domain.Picklist;

public interface PickListProviderExt {

	public List<Picklist> getPickListAsObjects(String name, Locale locale);

	public List<Picklist> getPickListAsObjects(String name);

	public Map<String, String> getPickList(String name, String subName, Locale locale);

	public Map<String, String> getPickList(String name, String subName);
}
