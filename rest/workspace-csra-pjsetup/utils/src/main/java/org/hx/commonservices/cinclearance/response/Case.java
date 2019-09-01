
package org.hx.commonservices.cinclearance.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="caseNumberIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caseTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caseName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pendingSeperateDeterminationCase" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="SNAPIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNAPFromDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SNAPToDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="suffixIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exceptionTrustIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recoupmentIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diversionPaymentIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expeditedFSPaymentIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="archiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="caseNumberReuseFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recertificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalActiveNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lifeLineIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalNumberInCase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clockdownStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "caseNumberIdentifier",
    "caseTypeCode",
    "caseName",
    "pendingSeperateDeterminationCase",
    "snapIndicatorCode",
    "snapFromDate",
    "snapToDate",
    "suffixIdentifier",
    "exceptionTrustIndicatorCode",
    "recoupmentIndicatorCode",
    "diversionPaymentIndicatorCode",
    "expeditedFSPaymentIndicatorCode",
    "archiveDate",
    "caseNumberReuseFlag",
    "recertificationCode",
    "totalActiveNumber",
    "lifeLineIndicatorCode",
    "totalNumberInCase",
    "clockdownStatus"
})
@XmlRootElement(name = "Case")
public class Case {

    protected String caseNumberIdentifier;
    protected String caseTypeCode;
    protected String caseName;
    protected List<String> pendingSeperateDeterminationCase;
    @XmlElement(name = "SNAPIndicatorCode")
    protected String snapIndicatorCode;
    @XmlElement(name = "SNAPFromDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar snapFromDate;
    @XmlElement(name = "SNAPToDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar snapToDate;
    protected String suffixIdentifier;
    protected String exceptionTrustIndicatorCode;
    protected String recoupmentIndicatorCode;
    protected String diversionPaymentIndicatorCode;
    protected String expeditedFSPaymentIndicatorCode;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar archiveDate;
    protected String caseNumberReuseFlag;
    protected String recertificationCode;
    protected String totalActiveNumber;
    protected String lifeLineIndicatorCode;
    protected String totalNumberInCase;
    protected String clockdownStatus;

    /**
     * Gets the value of the caseNumberIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseNumberIdentifier() {
        return caseNumberIdentifier;
    }

    /**
     * Sets the value of the caseNumberIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseNumberIdentifier(String value) {
        this.caseNumberIdentifier = value;
    }

    /**
     * Gets the value of the caseTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseTypeCode() {
        return caseTypeCode;
    }

    /**
     * Sets the value of the caseTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseTypeCode(String value) {
        this.caseTypeCode = value;
    }

    /**
     * Gets the value of the caseName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseName() {
        return caseName;
    }

    /**
     * Sets the value of the caseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseName(String value) {
        this.caseName = value;
    }

    /**
     * Gets the value of the pendingSeperateDeterminationCase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pendingSeperateDeterminationCase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPendingSeperateDeterminationCase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPendingSeperateDeterminationCase() {
        if (pendingSeperateDeterminationCase == null) {
            pendingSeperateDeterminationCase = new ArrayList<String>();
        }
        return this.pendingSeperateDeterminationCase;
    }

    /**
     * Gets the value of the snapIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNAPIndicatorCode() {
        return snapIndicatorCode;
    }

    /**
     * Sets the value of the snapIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNAPIndicatorCode(String value) {
        this.snapIndicatorCode = value;
    }

    /**
     * Gets the value of the snapFromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSNAPFromDate() {
        return snapFromDate;
    }

    /**
     * Sets the value of the snapFromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSNAPFromDate(XMLGregorianCalendar value) {
        this.snapFromDate = value;
    }

    /**
     * Gets the value of the snapToDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSNAPToDate() {
        return snapToDate;
    }

    /**
     * Sets the value of the snapToDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSNAPToDate(XMLGregorianCalendar value) {
        this.snapToDate = value;
    }

    /**
     * Gets the value of the suffixIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuffixIdentifier() {
        return suffixIdentifier;
    }

    /**
     * Sets the value of the suffixIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuffixIdentifier(String value) {
        this.suffixIdentifier = value;
    }

    /**
     * Gets the value of the exceptionTrustIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionTrustIndicatorCode() {
        return exceptionTrustIndicatorCode;
    }

    /**
     * Sets the value of the exceptionTrustIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionTrustIndicatorCode(String value) {
        this.exceptionTrustIndicatorCode = value;
    }

    /**
     * Gets the value of the recoupmentIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecoupmentIndicatorCode() {
        return recoupmentIndicatorCode;
    }

    /**
     * Sets the value of the recoupmentIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecoupmentIndicatorCode(String value) {
        this.recoupmentIndicatorCode = value;
    }

    /**
     * Gets the value of the diversionPaymentIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiversionPaymentIndicatorCode() {
        return diversionPaymentIndicatorCode;
    }

    /**
     * Sets the value of the diversionPaymentIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiversionPaymentIndicatorCode(String value) {
        this.diversionPaymentIndicatorCode = value;
    }

    /**
     * Gets the value of the expeditedFSPaymentIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpeditedFSPaymentIndicatorCode() {
        return expeditedFSPaymentIndicatorCode;
    }

    /**
     * Sets the value of the expeditedFSPaymentIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpeditedFSPaymentIndicatorCode(String value) {
        this.expeditedFSPaymentIndicatorCode = value;
    }

    /**
     * Gets the value of the archiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArchiveDate() {
        return archiveDate;
    }

    /**
     * Sets the value of the archiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArchiveDate(XMLGregorianCalendar value) {
        this.archiveDate = value;
    }

    /**
     * Gets the value of the caseNumberReuseFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseNumberReuseFlag() {
        return caseNumberReuseFlag;
    }

    /**
     * Sets the value of the caseNumberReuseFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseNumberReuseFlag(String value) {
        this.caseNumberReuseFlag = value;
    }

    /**
     * Gets the value of the recertificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecertificationCode() {
        return recertificationCode;
    }

    /**
     * Sets the value of the recertificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecertificationCode(String value) {
        this.recertificationCode = value;
    }

    /**
     * Gets the value of the totalActiveNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalActiveNumber() {
        return totalActiveNumber;
    }

    /**
     * Sets the value of the totalActiveNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalActiveNumber(String value) {
        this.totalActiveNumber = value;
    }

    /**
     * Gets the value of the lifeLineIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLifeLineIndicatorCode() {
        return lifeLineIndicatorCode;
    }

    /**
     * Sets the value of the lifeLineIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLifeLineIndicatorCode(String value) {
        this.lifeLineIndicatorCode = value;
    }

    /**
     * Gets the value of the totalNumberInCase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalNumberInCase() {
        return totalNumberInCase;
    }

    /**
     * Sets the value of the totalNumberInCase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalNumberInCase(String value) {
        this.totalNumberInCase = value;
    }

    /**
     * Gets the value of the clockdownStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClockdownStatus() {
        return clockdownStatus;
    }

    /**
     * Sets the value of the clockdownStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClockdownStatus(String value) {
        this.clockdownStatus = value;
    }

}
