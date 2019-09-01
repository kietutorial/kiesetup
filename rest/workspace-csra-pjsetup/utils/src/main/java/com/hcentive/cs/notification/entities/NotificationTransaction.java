package com.hcentive.cs.notification.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.envers.Audited;

import com.hcentive.utils.orm.model.Persistent;

@Audited
@Entity
@Table(name = "CS_NOTIFICATION_TRANSACTION")
@NamedQueries(value = { 
		@NamedQuery(name = "cnt.getAllTransactionsbyDay", query = "select n from NotificationTransaction n where bncStatus = '0' or bncStatus is null"), 
		@NamedQuery(name = "cnt.getResentNotifications", query = "select n from NotificationTransaction n where prevCsNotificationId = :notificationId ORDER BY n.reqSentDate DESC FETCH FIRST 1 ROWS ONLY"),
		@NamedQuery(name = "cnt.getResentNotificationsByTrackingID", query = "select n from NotificationTransaction n where n.appealTrackingId = :trackingId and n.status in ('I','S','F') ORDER BY n.reqSentDate DESC"),
		@NamedQuery(name = "cnt.getResentNotificationByTrackingID", query = "select n from NotificationTransaction n where n.appealTrackingId = :trackingId ")
		})
public class NotificationTransaction extends Persistent {

	private static final long serialVersionUID = -6066105331537671605L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CS_NOTIFY_ID")
	private Long notificationMasterId;

	@Column(name = "APPEAL_TRACKING_ID")
	private String appealTrackingId;

	@Column(name = "DCN")
	private String dcn;

	@Column(name = "STATUS")
	private String status = "I";

	@Column(name = "NOTIFICATION_REQ_SENT_DATE")
	private Date reqSentDate;

	@Column(name = "NOTIFICATION_RES_RCVD_DATE")
	private Date resRcvdDate;

	@Column(name = "NOTIFICATION_FAILED_RES_TXT")
	private String failedResTxt;

	@Column(name = "PREV_CS_NOTIFICATION_ID")
	private Long prevCsNotificationId;

	@Column(name = "PREV_CS_NOTIFICATION_STATUS_CD")
	private String prevCsNotificationStatus;

	@Column(name = "RESENT_COUNT_NUM")
	private Long resentCount = 0L;
	
	@Column(name = "CS_NOTIFICATION_BNC_STATUS_CD")
	private String bncStatus = "0";

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CS_NOTIFY_ID", insertable = false, updatable = false)
	@Valid
	private NotificationMaster notificationMaster;

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "notificationTransaction",orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.TRUE)
	private CSNotificationPayload csNotificationPayload;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppealTrackingId() {
		return appealTrackingId;
	}

	public void setAppealTrackingId(String appealTrackingId) {
		this.appealTrackingId = appealTrackingId;
	}

	public String getDcn() {
		return dcn;
	}

	public void setDcn(String dcn) {
		this.dcn = dcn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getNotificationMasterId() {
		return notificationMasterId;
	}

	public void setNotificationMasterId(Long notificationMasterId) {
		this.notificationMasterId = notificationMasterId;
	}

	public Date getReqSentDate() {
		return reqSentDate;
	}

	public void setReqSentDate(Date reqSentDate) {
		this.reqSentDate = reqSentDate;
	}

	public Date getResRcvdDate() {
		return resRcvdDate;
	}

	public void setResRcvdDate(Date resRcvdDate) {
		this.resRcvdDate = resRcvdDate;
	}

	public String getFailedResTxt() {
		return failedResTxt;
	}

	public void setFailedResTxt(String failedResTxt) {
		this.failedResTxt = failedResTxt;
	}

	public Long getPrevCsNotificationId() {
		return prevCsNotificationId;
	}

	public void setPrevCsNotificationId(Long prevCsNotificationId) {
		this.prevCsNotificationId = prevCsNotificationId;
	}

	public String getPrevCsNotificationStatus() {
		return prevCsNotificationStatus;
	}

	public void setPrevCsNotificationStatus(String prevCsNotificationStatus) {
		this.prevCsNotificationStatus = prevCsNotificationStatus;
	}

	public Long getResentCount() {
		return resentCount;
	}

	public void setResentCount(Long resentCount) {
		this.resentCount = resentCount;
	}

	public String getBncStatus() {
		return bncStatus;
	}

	public void setBncStatus(String bncStatus) {
		this.bncStatus = bncStatus;
	}

	public NotificationMaster getNotificationMaster() {
		return notificationMaster;
	}

	public void setNotificationMaster(NotificationMaster notificationMaster) {
		this.notificationMaster = notificationMaster;
	}

	public CSNotificationPayload getCsNotificationPayload() {
		return csNotificationPayload;
	}

	public void setCsNotificationPayload(CSNotificationPayload csNotificationPayload) {
		this.csNotificationPayload = csNotificationPayload;
	}
}
