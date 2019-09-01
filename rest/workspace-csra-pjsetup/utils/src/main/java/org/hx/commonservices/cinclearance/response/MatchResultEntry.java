
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
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}Person" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}Applicant" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}Application" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}Case" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}CaseTransaction" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}CaseAuthorization" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}ServiceCase" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}Program" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}Client" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}District" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}Worker" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}Office" minOccurs="0"/>
 *         &lt;element ref="{http://org/hx/commonservices/CINClearance/Response/}Unit" minOccurs="0"/>
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
    "person",
    "applicant",
    "application",
    "_case",
    "caseTransaction",
    "caseAuthorization",
    "serviceCase",
    "program",
    "client",
    "district",
    "worker",
    "office",
    "unit"
})
@XmlRootElement(name = "MatchResultEntry")
public class MatchResultEntry {

    @XmlElement(name = "Person", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected Person person;
    @XmlElement(name = "Applicant", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected Applicant applicant;
    @XmlElement(name = "Application", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected Application application;
    @XmlElement(name = "Case", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected Case _case;
    @XmlElement(name = "CaseTransaction", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected CaseTransaction caseTransaction;
    @XmlElement(name = "CaseAuthorization", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected CaseAuthorization caseAuthorization;
    @XmlElement(name = "ServiceCase", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected ServiceCase serviceCase;
    @XmlElement(name = "Program", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected Program program;
    @XmlElement(name = "Client", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected Client client;
    @XmlElement(name = "District", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected District district;
    @XmlElement(name = "Worker", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected Worker worker;
    @XmlElement(name = "Office", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected Office office;
    @XmlElement(name = "Unit", namespace = "http://org/hx/commonservices/CINClearance/Response/")
    protected Unit unit;

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPerson(Person value) {
        this.person = value;
    }

    /**
     * Gets the value of the applicant property.
     * 
     * @return
     *     possible object is
     *     {@link Applicant }
     *     
     */
    public Applicant getApplicant() {
        return applicant;
    }

    /**
     * Sets the value of the applicant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Applicant }
     *     
     */
    public void setApplicant(Applicant value) {
        this.applicant = value;
    }

    /**
     * Gets the value of the application property.
     * 
     * @return
     *     possible object is
     *     {@link Application }
     *     
     */
    public Application getApplication() {
        return application;
    }

    /**
     * Sets the value of the application property.
     * 
     * @param value
     *     allowed object is
     *     {@link Application }
     *     
     */
    public void setApplication(Application value) {
        this.application = value;
    }

    /**
     * Gets the value of the case property.
     * 
     * @return
     *     possible object is
     *     {@link Case }
     *     
     */
    public Case getCase() {
        return _case;
    }

    /**
     * Sets the value of the case property.
     * 
     * @param value
     *     allowed object is
     *     {@link Case }
     *     
     */
    public void setCase(Case value) {
        this._case = value;
    }

    /**
     * Gets the value of the caseTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link CaseTransaction }
     *     
     */
    public CaseTransaction getCaseTransaction() {
        return caseTransaction;
    }

    /**
     * Sets the value of the caseTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseTransaction }
     *     
     */
    public void setCaseTransaction(CaseTransaction value) {
        this.caseTransaction = value;
    }

    /**
     * Gets the value of the caseAuthorization property.
     * 
     * @return
     *     possible object is
     *     {@link CaseAuthorization }
     *     
     */
    public CaseAuthorization getCaseAuthorization() {
        return caseAuthorization;
    }

    /**
     * Sets the value of the caseAuthorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseAuthorization }
     *     
     */
    public void setCaseAuthorization(CaseAuthorization value) {
        this.caseAuthorization = value;
    }

    /**
     * Gets the value of the serviceCase property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCase }
     *     
     */
    public ServiceCase getServiceCase() {
        return serviceCase;
    }

    /**
     * Sets the value of the serviceCase property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCase }
     *     
     */
    public void setServiceCase(ServiceCase value) {
        this.serviceCase = value;
    }

    /**
     * Gets the value of the program property.
     * 
     * @return
     *     possible object is
     *     {@link Program }
     *     
     */
    public Program getProgram() {
        return program;
    }

    /**
     * Sets the value of the program property.
     * 
     * @param value
     *     allowed object is
     *     {@link Program }
     *     
     */
    public void setProgram(Program value) {
        this.program = value;
    }

    /**
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link Client }
     *     
     */
    public void setClient(Client value) {
        this.client = value;
    }

    /**
     * Gets the value of the district property.
     * 
     * @return
     *     possible object is
     *     {@link District }
     *     
     */
    public District getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *     allowed object is
     *     {@link District }
     *     
     */
    public void setDistrict(District value) {
        this.district = value;
    }

    /**
     * Gets the value of the worker property.
     * 
     * @return
     *     possible object is
     *     {@link Worker }
     *     
     */
    public Worker getWorker() {
        return worker;
    }

    /**
     * Sets the value of the worker property.
     * 
     * @param value
     *     allowed object is
     *     {@link Worker }
     *     
     */
    public void setWorker(Worker value) {
        this.worker = value;
    }

    /**
     * Gets the value of the office property.
     * 
     * @return
     *     possible object is
     *     {@link Office }
     *     
     */
    public Office getOffice() {
        return office;
    }

    /**
     * Sets the value of the office property.
     * 
     * @param value
     *     allowed object is
     *     {@link Office }
     *     
     */
    public void setOffice(Office value) {
        this.office = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link Unit }
     *     
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Unit }
     *     
     */
    public void setUnit(Unit value) {
        this.unit = value;
    }

}
