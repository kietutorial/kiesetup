package com.hcentive.cbic;
 
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
import javax.persistence.Table;

import java.io.Serializable;
import org.hibernate.envers.Audited;
import com.hcentive.utils.orm.model.Persistent;

@Audited
@Entity
@Table(name = "ELG_MEMBER_CBIC_RESPONSE") 
	
public class CBICTransaction implements Serializable { 
		/**
	 * 
	 */
	  private static final long serialVersionUID = 6854409570830307263L;
 
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@Column(name = "CIN_IDENTIFIER")
		private String cinidentifier;
		
		@Column(name = "CASE_NUMBER_IDENTIFIER")
		private String casenumberidentifier;
		
		@Column(name = "CARD_REQUEST_INDICATOR")
		private int cardrequestindicator;
		
		@Column(name = "REQUEST_PROCESS_TIMESTAMP")
		private Timestamp requestprocesstimestamp;
		
		@Column(name = "STATUS_MESSAGE")
		private String statusmessage;
		
		@Column(name = "CARD_NUMBER_IDENTIFIER")
		private String cardnumberidentifier;
		
		@Column(name = "SERVICE_REQUEST")
		private String servicerequest;
		
		@Column(name = "SERVICE_RESPONSE")
		private String serviceresponse;
		
		@Column(name = "CREATED_BY")
		private String createdby;
		
		@Column(name = "CREATED_DATE")
		private Timestamp createddate;
		
		@Column(name = "UPDATED_BY")
		private String updateby;
		
		@Column(name = "UPDATED_DATE")
		private Timestamp updateddate;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCinidentifier() {
			return cinidentifier;
		}

		public void setCinidentifier(String cinidentifier) {
			this.cinidentifier = cinidentifier;
		}

		public String getCasenumberidentifier() {
			return casenumberidentifier;
		}

		public void setCasenumberidentifier(String casenumberidentifier) {
			this.casenumberidentifier = casenumberidentifier;
		}

		public int getCardrequestindicator() {
			return cardrequestindicator;
		}

		public void setCardrequestindicator(int cardrequestindicator) {
			this.cardrequestindicator = cardrequestindicator;
		}

		public Timestamp getRequestprocesstimestamp() {
			return requestprocesstimestamp;
		}

		public void setRequestprocesstimestamp(Timestamp requestprocesstimestamp) {
			this.requestprocesstimestamp = requestprocesstimestamp;
		}

		public String getStatusmessage() {
			return statusmessage;
		}

		public void setStatusmessage(String statusmessage) {
			this.statusmessage = statusmessage;
		}

		public String getCardnumberidentifier() {
			return cardnumberidentifier;
		}

		public void setCardnumberidentifier(String cardnumberidentifier) {
			this.cardnumberidentifier = cardnumberidentifier;
		}

		public String getServicerequest() {
			return servicerequest;
		}

		public void setServicerequest(String servicerequest) {
			this.servicerequest = servicerequest;
		}

		public String getServiceresponse() {
			return serviceresponse;
		}

		public void setServiceresponse(String serviceresponse) {
			this.serviceresponse = serviceresponse;
		}

		public String getCreatedby() {
			return createdby;
		}

		public void setCreatedby(String createdby) {
			this.createdby = createdby;
		}

		public Timestamp getCreateddate() {
			return createddate;
		}

		public void setCreateddate(Timestamp createddate) {
			this.createddate = createddate;
		}

		public String getUpdateby() {
			return updateby;
		}

		public void setUpdateby(String updateby) {
			this.updateby = updateby;
		}

		public Timestamp getUpdateddate() {
			return updateddate;
		}

		public void setUpdateddate(Timestamp updateddate) {
			this.updateddate = updateddate;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
