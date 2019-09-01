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
@Table(name = "ELG_MEMBER_CBIC_ERROR") 
	
public class CBICError implements Serializable { 
 

		public CBICError(Long elgmembercbicid, String cinidentifier,
			String errormsg, int reprocessedflag, String errorcd,
			String createdby, Timestamp createddate ) {
		super();
		this.elgmembercbicid = elgmembercbicid;
		this.cinidentifier = cinidentifier;
		this.errormsg = errormsg;
		this.reprocessedflag = reprocessedflag;
		this.errorcd = errorcd;
		this.createdby = createdby;
		this.createddate = createddate;
	}

		public CBICError(){};
		/**
	 * 
	 */
	private static final long serialVersionUID = 3397781479403394130L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@Column(name = "ELG_MEMBER_CBIC_ID")
		private Long elgmembercbicid;
		
		@Column(name = "CIN_IDENTIFIER")
		private String cinidentifier;
		
		@Column(name = "ERROR_MSG")
		private String errormsg;
		
		@Column(name = "REPROCESSED_FLAG")
		private int reprocessedflag;
		
		@Column(name = "ERROR_CD" ,columnDefinition="char")
		private String errorcd;
		
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

		public Long getElgmembercbicid() {
			return elgmembercbicid;
		}

		public void setElgmembercbicid(Long elgmembercbicid) {
			this.elgmembercbicid = elgmembercbicid;
		}

		public String getCinidentifier() {
			return cinidentifier;
		}

		public void setCinidentifier(String cinidentifier) {
			this.cinidentifier = cinidentifier;
		}

		public String getErrormsg() {
			return errormsg;
		}

		public void setErrormsg(String errormsg) {
			this.errormsg = errormsg;
		}

		public int getReprocessedflag() {
			return reprocessedflag;
		}

		public void setReprocessedflag(int reprocessedflag) {
			this.reprocessedflag = reprocessedflag;
		}

		public String getErrorcd() {
			return errorcd;
		}

		public void setErrorcd(String errorcd) {
			this.errorcd = errorcd;
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
