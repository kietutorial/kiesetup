
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
 *         &lt;element name="programTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="programTypeParticipation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="programCaseStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="individualStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "programTypeCode",
    "programTypeParticipation",
    "programCaseStatusCode",
    "individualStatusCode"
})
@XmlRootElement(name = "Program")
public class Program {

    protected String programTypeCode;
    protected String programTypeParticipation;
    protected String programCaseStatusCode;
    protected String individualStatusCode;

    /**
     * Gets the value of the programTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramTypeCode() {
        return programTypeCode;
    }

    /**
     * Sets the value of the programTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramTypeCode(String value) {
        this.programTypeCode = value;
    }

    /**
     * Gets the value of the programTypeParticipation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramTypeParticipation() {
        return programTypeParticipation;
    }

    /**
     * Sets the value of the programTypeParticipation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramTypeParticipation(String value) {
        this.programTypeParticipation = value;
    }

    /**
     * Gets the value of the programCaseStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramCaseStatusCode() {
        return programCaseStatusCode;
    }

    /**
     * Sets the value of the programCaseStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramCaseStatusCode(String value) {
        this.programCaseStatusCode = value;
    }

    /**
     * Gets the value of the individualStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndividualStatusCode() {
        return individualStatusCode;
    }

    /**
     * Sets the value of the individualStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndividualStatusCode(String value) {
        this.individualStatusCode = value;
    }

}
