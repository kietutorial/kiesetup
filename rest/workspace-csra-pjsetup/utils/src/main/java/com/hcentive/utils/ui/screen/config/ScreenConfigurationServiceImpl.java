package com.hcentive.utils.ui.screen.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.orm.dao.GenericDAO;
import com.hcentive.utils.ui.screen.config.domain.UiScreenConfiguration;
import com.hcentive.utils.ui.screen.config.domain.UiScreenNames;

public class ScreenConfigurationServiceImpl implements ScreenConfigurationService {

	private static Logger log = LoggerFactory.getLogger(ScreenConfigurationServiceImpl.class);

	@Autowired
	private GenericDAO<UiScreenConfiguration> genericDAO;

	@Override
	public Map<String, Boolean> getScreenConfiguration(UiScreenNames screenName) throws HCException {
		if (screenName == null) {
			throw new HCException(new MessageCode("Screen name cannot be null. Please use a valid screen name to load config"),
					"Screen name cannot be null. Please use a valid screen name to load config");
		}
		log.info("getRegistrationScreenConfiguration. Loading screen configuration for: " + screenName.name());

		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("screenName", screenName);
		List<UiScreenConfiguration> screenConfig = genericDAO.findByNamedQuery("irsc.loadConfig.forscreen", param);

		if (null != screenConfig && !screenConfig.isEmpty()) {
			for (UiScreenConfiguration uiScreenConfiguration : screenConfig) {
				resultMap.put(uiScreenConfiguration.getHtmlFieldId(), uiScreenConfiguration.getVisible());
			}
			log.debug("getRegistrationScreenConfiguration. Screen Configuration " + resultMap);
		}
		log.info("getRegistrationScreenConfiguration. Configuration loaded for screen: " + screenName.name()
				+ ". Number of fields loaded" + resultMap.size() + " fields");
		return resultMap;
	}

	public GenericDAO<UiScreenConfiguration> getGenericDAO() {
		return genericDAO;
	}

	public void setGenericDAO(GenericDAO<UiScreenConfiguration> genericDAO) {
		this.genericDAO = genericDAO;
	}
}
