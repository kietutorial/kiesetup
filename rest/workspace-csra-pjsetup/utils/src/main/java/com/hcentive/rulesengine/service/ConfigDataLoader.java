package com.hcentive.rulesengine.service;

import java.util.List;

import com.hcentive.rulesengine.domain.ConfigGroupBean;

public interface ConfigDataLoader {
	
	public List<ConfigGroupBean> loadRuleConfigBeansByCategory(String configCategory);

}
