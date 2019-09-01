package com.hcentive.utils.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/*
 * Returns json representation of any object
 * Should be used only for static objects which don't have any logic involved
 * For instance, a string like "success"
 */

public class ObjectResponseView extends MappingJacksonJsonView {

	private Object responseObject;

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		model.put("response", responseObject);
		super.renderMergedOutputModel(model, request, response);

	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

}
