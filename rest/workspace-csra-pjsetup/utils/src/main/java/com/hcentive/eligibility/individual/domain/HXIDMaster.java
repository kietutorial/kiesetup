package com.hcentive.eligibility.individual.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

import com.hcentive.utils.orm.model.Persistent;

@Audited
@Entity
@Table(name = "hxid_master")
@NamedNativeQueries(value = {
		@NamedNativeQuery(
				name = "hxidmaster.getbylastfirstnamesuffixdobsex",
				query = "SELECT * from  hxid_master HM WHERE " +
						"((lower(HM.first_name)=lower(:firstName) and :exactMatchFN ='1') or (lower(HM.first_name) like lower(:firstName) and :exactMatchFN ='0'))" + 
						" and ((lower(HM.last_name)=lower(:lastName) and :exactMatchLN ='1') or (lower(HM.last_name) like lower(:lastName) and :exactMatchLN ='0'))" +
						" and gender=:gender and DATE_OF_BIRTH=:dob" +
						" with UR",
				resultClass = HXIDMaster.class
			),
		@NamedNativeQuery(
					name = "hxidmaster.getbyssnlastnamepartialdob",
					query = "SELECT * from  hxid_master HM WHERE "
					+ " ((lower(HM.last_name)=lower(:lastName) and :exactMatchLN ='1') or (lower(HM.last_name) like lower(:lastName) and :exactMatchLN ='0')) "
					+ " and DATE_OF_BIRTH between :startDateOfMonth and :lastDateOfMonth and ssn=:ssn" +
				  " with UR",
					resultClass = HXIDMaster.class
				),
		@NamedNativeQuery(
				name = "hxidmaster.getbyallattributes", query = "SELECT * from hxid_master HM WHERE "
						+ "(lower(HM.first_name)=lower(:firstName) and :exactMatchFN ='1' or lower(HM.first_name) like lower(:firstName) and :exactMatchFN ='0') "
						+ " and (lower(HM.last_name)=lower(:lastName) and :exactMatchLN ='1' or lower(HM.last_name) like lower(:lastName) and :exactMatchLN ='0')"
						+ " and HM.gender=:gender  and HM.ssn=:ssn and  HM.DATE_OF_BIRTH=:dob with UR",
					resultClass = HXIDMaster.class
				),
		@NamedNativeQuery(
				name = "hxidmaster.getbyssnlastnamefirstname", query = "SELECT * from  hxid_master HM WHERE "
						+ "((lower(HM.first_name)=lower(:firstName) and :exactMatchFN ='1') or (lower(HM.first_name) like lower(:firstName) and :exactMatchFN ='0')) "
						+ " and ((lower(HM.last_name)=lower(:lastName) and :exactMatchLN ='1') or (lower(HM.last_name) like lower(:lastName) and :exactMatchLN ='0'))"
						+ " and ssn=:ssn with UR",
					resultClass = HXIDMaster.class
				),
		@NamedNativeQuery(
				name = "hxidmaster.getbyssndob", query = "SELECT * from  hxid_master HM WHERE DATE_OF_BIRTH=:dob and ssn=:ssn with UR",
					resultClass = HXIDMaster.class
				),
		@NamedNativeQuery(
				name = "hxidmaster.getbyssn", query = "SELECT * from  hxid_master HM WHERE ssn=:ssn with UR",
					resultClass = HXIDMaster.class
				),		
		@NamedNativeQuery(
				name = "hxidmaster.getbyssndobfullname", query = "SELECT * from  hxid_master HM WHERE HM.ssn=:ssn and to_char(HM.DATE_OF_BIRTH,'MMYYYY') =to_char(to_date(:dob,'yyyy-mm-dd'),'MMYYYY') and " +
						" lower(HM.first_name)=lower(:firstName) and lower(HM.last_name)=lower(:lastName) " +
						" with UR",
					resultClass = HXIDMaster.class
				),
		@NamedNativeQuery(name = "hxidmaster.getbyssndobtruncatedfullname", query = "SELECT * from  hxid_master HM WHERE HM.ssn=:ssn and  to_char(HM.DATE_OF_BIRTH,'MMYYYY') =to_char(to_date(:dob,'yyyy-mm-dd'),'MMYYYY') and "
				+ " lower(substr(HM.first_name,1,4))=lower(:firstName) and lower(substr(HM.last_name,1,6))=lower(:lastName) "
				+ " with UR", resultClass = HXIDMaster.class),

		@NamedNativeQuery(name = "hxidmaster.getbyssndobtruncatedfirstname", query = "SELECT * from  hxid_master HM WHERE HM.ssn=:ssn and to_char(HM.DATE_OF_BIRTH,'MMYYYY') =to_char(to_date(:dob,'yyyy-mm-dd'),'MMYYYY') and "
				+ " lower(substr(HM.first_name,1,4))=lower(:firstName) and lower(HM.last_name)=lower(:lastName) "
				+ " with UR", resultClass = HXIDMaster.class),
		@NamedNativeQuery(name = "hxidmaster.getbyssndobtruncatedlastname", query = "SELECT * from  hxid_master HM WHERE HM.ssn=:ssn and to_char(HM.DATE_OF_BIRTH,'MMYYYY') =to_char(to_date(:dob,'yyyy-mm-dd'),'MMYYYY') and "
				+ " lower(HM.first_name)=lower(:firstName) and lower(substr(HM.last_name,1,6))=lower(:lastName) "
				+ " with UR", resultClass = HXIDMaster.class),
		@NamedNativeQuery(name = "hxidmaster.getbyssndobGender", query = "SELECT * from  hxid_master HM WHERE to_char(HM.DATE_OF_BIRTH,'MMYYYY') =to_char(to_date(:dob,'yyyy-mm-dd'),'MMYYYY') and ssn=:ssn and GENDER=:gender with UR", resultClass = HXIDMaster.class)
				
				
})

