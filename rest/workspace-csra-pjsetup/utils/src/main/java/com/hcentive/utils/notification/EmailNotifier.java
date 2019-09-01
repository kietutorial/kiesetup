/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.notification;

import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;

import com.hcentive.utils.notification.domain.AuditMailLog;
import com.hcentive.utils.orm.dao.GenericDAO;

public class EmailNotifier extends AbstractNotifier {

	/** The LOGGER. */
	private static Logger LOGGER = LoggerFactory.getLogger(EmailNotifier.class);

	/** The Constant EMAIL_BODY. */
	private static final String EMAIL_BODY = "email_body";

	/** The Constant EMAIL_SUBJECT. */
	private static final String EMAIL_SUBJECT = "email_subject";

	private static final String REFERENCE_ID = "reference_id";

	private static final String REFERENCE_TABLE_NAME = "reference_table_name";

	/** The bcc emails. */
	protected String[] bccEmails;

	/** The event bcc emails. */
	protected Map<String, String[]> eventBccEmails;

	/** The mail sender. */
	protected JavaMailSender mailSender;

	/** The from email id. */
	protected String fromEmailId;

	/** The from name. */
	protected String fromName;

	/** The reply to email id. */
	protected String replyToEmailId;

	/** The reply to name. */
	protected String replyToName;

	/** The generic Dao. */
	@SuppressWarnings("rawtypes")
	private GenericDAO genericDao;

	private JpaTransactionManager txManager;

	public void setTxManager(JpaTransactionManager txManager) {
		this.txManager = txManager;
	}

	/**
	 * Instantiates a new email notifier.
	 * 
	 * @param mailSender
	 *            the mail sender
	 */
	public EmailNotifier(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/*******
	 * default constructor
	 */
	public EmailNotifier() {
	}

	/**
	 * Notify.
	 * 
	 * @param event
	 *            the event
	 * @param message
	 *            the message
	 */
	@Override
	@Transactional(readOnly = false)
	public void notify(String event, Message message) {
		EmailMessage emailMessage = (EmailMessage) message;
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Sending notification for event :" + event);
		}
		String subject = emailMessage.getSubject();
		String body = emailMessage.getBody();
		Map<String, Object> data = processEmailData(event, message.getData());
		try {
			if (StringUtils.isEmpty(subject)) {
				subject = renderContent(event, EMAIL_SUBJECT, data);
			}
			if (StringUtils.isEmpty(body)) {
				body = renderContent(event, EMAIL_BODY, data);
			}

			Long refernceId = (Long) data.get(REFERENCE_ID);
			String refernceTableName = (String) data.get(REFERENCE_TABLE_NAME);
			sendEmail(emailMessage.getToEmails(), subject, body, getEventBccEmails(event), emailMessage,
					emailMessage.getAttachments(), event, refernceId, refernceTableName);
		} catch (Exception e) {
			LOGGER.error("Error sending mail for Event '" + event + "'", e);
		}
	}

	/**
	 * Process email data.
	 * 
	 * @param event
	 *            the event
	 * @param params
	 *            the params
	 * @return the map
	 */
	protected Map<String, Object> processEmailData(String event, Map<String, Object> params) {
		return params;
	}

	/**
	 * Send email.
	 * 
	 * @param to
	 *            the to
	 * @param subject
	 *            the subject
	 * @param body
	 *            the body
	 * @param eventBccEmails
	 *            the event bcc emails
	 * @param em
	 *            the em
	 * @param event
	 *            the event
	 * @param refernceTableName
	 * @param refernceId
	 * @throws MailException
	 *             the mail exception
	 */
	@Transactional(readOnly = false)
	protected void sendEmail(final String[] to, final String subject, final String body, final String[] eventBccEmails,
			final EmailMessage em, final Map<String, InputStream> attachments, final String event, final Long refernceId,
			final String refernceTableName) throws MailException {

	 LOGGER.warn("Should not use this email method. Deprecated and emails will not be sent");

	}

