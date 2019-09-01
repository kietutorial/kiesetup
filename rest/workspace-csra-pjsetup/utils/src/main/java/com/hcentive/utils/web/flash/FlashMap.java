/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.utils.web.flash;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * The Class FlashMap.
 */
public final class FlashMap {

	/** The Constant FLASH_MAP_ATTRIBUTE. */
	static final String FLASH_MAP_ATTRIBUTE = FlashMap.class.getName();

	/**
	 * Gets the current.
	 * 
	 * @param request
	 *            the request
	 * @return the current
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getCurrent(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String, Object> flash = (Map<String, Object>) session.getAttribute(FLASH_MAP_ATTRIBUTE);
		if (flash == null) {
			flash = new HashMap<String, Object>();
			session.setAttribute(FLASH_MAP_ATTRIBUTE, flash);
		}
		return flash;
	}

	/**
	 * Instantiates a new flash map.
	 */
	private FlashMap() {
	}

	/**
	 * Put.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public static void put(String key, Object value) {
		getCurrent(getRequest(RequestContextHolder.currentRequestAttributes())).put(key, value);
	}

	/**
	 * Sets the info message.
	 * 
	 * @param info
	 *            the new info message
	 */
	public static void setInfoMessage(String info) {
		put(MESSAGE_KEY, new Message(MessageType.info, info));
	}

	/**
	 * Sets the warning message.
	 * 
	 * @param warning
	 *            the new warning message
	 */
	public static void setWarningMessage(String warning) {
		put(MESSAGE_KEY, new Message(MessageType.warning, warning));
	}

	/**
	 * Sets the error message.
	 * 
	 * @param error
	 *            the new error message
	 */
	public static void setErrorMessage(String error) {
		put(MESSAGE_KEY, new Message(MessageType.error, error));
	}

	/**
	 * Sets the success message.
	 * 
	 * @param success
	 *            the new success message
	 */
	public static void setSuccessMessage(String success) {
		put(MESSAGE_KEY, new Message(MessageType.success, success));
	}

	/**
	 * Gets the request.
	 * 
	 * @param requestAttributes
	 *            the request attributes
	 * @return the request
	 */
	private static HttpServletRequest getRequest(RequestAttributes requestAttributes) {
		return ((ServletRequestAttributes) requestAttributes).getRequest();
	}

	/** The Constant MESSAGE_KEY. */
	private static final String MESSAGE_KEY = "message";

	/**
	 * The Class Message.
	 */
	public static final class Message {

		/** The type. */
		private final MessageType type;

		/** The text. */
		private final String text;

		/**
		 * Instantiates a new message.
		 * 
		 * @param type
		 *            the type
		 * @param text
		 *            the text
		 */
		public Message(MessageType type, String text) {
			this.type = type;
			this.text = text;
		}

		/**
		 * Gets the type.
		 * 
		 * @return the type
		 */
		public MessageType getType() {
			return type;
		}

		/**
		 * Gets the text.
		 * 
		 * @return the text
		 */
		public String getText() {
			return text;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return type + ": " + text;
		}

	}

	/**
	 * The Enum MessageType.
	 */
	public static enum MessageType {

		/** The info. */
		info,
		/** The success. */
		success,
		/** The warning. */
		warning,
		/** The error. */
		error
	}

}