@NamedQueries(value = {
		/*@NamedQuery(name = "hxidmaster.getbyallattributes", query = "SELECT HM from HXIDMaster HM WHERE "
				+ "(lower(HM.firstName)=lower(:firstName) and :exactMatchFN ='1' or lower(HM.firstName) like lower(:firstName) and :exactMatchFN ='0') "
				+ " and (lower(HM.lastName)=lower(:lastName) and :exactMatchLN ='1' or lower(HM.lastName) like lower(:lastName) and :exactMatchLN ='0')"
				+ " and HM.gender=:gender  and HM.ssn=:ssn and  HM.dob=:dob"),
		@NamedQuery(name = "hxidmaster.getbyssnlastnamefirstname", query = "SELECT HM from  HXIDMaster HM WHERE "
				+ "((lower(HM.firstName)=lower(:firstName) and :exactMatchFN ='1') or (lower(HM.firstName) like lower(:firstName) and :exactMatchFN ='0')) "
				+ " and ((lower(HM.lastName)=lower(:lastName) and :exactMatchLN ='1') or (lower(HM.lastName) like lower(:lastName) and :exactMatchLN ='0'))"
				+ " and ssn=:ssn"),
		@NamedQuery(name = "hxidmaster.getbyssndob", query = "SELECT HM from  HXIDMaster HM WHERE dob=:dob and ssn=:ssn"),
		@NamedQuery(name = "hxidmaster.getbyssnlastnamepartialdob", query = "SELECT HM from  HXIDMaster HM WHERE "
				+ " ((lower(HM.lastName)=lower(:lastName) and :exactMatchLN ='1') or (lower(HM.lastName) like lower(:lastName) and :exactMatchLN ='0')) "
				+ " and dob between :startDateOfMonth and :lastDateOfMonth and ssn=:ssn"),	
		@NamedQuery(name = "hxidmaster.getbylastfirstnamesuffixdobsex", query = "SELECT HM from  HXIDMaster HM WHERE "
				+ " ((lower(HM.firstName)=lower(:firstName) and :exactMatchFN ='1') or (lower(HM.firstName) like lower(:firstName) and :exactMatchFN ='0')) "
				+ " and ((lower(HM.lastName)=lower(:lastName) and :exactMatchLN ='1') or (lower(HM.lastName) like lower(:lastName) and :exactMatchLN ='0'))"
				+ " and gender=:gender and dob=:dob"),*/
		@NamedQuery(name = "hxidmaster.findByhxid", query = "SELECT e from HXIDMaster e where hxid=:hxid ") })

public class HXIDMaster extends Persistent {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "suffix")
	private String suffix;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "DATE_OF_BIRTH")
	private Date dob;

	@Column(name = "hxid")
	private String hxid;

	@Column(name = "ssn")
	private String ssn;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleNameName() {
		return middleName;
	}

	public void setMiddleNameName(String middleNameName) {
		this.middleName = middleNameName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getHxid() {
		return hxid;
	}

	public void setHxid(String hxid) {
		this.hxid = hxid;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

}
