
package org.hx.commonservices.cinclearance.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hx.commonservices.cinclearance.request.CINClearanceRequest;


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
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Request/}CINClearanceRequest"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}MatchCounts" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}MatchResultEntry" maxOccurs="unbounded" minOccurs="0"/>
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
    "cinClearanceRequest",
    "matchCounts",
    "matchResultEntry"
})
@XmlRootElement(name = "CINClearanceResponse")
public class CINClearanceResponse {

    @XmlElement(name = "CINClearanceRequest", namespace = "http://org/hx/commonservices/CINClearance/Request/", required = true)
    protected CINClearanceRequest cinClearanceRequest;
    @XmlElement(name = "MatchCounts", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected MatchCounts matchCounts;
    @XmlElement(name = "MatchResultEntry", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected List<MatchResultEntry> matchResultEntry;

    /**
     * Gets the value of the cinClearanceRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CINClearanceRequest }
     *     
     */
    public CINClearanceRequest getCINClearanceRequest() {
        return cinClearanceRequest;
    }

    /**
     * Sets the value of the cinClearanceRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CINClearanceRequest }
     *     
     */
    public void setCINClearanceRequest(CINClearanceRequest value) {
        this.cinClearanceRequest = value;
    }

    /**
     * Gets the value of the matchCounts property.
     * 
     * @return
     *     possible object is
     *     {@link MatchCounts }
     *     
     */
    public MatchCounts getMatchCounts() {
        return matchCounts;
    }

    /**
     * Sets the value of the matchCounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatchCounts }
     *     
     */
    public void setMatchCounts(MatchCounts value) {
        this.matchCounts = value;
    }

    /**
     * Gets the value of the matchResultEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matchResultEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatchResultEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MatchResultEntry }
     * 
     * 
     */
    public List<MatchResultEntry> getMatchResultEntry() {
        if (matchResultEntry == null) {
            matchResultEntry = new ArrayList<MatchResultEntry>();
        }
        return this.matchResultEntry;
    }

	public void setMatchResultEntry(List<MatchResultEntry> matchResultEntry) {
		this.matchResultEntry = matchResultEntry;
	}

}
