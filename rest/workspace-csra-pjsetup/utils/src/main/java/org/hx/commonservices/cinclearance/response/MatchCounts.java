
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
 *         &lt;element name="CINCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSNCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="possibleNameMatches" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalNameMatchCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalAcceptableMatchCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SDXMatchCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "cinCount",
    "ssnCount",
    "possibleNameMatches",
    "totalNameMatchCount",
    "totalAcceptableMatchCount",
    "sdxMatchCount"
})
@XmlRootElement(name = "MatchCounts")
public class MatchCounts {

    @XmlElement(name = "CINCount")
    protected String cinCount;
    @XmlElement(name = "SSNCount")
    protected String ssnCount;
    protected String possibleNameMatches;
    protected String totalNameMatchCount;
    protected String totalAcceptableMatchCount;
    @XmlElement(name = "SDXMatchCount")
    protected String sdxMatchCount;

    /**
     * Gets the value of the cinCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCINCount() {
        return cinCount;
    }

    /**
     * Sets the value of the cinCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCINCount(String value) {
        this.cinCount = value;
    }

    /**
     * Gets the value of the ssnCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSNCount() {
        return ssnCount;
    }

    /**
     * Sets the value of the ssnCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSNCount(String value) {
        this.ssnCount = value;
    }

    /**
     * Gets the value of the possibleNameMatches property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPossibleNameMatches() {
        return possibleNameMatches;
    }

    /**
     * Sets the value of the possibleNameMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPossibleNameMatches(String value) {
        this.possibleNameMatches = value;
    }

    /**
     * Gets the value of the totalNameMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalNameMatchCount() {
        return totalNameMatchCount;
    }

    /**
     * Sets the value of the totalNameMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalNameMatchCount(String value) {
        this.totalNameMatchCount = value;
    }

    /**
     * Gets the value of the totalAcceptableMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalAcceptableMatchCount() {
        return totalAcceptableMatchCount;
    }

    /**
     * Sets the value of the totalAcceptableMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalAcceptableMatchCount(String value) {
        this.totalAcceptableMatchCount = value;
    }

    /**
     * Gets the value of the sdxMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSDXMatchCount() {
        return sdxMatchCount;
    }

    /**
     * Sets the value of the sdxMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSDXMatchCount(String value) {
        this.sdxMatchCount = value;
    }

}
