
package org.hx.commonservices.cinclearance.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="CCRSIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POSOnlyIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servicesFamilyUnitCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recipientFeePTAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recipientFeeFTAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "ccrsIndicator",
    "posOnlyIndicator",
    "servicesFamilyUnitCode",
    "recipientFeePTAmount",
    "recipientFeeFTAmount"
})
@XmlRootElement(name = "ServiceCase")
public class ServiceCase {

    @XmlElement(name = "CCRSIndicator")
    protected String ccrsIndicator;
    @XmlElement(name = "POSOnlyIndicator")
    protected String posOnlyIndicator;
    protected String servicesFamilyUnitCode;
    protected String recipientFeePTAmount;
    protected String recipientFeeFTAmount;

    /**
     * Gets the value of the ccrsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCRSIndicator() {
        return ccrsIndicator;
    }

    /**
     * Sets the value of the ccrsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCRSIndicator(String value) {
        this.ccrsIndicator = value;
    }

    /**
     * Gets the value of the posOnlyIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSOnlyIndicator() {
        return posOnlyIndicator;
    }

    /**
     * Sets the value of the posOnlyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSOnlyIndicator(String value) {
        this.posOnlyIndicator = value;
    }

    /**
     * Gets the value of the servicesFamilyUnitCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicesFamilyUnitCode() {
        return servicesFamilyUnitCode;
    }

    /**
     * Sets the value of the servicesFamilyUnitCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicesFamilyUnitCode(String value) {
        this.servicesFamilyUnitCode = value;
    }

    /**
     * Gets the value of the recipientFeePTAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientFeePTAmount() {
        return recipientFeePTAmount;
    }

    /**
     * Sets the value of the recipientFeePTAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientFeePTAmount(String value) {
        this.recipientFeePTAmount = value;
    }

    /**
     * Gets the value of the recipientFeeFTAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientFeeFTAmount() {
        return recipientFeeFTAmount;
    }

    /**
     * Sets the value of the recipientFeeFTAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientFeeFTAmount(String value) {
        this.recipientFeeFTAmount = value;
    }

}
