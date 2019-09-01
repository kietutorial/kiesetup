package com.hcentive.msgcenter.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.hcentive.utils.orm.model.Persistent;

@Entity
@Table(name = "message_center_mock")
@NamedQueries(value = {
		@NamedQuery(name = "msgcenter.findById", query = "SELECT a from MessageCenter a WHERE a.id=:id"),
		@NamedQuery(name = "msgcenter.updateMessagesArchivedByUser", query = "UPDATE MessageCenter a SET a.isArchived=:isArchived WHERE a.userProfileId=:userProfileId AND a.id IN :id"),
		@NamedQuery(name = "msgcenter.updateMessagesReadByUser", query = "UPDATE MessageCenter a SET a.isRead=:isRead WHERE a.userProfileId=:userProfileId AND a.id IN :id"),
		@NamedQuery(name = "msgcenter.fetchAllMessagesByUser", query = "SELECT a from MessageCenter a WHERE a.userProfileId=:userProfileId"),
		@NamedQuery(name = "msgcenter.fetchArchivedMessagesByUser", query = "SELECT a from MessageCenter a WHERE a.userProfileId=:userProfileId AND a.isArchived=true"),
		@NamedQuery(name = "msgcenter.fetchMessagesByUser", query = "SELECT a from MessageCenter a WHERE a.userProfileId=:userProfileId AND a.isArchived=false"),
		@NamedQuery(name = "msgcenter.countMessagesByUser", query = "SELECT COUNT(a) from MessageCenter a WHERE a.userProfileId=:userProfileId AND a.isArchived=false"),
		@NamedQuery(name = "msgcenter.getMessagesByType", query = "SELECT a from MessageCenter a WHERE a.userProfileId=:userProfileId AND a.isRead=:isRead") })
public class MessageCenter extends Persistent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "user_profile_id")
	private Long userProfileId;

	@Column(name = "type")
	private String type;

	@Column(name = "subject")
	private String subject;

	@Column(name = "content", length = 2000)
	private String content;

	@Column(name = "is_read")
	private boolean isRead = false;

	@Column(name = "is_archived")
	private boolean isArchived = false;

	@Column(name = "sender")
	private String sender;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
