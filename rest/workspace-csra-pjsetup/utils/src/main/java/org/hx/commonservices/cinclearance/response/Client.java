
package org.hx.commonservices.cinclearance.response;

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
 *         &lt;element name="clientIdentificationNumberIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientLineNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="individualReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="individualReasonMnemonic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="electronicDocumentIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationshipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeOfMatchFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matchScore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="environmentCode" type="{http://org/hx/commonservices/CINClearance/Response/}environmentCodeRef" minOccurs="0"/>
 *         &lt;element name="otherNameCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSNAccountCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="afisExemptIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSIIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="citizenshipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="continuousCoverageDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="medicareIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chaffeeIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="birthVerificationIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="restrictExceptionIndicatorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNAPReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SNAPReasonMnemonic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="individualCategoricalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MACoverageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MACoverageFromDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="MACoverageToDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="thirdPartyHealthInsuranceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="safetynetCashCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "clientIdentificationNumberIdentifier",
    "clientLineNumber",
    "individualReasonCode",
    "individualReasonMnemonic",
    "electronicDocumentIndicatorCode",
    "relationshipCode",
    "typeOfMatchFlag",
    "matchScore",
    "environmentCode",
    "otherNameCode",
    "ssnAccountCode",
    "cardCode",
    "afisExemptIndicatorCode",
    "ssiIndicatorCode",
    "originatorCode",
    "citizenshipCode",
    "continuousCoverageDate",
    "medicareIndicatorCode",
    "chaffeeIndicatorCode",
    "birthVerificationIndicatorCode",
    "restrictExceptionIndicatorCode",
    "snapReasonCode",
    "snapReasonMnemonic",
    "individualCategoricalCode",
    "maCoverageCode",
    "maCoverageFromDate",
    "maCoverageToDate",
    "thirdPartyHealthInsuranceCode",
    "safetynetCashCount",
    "stateCount"
})
@XmlRootElement(name = "Client")
public class Client {

