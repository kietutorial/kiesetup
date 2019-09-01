package com.hcentive.cs.notification.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.hcentive.utils.orm.model.Persistent;

@Audited
@Entity
@Table(name = "CS_NOTIFICATION_MASTER")
@NamedQueries(value = {
		@NamedQuery(name = "notificationMaster.findIdBynotificationType", query = "SELECT nms from  NotificationMaster nms WHERE nms.notificationType = :notificationType"),
		@NamedQuery(name = "notificationMaster.getAllNotificationTypes", query = "SELECT nms from  NotificationMaster nms"),
		@NamedQuery(name = "notificationMaster.findNotificationTypeById", query = "SELECT nms.notificationType from  NotificationMaster nms WHERE nms.id= :notificationMasterId")
        })
public class NotificationMaster extends Persistent {

	private static final long serialVersionUID = 6854409570830307263L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NOTIFICATION_TYPE")
	private String notificationType;

	@Column(name = "ENTITY")
	private String entity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

}
