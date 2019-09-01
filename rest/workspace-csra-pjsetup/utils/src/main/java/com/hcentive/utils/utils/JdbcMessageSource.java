/*
 * Copyright 2002-2004 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hcentive.utils.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * Reading of messages using data in databases. It must be provided with a
 * datasource and sql code which must be passed 2 jdbc parameters which will be
 * respectively filled with the code and the string representation of the
 * locale. <BR>
 * TODO: check that synchronization isn't needed on the cache part
 * 
 * @author Prajot
 */
public class JdbcMessageSource extends AbstractMessageSource implements InitializingBean {

	private JdbcTemplate jdbcTemplate;

	private String sqlStatement;

	private Map<String, MessageFormat> cachedMessages = new ConcurrentHashMap<String, MessageFormat>();

	private String cacheQuery;

	private static String defaultCountry = "US";

	private String languageColumn;

	private String countryColumn;

	private String messageKey;

	private String messageValue;
	
	private static Logger logger = LoggerFactory.getLogger(JdbcMessageSource.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.support.AbstractMessageSource#resolveCode
	 * (java.lang.String, java.util.Locale)
	 */
	@Override
	public MessageFormat resolveCode(String code, Locale locale) {
		MessageFormat result = null;
		String cacheKey = generateCacheKey(code, locale.getLanguage(), locale.getCountry());

		if ((result = cachedMessages.get(cacheKey)) == null) {
			result = resolveCodeInternal(code, locale);
			if (result != null) {
				cachedMessages.put(cacheKey, result);
			}
		} else {
			result = cachedMessages.get(cacheKey);
		}
		return result;
	}

	/**
	 * Check in base the message associated with the given code and locale
	 * 
	 * @param code
	 *            the code of the message to solve
	 * @param locale
	 *            the locale to check against
	 * @return a MessageFormat if one were found, either for the given locale or
	 *         for the default on, or null if nothing could be found
	 */
	public MessageFormat resolveCodeInternal(String code, Locale locale) {
		String result;

		try {
			result = jdbcTemplate.queryForObject(sqlStatement, new Object[] { code, locale.getLanguage(), getCountry(locale) },
					String.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			logger.error("EXCEPTION", e);
			return null;
		}

		return new MessageFormat(result, locale);
	}

	/**
	 * @param jdbcTemplate
	 *            The jdbcTemplate to set.
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @param sqlStatement
	 *            The sqlStatement to set.
	 */
	public void setSqlStatement(String sqlStatement) {
		this.sqlStatement = sqlStatement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		if (sqlStatement == null) {
			throw new BeanInitializationException("Sql statement should be filled");
		}

		if (jdbcTemplate == null) {
			throw new BeanInitializationException("Jdbc template should be filled");
		}

		if (cacheQuery == null) {
			throw new BeanInitializationException("cacheQuery should be filled");
		}

		if (messageKey == null) {
			throw new BeanInitializationException("messageKey should be filled");
		}

		if (messageValue == null) {
			throw new BeanInitializationException("messageValue should be filled");
		}

		if (languageColumn == null) {
			throw new BeanInitializationException("languageColumn should be filled");
		}

		if (countryColumn == null) {
			throw new BeanInitializationException("countryColumn should be filled");
		}

		loadMessages();

	}

	/**
	 * Empty the cache so that all future message resolving request ends in
	 * database queries
	 */
	public void clearCache() {
		cachedMessages.clear();
	}

	/**
	 * This is a custom solution...It loads messages into cache on application
	 * start-up...Can be modified and improved further--Prajot
	 **/
	protected void loadMessages() {
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(cacheQuery);
		while (rowSet.next()) {

			String key = generateCacheKey(rowSet.getString(messageKey), rowSet.getString(languageColumn),
					rowSet.getString(countryColumn));
			Locale locale = new Locale(rowSet.getString(languageColumn), rowSet.getString(countryColumn));
			cachedMessages.put(key, new MessageFormat(rowSet.getString(messageValue), locale));

		}

	}

	private String generateCacheKey(String messageKey, String language, String country) {
		String delimiter = "_";
		// TODO KeyGenerators can be used here
		StringBuilder key = new StringBuilder();
		key.append(messageKey);
		key.append(delimiter);
		key.append(language);
		key.append(delimiter);
		key.append(StringUtils.isBlank(country) ? defaultCountry : country);
		return key.toString();
	}

	private String getCountry(Locale locale) {
		return StringUtils.isBlank(locale.getCountry()) ? defaultCountry : locale.getCountry();
	}

	public String getCacheQuery() {
		return cacheQuery;
	}

	public void setCacheQuery(String cacheQuery) {
		this.cacheQuery = cacheQuery;
	}

	public String getLanguageColumn() {
		return languageColumn;
	}

	public void setLanguageColumn(String languageColumn) {
		this.languageColumn = languageColumn;
	}

	public String getCountryColumn() {
		return countryColumn;
	}

	public void setCountryColumn(String countryColumn) {
		this.countryColumn = countryColumn;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getMessageValue() {
		return messageValue;
	}

	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}
}