    protected String clientIdentificationNumberIdentifier;
    protected String clientLineNumber;
    protected String individualReasonCode;
    protected String individualReasonMnemonic;
    protected String electronicDocumentIndicatorCode;
    protected String relationshipCode;
    protected String typeOfMatchFlag;
    protected String matchScore;
    protected EnvironmentCodeRef environmentCode;
    protected String otherNameCode;
    @XmlElement(name = "SSNAccountCode")
    protected String ssnAccountCode;
    protected String cardCode;
    protected String afisExemptIndicatorCode;
    @XmlElement(name = "SSIIndicatorCode")
    protected String ssiIndicatorCode;
    protected String originatorCode;
    protected String citizenshipCode;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar continuousCoverageDate;
    protected String medicareIndicatorCode;
    protected String chaffeeIndicatorCode;
    protected String birthVerificationIndicatorCode;
    protected String restrictExceptionIndicatorCode;
    @XmlElement(name = "SNAPReasonCode")
    protected String snapReasonCode;
    @XmlElement(name = "SNAPReasonMnemonic")
    protected String snapReasonMnemonic;
    protected String individualCategoricalCode;
    @XmlElement(name = "MACoverageCode")
    protected String maCoverageCode;
    @XmlElement(name = "MACoverageFromDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar maCoverageFromDate;
    @XmlElement(name = "MACoverageToDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar maCoverageToDate;
    protected String thirdPartyHealthInsuranceCode;
    protected String safetynetCashCount;
    protected String stateCount;

    /**
     * Gets the value of the clientIdentificationNumberIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientIdentificationNumberIdentifier() {
        return clientIdentificationNumberIdentifier;
    }

    /**
     * Sets the value of the clientIdentificationNumberIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientIdentificationNumberIdentifier(String value) {
        this.clientIdentificationNumberIdentifier = value;
    }

    /**
     * Gets the value of the clientLineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientLineNumber() {
        return clientLineNumber;
    }

    /**
     * Sets the value of the clientLineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientLineNumber(String value) {
        this.clientLineNumber = value;
    }

    /**
     * Gets the value of the individualReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndividualReasonCode() {
        return individualReasonCode;
    }

    /**
     * Sets the value of the individualReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndividualReasonCode(String value) {
        this.individualReasonCode = value;
    }

    /**
     * Gets the value of the individualReasonMnemonic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndividualReasonMnemonic() {
        return individualReasonMnemonic;
    }

    /**
     * Sets the value of the individualReasonMnemonic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndividualReasonMnemonic(String value) {
        this.individualReasonMnemonic = value;
    }

    /**
     * Gets the value of the electronicDocumentIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElectronicDocumentIndicatorCode() {
        return electronicDocumentIndicatorCode;
    }

    /**
     * Sets the value of the electronicDocumentIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElectronicDocumentIndicatorCode(String value) {
        this.electronicDocumentIndicatorCode = value;
    }

    /**
     * Gets the value of the relationshipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationshipCode() {
        return relationshipCode;
    }

    /**
     * Sets the value of the relationshipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationshipCode(String value) {
        this.relationshipCode = value;
    }

    /**
     * Gets the value of the typeOfMatchFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfMatchFlag() {
        return typeOfMatchFlag;
    }

    /**
     * Sets the value of the typeOfMatchFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfMatchFlag(String value) {
        this.typeOfMatchFlag = value;
    }

    /**
     * Gets the value of the matchScore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatchScore() {
        return matchScore;
    }

    /**
     * Sets the value of the matchScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatchScore(String value) {
        this.matchScore = value;
    }

    /**
     * Gets the value of the environmentCode property.
     * 
     * @return
     *     possible object is
     *     {@link EnvironmentCodeRef }
     *     
     */
    public EnvironmentCodeRef getEnvironmentCode() {
        return environmentCode;
    }

    /**
     * Sets the value of the environmentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnvironmentCodeRef }
     *     
     */
    public void setEnvironmentCode(EnvironmentCodeRef value) {
        this.environmentCode = value;
    }

    /**
     * Gets the value of the otherNameCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherNameCode() {
        return otherNameCode;
    }

    /**
     * Sets the value of the otherNameCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherNameCode(String value) {
        this.otherNameCode = value;
    }

    /**
     * Gets the value of the ssnAccountCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSNAccountCode() {
        return ssnAccountCode;
    }

    /**
     * Sets the value of the ssnAccountCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSNAccountCode(String value) {
        this.ssnAccountCode = value;
    }

    /**
     * Gets the value of the cardCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardCode() {
        return cardCode;
    }

    /**
     * Sets the value of the cardCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardCode(String value) {
        this.cardCode = value;
    }

    /**
     * Gets the value of the afisExemptIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfisExemptIndicatorCode() {
        return afisExemptIndicatorCode;
    }

    /**
     * Sets the value of the afisExemptIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfisExemptIndicatorCode(String value) {
        this.afisExemptIndicatorCode = value;
    }

    /**
     * Gets the value of the ssiIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSIIndicatorCode() {
        return ssiIndicatorCode;
    }

    /**
     * Sets the value of the ssiIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSIIndicatorCode(String value) {
        this.ssiIndicatorCode = value;
    }

    /**
     * Gets the value of the originatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginatorCode() {
        return originatorCode;
    }

    /**
     * Sets the value of the originatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginatorCode(String value) {
        this.originatorCode = value;
    }

    /**
     * Gets the value of the citizenshipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    /**
     * Sets the value of the citizenshipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCitizenshipCode(String value) {
        this.citizenshipCode = value;
    }

    /**
     * Gets the value of the continuousCoverageDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContinuousCoverageDate() {
        return continuousCoverageDate;
    }

    /**
     * Sets the value of the continuousCoverageDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContinuousCoverageDate(XMLGregorianCalendar value) {
        this.continuousCoverageDate = value;
    }

    /**
     * Gets the value of the medicareIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicareIndicatorCode() {
        return medicareIndicatorCode;
    }

    /**
     * Sets the value of the medicareIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicareIndicatorCode(String value) {
        this.medicareIndicatorCode = value;
    }

    /**
     * Gets the value of the chaffeeIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChaffeeIndicatorCode() {
        return chaffeeIndicatorCode;
    }

    /**
     * Sets the value of the chaffeeIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChaffeeIndicatorCode(String value) {
        this.chaffeeIndicatorCode = value;
    }

    /**
     * Gets the value of the birthVerificationIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthVerificationIndicatorCode() {
        return birthVerificationIndicatorCode;
    }

    /**
     * Sets the value of the birthVerificationIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthVerificationIndicatorCode(String value) {
        this.birthVerificationIndicatorCode = value;
    }

    /**
     * Gets the value of the restrictExceptionIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestrictExceptionIndicatorCode() {
        return restrictExceptionIndicatorCode;
    }

    /**
     * Sets the value of the restrictExceptionIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestrictExceptionIndicatorCode(String value) {
        this.restrictExceptionIndicatorCode = value;
    }

    /**
     * Gets the value of the snapReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNAPReasonCode() {
        return snapReasonCode;
    }

    /**
     * Sets the value of the snapReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNAPReasonCode(String value) {
        this.snapReasonCode = value;
    }

    /**
     * Gets the value of the snapReasonMnemonic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNAPReasonMnemonic() {
        return snapReasonMnemonic;
    }

    /**
     * Sets the value of the snapReasonMnemonic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNAPReasonMnemonic(String value) {
        this.snapReasonMnemonic = value;
    }

    /**
     * Gets the value of the individualCategoricalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndividualCategoricalCode() {
        return individualCategoricalCode;
    }

    /**
     * Sets the value of the individualCategoricalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndividualCategoricalCode(String value) {
        this.individualCategoricalCode = value;
    }

    /**
     * Gets the value of the maCoverageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMACoverageCode() {
        return maCoverageCode;
    }

    /**
     * Sets the value of the maCoverageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMACoverageCode(String value) {
        this.maCoverageCode = value;
    }

    /**
     * Gets the value of the maCoverageFromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMACoverageFromDate() {
        return maCoverageFromDate;
    }

    /**
     * Sets the value of the maCoverageFromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMACoverageFromDate(XMLGregorianCalendar value) {
        this.maCoverageFromDate = value;
    }

    /**
     * Gets the value of the maCoverageToDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMACoverageToDate() {
        return maCoverageToDate;
    }

    /**
     * Sets the value of the maCoverageToDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMACoverageToDate(XMLGregorianCalendar value) {
        this.maCoverageToDate = value;
    }

    /**
     * Gets the value of the thirdPartyHealthInsuranceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThirdPartyHealthInsuranceCode() {
        return thirdPartyHealthInsuranceCode;
    }

    /**
     * Sets the value of the thirdPartyHealthInsuranceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThirdPartyHealthInsuranceCode(String value) {
        this.thirdPartyHealthInsuranceCode = value;
    }

    /**
     * Gets the value of the safetynetCashCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSafetynetCashCount() {
        return safetynetCashCount;
    }

    /**
     * Sets the value of the safetynetCashCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSafetynetCashCount(String value) {
        this.safetynetCashCount = value;
    }

    /**
     * Gets the value of the stateCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateCount() {
        return stateCount;
    }

    /**
     * Sets the value of the stateCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateCount(String value) {
        this.stateCount = value;
    }

}
