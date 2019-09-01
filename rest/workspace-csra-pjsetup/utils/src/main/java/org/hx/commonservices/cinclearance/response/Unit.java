
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
 *         &lt;element name="responsibleUnitIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionUnitIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "responsibleUnitIdentifier",
    "transactionUnitIdentifier"
})
@XmlRootElement(name = "Unit")
public class Unit {

    protected String responsibleUnitIdentifier;
    protected String transactionUnitIdentifier;

    /**
     * Gets the value of the responsibleUnitIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleUnitIdentifier() {
        return responsibleUnitIdentifier;
    }

    /**
     * Sets the value of the responsibleUnitIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleUnitIdentifier(String value) {
        this.responsibleUnitIdentifier = value;
    }

    /**
     * Gets the value of the transactionUnitIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionUnitIdentifier() {
        return transactionUnitIdentifier;
    }

    /**
     * Sets the value of the transactionUnitIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionUnitIdentifier(String value) {
        this.transactionUnitIdentifier = value;
    }

}
