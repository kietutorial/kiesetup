/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web.action;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcentive.utils.tooltip.service.ToolTip;
import com.hcentive.utils.tooltip.service.ToolTipService;
import com.hcentive.utils.utils.Springi18nUtils;

@Controller
public class ToolTipController {

	@Autowired
	private ToolTipService toolTipService;

	@RequestMapping(value = "/tooltip", method = RequestMethod.GET)
	public @ResponseBody
	ToolTip getToolTip(@RequestParam("id") String identifier, Locale locale) {
		ToolTip toolTip = toolTipService.getToolTip(identifier, locale.getLanguage());
		if (toolTip == null) {
			String title = Springi18nUtils.getMessage(identifier + "_title", null, locale);
			String description = Springi18nUtils.getMessage(identifier + "_description", null, locale);
			if (null == title)
				/****
				 * Tool tip should not display null on ui so setting it as empty
				 * for null cases
				 ****/
				title = "";
			if (null == description)
				description = "";
			toolTip = new ToolTip();
			toolTip.setIdentifier(identifier);
			toolTip.setTitle(title);
			toolTip.setDescription(description);
		}
		return toolTip;
	}

	public void setToolTipService(ToolTipService toolTipService) {
		this.toolTipService = toolTipService;
	}

}
