package com.hcentive.rulesengine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.hcentive.rulesengine.domain.ConfigGroup;
import com.hcentive.rulesengine.domain.ConfigGroupBean;
import com.hcentive.rulesengine.domain.RuleConfigKeyValue;
import com.hcentive.rulesengine.domain.RuleKey;
import com.hcentive.rulesengine.domain.RuleKeyValueBean;
import com.hcentive.utils.orm.dao.GenericDAO;

public class ConfigDBDataDataLoaderImpl implements ConfigDataLoader {
	
	@Autowired
	private GenericDAO genericDAO;

	@Cacheable(value = "configCategory")
	public List<ConfigGroupBean> loadRuleConfigBeansByCategory(String configCategory) {
		List<ConfigGroupBean> allconfigGroupBeanForCategory = new ArrayList<ConfigGroupBean>();
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("configCategory", configCategory);
		
		List<ConfigGroup> allRuleConfig = (List<ConfigGroup>) genericDAO.findByNamedQuery("configGroup.findAllByCategory", param);
		for (ConfigGroup eachConfigGroup : allRuleConfig) {
			loadConfigGroupBean(eachConfigGroup, allconfigGroupBeanForCategory);
		}
		return allconfigGroupBeanForCategory;
	}
	
	private void loadConfigGroupBean(ConfigGroup eachConfigGroup, List<ConfigGroupBean> allconfigGroupBean) {		
		ConfigGroupBean cgBean = new ConfigGroupBean();
		cgBean.setId(eachConfigGroup.getId());
		cgBean.setEffectiveEndDate(eachConfigGroup.getEffectiveEndDate());
		cgBean.setEffectiveStartDate(eachConfigGroup.getEffectiveStartDate());
		cgBean.setVersion(eachConfigGroup.getVersion());
		for (RuleConfigKeyValue eachKeyValue : eachConfigGroup.getRuleConfigValues()) {
			
			RuleKeyValueBean keyValueBean = new RuleKeyValueBean();
			if (eachKeyValue.getKey().equals(RuleKey.RULE_VERSION.toString())) {
				
				cgBean.setRuleVersion(eachKeyValue.getValue());
			}
			keyValueBean.setKey(eachKeyValue.getKey());
			keyValueBean.setValue(eachKeyValue.getValue());
			keyValueBean.setId(eachKeyValue.getId());
			keyValueBean.setDocumentShortName(eachKeyValue.getShortName());
			keyValueBean.setDocumentDescription(eachKeyValue.getDescription());
			cgBean.getAllKeyValue().add(keyValueBean);
		}
		allconfigGroupBean.add(cgBean);
	}

}
