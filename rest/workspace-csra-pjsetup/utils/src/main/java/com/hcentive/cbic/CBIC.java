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
@Table(name = "ELG_MEMBER_CBIC") 
	
public class CBIC implements Serializable { 
	
		public CBIC(String reqcinidentifier,
			String reqcasenumberidentifier, String statuscd,
			Timestamp requestprocesstimestamp,String servicerequest, String createdby,
			Timestamp createddate) {
		super();
		this.reqcinidentifier = reqcinidentifier;
		this.reqcasenumberidentifier = reqcasenumberidentifier;
		this.statuscd = statuscd;
		this.requestprocesstimestamp = requestprocesstimestamp;
		this.servicerequest = servicerequest;
		this.createdby = createdby;
		this.createddate = createddate;
	}

		public CBIC(){};
		/**
	 * 
	 */
	private static final long serialVersionUID = 753176852751127641L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@Column(name = "REQ_CIN_IDENTIFIER")
		private String reqcinidentifier;
		
		@Column(name = "REQ_CASE_NUMBER_IDENTIFIER")
		private String reqcasenumberidentifier;
		
		@Column(name = "STATUS_CD")
		private String statuscd;
		
		@Column(name = "RES_CARD_REQUEST_INDICATOR")
		private int rescardrequestindicator;
		
		@Column(name = "REQUEST_PROCESS_TIMESTAMP")
		private Timestamp requestprocesstimestamp;
		
		@Column(name = "RES_STATUS_MESSAGE")
		private String resstatusmessage;
		
		@Column(name = "RES_CARD_NUMBER_IDENTIFIER")
		private String rescardnumberidentifier;
		
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

		public String getReqcinidentifier() {
			return reqcinidentifier;
		}

		public void setReqcinidentifier(String reqcinidentifier) {
			this.reqcinidentifier = reqcinidentifier;
		}

		public String getReqcasenumberidentifier() {
			return reqcasenumberidentifier;
		}

		public void setReqcasenumberidentifier(String reqcasenumberidentifier) {
			this.reqcasenumberidentifier = reqcasenumberidentifier;
		}

		public String getStatuscd() {
			return statuscd;
		}

		public void setStatuscd(String statuscd) {
			this.statuscd = statuscd;
		}

		public int getRescardrequestindicator() {
			return rescardrequestindicator;
		}

		public void setRescardrequestindicator(int rescardrequestindicator) {
			this.rescardrequestindicator = rescardrequestindicator;
		}

		public Timestamp getRequestprocesstimestamp() {
			return requestprocesstimestamp;
		}

		public void setRequestprocesstimestamp(Timestamp requestprocesstimestamp) {
			this.requestprocesstimestamp = requestprocesstimestamp;
		}

		public String getResstatusmessage() {
			return resstatusmessage;
		}

		public void setResstatusmessage(String resstatusmessage) {
			this.resstatusmessage = resstatusmessage;
		}

		public String getRescardnumberidentifier() {
			return rescardnumberidentifier;
		}

		public void setRescardnumberidentifier(String rescardnumberidentifier) {
			this.rescardnumberidentifier = rescardnumberidentifier;
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
