
package org.hx.commonservices.cinclearance.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="fiscalDistrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionDistrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "fiscalDistrict",
    "transactionDistrict"
})
@XmlRootElement(name = "District")
public class District {

    protected String fiscalDistrict;
    protected String transactionDistrict;

    /**
     * Gets the value of the fiscalDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiscalDistrict() {
        return fiscalDistrict;
    }

    /**
     * Sets the value of the fiscalDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiscalDistrict(String value) {
        this.fiscalDistrict = value;
    }

    /**
     * Gets the value of the transactionDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionDistrict() {
        return transactionDistrict;
    }

    /**
     * Sets the value of the transactionDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionDistrict(String value) {
        this.transactionDistrict = value;
    }

}
