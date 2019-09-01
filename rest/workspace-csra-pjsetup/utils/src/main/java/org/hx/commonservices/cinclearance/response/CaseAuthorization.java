
package org.hx.commonservices.cinclearance.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="authorizationNumberIdentifer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizationFromDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="authorizationToDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="supervisorSignOffDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
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
    "authorizationNumberIdentifer",
    "authorizationFromDate",
    "authorizationToDate",
    "supervisorSignOffDate"
})
@XmlRootElement(name = "CaseAuthorization")
public class CaseAuthorization {

    protected String authorizationNumberIdentifer;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar authorizationFromDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar authorizationToDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar supervisorSignOffDate;

    /**
     * Gets the value of the authorizationNumberIdentifer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationNumberIdentifer() {
        return authorizationNumberIdentifer;
    }

    /**
     * Sets the value of the authorizationNumberIdentifer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationNumberIdentifer(String value) {
        this.authorizationNumberIdentifer = value;
    }

    /**
     * Gets the value of the authorizationFromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAuthorizationFromDate() {
        return authorizationFromDate;
    }

    /**
     * Sets the value of the authorizationFromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAuthorizationFromDate(XMLGregorianCalendar value) {
        this.authorizationFromDate = value;
    }

    /**
     * Gets the value of the authorizationToDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAuthorizationToDate() {
        return authorizationToDate;
    }

    /**
     * Sets the value of the authorizationToDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAuthorizationToDate(XMLGregorianCalendar value) {
        this.authorizationToDate = value;
    }

    /**
     * Gets the value of the supervisorSignOffDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSupervisorSignOffDate() {
        return supervisorSignOffDate;
    }

    /**
     * Sets the value of the supervisorSignOffDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSupervisorSignOffDate(XMLGregorianCalendar value) {
        this.supervisorSignOffDate = value;
    }

}
