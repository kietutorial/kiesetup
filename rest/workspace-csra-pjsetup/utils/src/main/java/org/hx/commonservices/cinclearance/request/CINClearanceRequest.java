
package org.hx.commonservices.cinclearance.request;

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
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="middleInitial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sexCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="birthDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createCIN" type="{http://org/hx/commonservices/CINClearance/Request/}createCINRef"/>
 *         &lt;element name="requestedHits" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="filterBySSNFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="searchWMSDomain" type="{http://org/hx/commonservices/CINClearance/Request/}searchWMSDomainRef"/>
 *         &lt;element name="searchHXDomain" type="{http://org/hx/commonservices/CINClearance/Request/}searchHXDomainRef"/>
 *         &lt;element name="includeApplicantFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="includeOtherNameFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "firstName",
    "lastName",
    "middleInitial",
    "suffix",
    "sexCode",
    "birthDate",
    "ssn",
    "cin",
    "createCIN",
    "requestedHits",
    "filterBySSNFlag",
    "searchWMSDomain",
    "searchHXDomain",
    "includeApplicantFlag",
    "includeOtherNameFlag"
})
@XmlRootElement(name = "CINClearanceRequest")
public class CINClearanceRequest {

    protected String firstName;
    protected String lastName;
    protected String middleInitial;
    protected String suffix;
    protected String sexCode;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDate;
    @XmlElement(name = "SSN")
    protected String ssn;
    @XmlElement(name = "CIN")
    protected String cin;
    @XmlElement(required = true, defaultValue = "NONE")
    protected CreateCINRef createCIN;
    protected Integer requestedHits;
    protected String filterBySSNFlag;
    @XmlElement(required = true)
    protected String searchWMSDomain;
    @XmlElement(required = true)
    protected String searchHXDomain;
    protected String includeApplicantFlag;
    protected String includeOtherNameFlag;

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the middleInitial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleInitial() {
        return middleInitial;
    }

    /**
     * Sets the value of the middleInitial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleInitial(String value) {
        this.middleInitial = value;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuffix(String value) {
        this.suffix = value;
    }

    /**
     * Gets the value of the sexCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexCode() {
        return sexCode;
    }

    /**
     * Sets the value of the sexCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexCode(String value) {
        this.sexCode = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the ssn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSN() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSN(String value) {
        this.ssn = value;
    }

    /**
     * Gets the value of the cin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIN() {
        return cin;
    }

    /**
     * Sets the value of the cin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIN(String value) {
        this.cin = value;
    }

    /**
     * Gets the value of the createCIN property.
     * 
     * @return
     *     possible object is
     *     {@link CreateCINRef }
     *     
     */
    public CreateCINRef getCreateCIN() {
        return createCIN;
    }

    /**
     * Sets the value of the createCIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateCINRef }
     *     
     */
    public void setCreateCIN(CreateCINRef value) {
        this.createCIN = value;
    }

    /**
     * Gets the value of the requestedHits property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRequestedHits() {
        return requestedHits;
    }

    /**
     * Sets the value of the requestedHits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRequestedHits(Integer value) {
        this.requestedHits = value;
    }

    /**
     * Gets the value of the filterBySSNFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterBySSNFlag() {
        return filterBySSNFlag;
    }

    /**
     * Sets the value of the filterBySSNFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterBySSNFlag(String value) {
        this.filterBySSNFlag = value;
    }

    /**
     * Gets the value of the searchWMSDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchWMSDomain() {
        return searchWMSDomain;
    }

    /**
     * Sets the value of the searchWMSDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchWMSDomain(String value) {
        this.searchWMSDomain = value;
    }

    /**
     * Gets the value of the searchHXDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchHXDomain() {
        return searchHXDomain;
    }

    /**
     * Sets the value of the searchHXDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchHXDomain(String value) {
        this.searchHXDomain = value;
    }

    /**
     * Gets the value of the includeApplicantFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncludeApplicantFlag() {
        return includeApplicantFlag;
    }

    /**
     * Sets the value of the includeApplicantFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncludeApplicantFlag(String value) {
        this.includeApplicantFlag = value;
    }

    /**
     * Gets the value of the includeOtherNameFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncludeOtherNameFlag() {
        return includeOtherNameFlag;
    }

    /**
     * Sets the value of the includeOtherNameFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncludeOtherNameFlag(String value) {
        this.includeOtherNameFlag = value;
    }

}
