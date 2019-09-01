/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.notification;

import java.util.Map;

import org.springframework.mail.MailPreparationException;

import com.hcentive.utils.notification.template.TemplateProcessor;

/**
 * Abstract class for issuing notifications based on a Notification Event.
 * Includes implementations for default Template name. It requires a
 * TemplateProcessor, which is responsible for implementing a templatized
 * message strategy - the default TemplateProcessor being Freemarker. It also
 * requires a MessageSender, which is responsible for implementing a
 * communication strategy for sending messages.
 * 
 * @author ashish.jaiswal@hcentive.com
 * 
 */
public abstract class AbstractNotifier implements Notifier {

	protected static final String SEPERATOR = "_";

	protected TemplateProcessor templateProcessor;

	/**
	 * Calls template processor with template name of format
	 * notifierType_part.ftl.
	 * 
	 * @param event
	 * @param messagePart
	 * @return
	 */
	protected String renderContent(String event, String messagePart, Map<String, Object> data) {
		String templateName = event + "_" + messagePart; // + "." +
															// templateProcessor.getTemplateExtension();
		try {
			return templateProcessor.process(templateName, data);
		} catch (Exception e) {
			throw new MailPreparationException(e);
		}
	}

	public void setTemplateProcessor(TemplateProcessor templateProcessor) {
		this.templateProcessor = templateProcessor;
	}
}
