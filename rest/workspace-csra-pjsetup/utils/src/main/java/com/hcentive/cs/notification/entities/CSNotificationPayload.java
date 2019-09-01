package com.hcentive.cs.notification.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import com.hcentive.utils.orm.model.Persistent;

@Audited
@Entity
@Table(name = "CS_NOTIFICATION_PAYLOAD")
public class CSNotificationPayload extends Persistent {

	private static final long serialVersionUID = 3888330622734875204L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;

	@Column(name = "REQ_PAYLOAD_TXT")
	private String requestXML;

	@ManyToOne(cascade = { CascadeType.ALL})
	@JoinColumn(name = "CS_NOTIFICATION_TRANSACTION_ID")
	private NotificationTransaction notificationTransaction;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestXML() {
		return requestXML;
	}

	public void setRequestXML(String requestXML) {
		this.requestXML = requestXML;
	}

	public NotificationTransaction getNotificationTransaction() {
		return notificationTransaction;
	}

	public void setNotificationTransaction(NotificationTransaction notificationTransaction) {
		this.notificationTransaction = notificationTransaction;
	}
}