	/**
	 * Audit mail.
	 * 
	 * @param to
	 *            the to
	 * @param allCCAndBcc
	 *            the all cc and bcc
	 * @param subject
	 *            the subject
	 * @param body
	 *            the body
	 * @param attachments
	 * @param date
	 *            the date
	 * @param success
	 *            the success
	 * @param error
	 *            the error
	 * @param event
	 *            the event
	 * @param refernceTableName
	 * @param refernceId
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	private void auditMail(String[] to, String allCCAndBcc, String subject, String body, Map<String, InputStream> attachments,
			Date date, int success, String error, String event, Long referenceId, String referenceTableName) {
		// Map<String, Object> paramsMap = new HashMap<String, Object>();

		String toString = "";
		if (to != null) {
			for (String to1 : to) {
				if (toString.length() == 0) {
					toString = to1;
				} else {
					toString = toString + "," + to1;
				}
			}
		}
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		// explicitly setting the transaction name is something that can only be
		// done programmatically
		def.setName("txManager");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = txManager.getTransaction(def);

		AuditMailLog auditMailLog = new AuditMailLog();
		auditMailLog.setMailTo(toString);
		auditMailLog.setMailCc(allCCAndBcc);
		auditMailLog.setSubject(subject);
		auditMailLog.setMailBody(body);
		// auditMailLog.setTime(date);
		auditMailLog.setSuccessFlag(success);
		auditMailLog.setErrorMessage(error);
		auditMailLog.setEvent(event);
		auditMailLog.setReferenceId(referenceId);
		auditMailLog.setReferenceTableName(referenceTableName);
		auditMailLog = (AuditMailLog) genericDao.create(auditMailLog);

		txManager.commit(status);
	}

	/**
	 * Gets the event bcc emails.
	 * 
	 * @param event
	 *            the event
	 * @return the event bcc emails
	 */
	private String[] getEventBccEmails(String event) {
		if (eventBccEmails == null) {
			return null;
		}
		return eventBccEmails.get(event);
	}

	/**
	 * Sets the from email id.
	 * 
	 * @param fromEmailId
	 *            the new from email id
	 */
	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}

	/**
	 * Gets the bcc emails.
	 * 
	 * @return the bcc emails
	 */
	public String[] getBccEmails() {
		return bccEmails;
	}

	/**
	 * Sets the bcc emails.
	 * 
	 * @param bccEmails
	 *            the new bcc emails
	 */
	public void setBccEmails(String[] bccEmails) {
		Assert.noNullElements(bccEmails, "Default bcc-Email Address cannot be null or empty");
		this.bccEmails = bccEmails;
	}

	/**
	 * Gets the event bcc emails.
	 * 
	 * @return the event bcc emails
	 */
	public Map<String, String[]> getEventBccEmails() {
		return eventBccEmails;
	}

	/**
	 * Sets the event bcc emails.
	 * 
	 * @param eventBccEmails
	 *            the event bcc emails
	 */
	public void setEventBccEmails(Map<String, String[]> eventBccEmails) {
		Assert.notEmpty(eventBccEmails, "event bcc-email Address map cannnot be empty");
		this.eventBccEmails = eventBccEmails;
	}

	/**
	 * Sets the reply to email id.
	 * 
	 * @param replyToEmailId
	 *            the new reply to email id
	 */
	public void setReplyToEmailId(String replyToEmailId) {
		this.replyToEmailId = replyToEmailId;
	}

	/**
	 * Sets the from name.
	 * 
	 * @param fromName
	 *            the new from name
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	/**
	 * Sets the reply to name.
	 * 
	 * @param replyToName
	 *            the new reply to name
	 */
	public void setReplyToName(String replyToName) {
		this.replyToName = replyToName;
	}

	@SuppressWarnings("rawtypes")
	public GenericDAO getGenericDao() {
		return genericDao;
	}

	@SuppressWarnings("rawtypes")
	public void setGenericDao(GenericDAO genericDao) {
		this.genericDao = genericDao;
	}
}
