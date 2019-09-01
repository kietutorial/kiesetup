package com.hcentive.utils.ui.screen.config;

import java.util.Map;

import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.ui.screen.config.domain.UiScreenNames;

public interface ScreenConfigurationService {

	public Map<String, Boolean> getScreenConfiguration(UiScreenNames screenName) throws HCException;
}
