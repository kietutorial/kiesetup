
package org.hx.commonservices.cinclearance.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createCINRef.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="createCINRef">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NYC"/>
 *     &lt;enumeration value="UPSTATE"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "createCINRef")
@XmlEnum
public enum CreateCINRef {

    NYC,
    UPSTATE,
    NONE;

    public String value() {
        return name();
    }

    public static CreateCINRef fromValue(String v) {
        return valueOf(v);
    }

}
