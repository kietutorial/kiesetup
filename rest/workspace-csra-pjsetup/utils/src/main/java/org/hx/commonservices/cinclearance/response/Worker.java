
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
 *         &lt;element name="responsibleWorker" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionWorker" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "responsibleWorker",
    "transactionWorker"
})
@XmlRootElement(name = "Worker")
public class Worker {

    protected String responsibleWorker;
    protected String transactionWorker;

    /**
     * Gets the value of the responsibleWorker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleWorker() {
        return responsibleWorker;
    }

    /**
     * Sets the value of the responsibleWorker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleWorker(String value) {
        this.responsibleWorker = value;
    }

    /**
     * Gets the value of the transactionWorker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionWorker() {
        return transactionWorker;
    }

    /**
     * Sets the value of the transactionWorker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionWorker(String value) {
        this.transactionWorker = value;
    }

}
