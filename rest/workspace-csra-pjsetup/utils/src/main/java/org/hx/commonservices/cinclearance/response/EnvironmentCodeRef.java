
package org.hx.commonservices.cinclearance.response;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for environmentCodeRef.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="environmentCodeRef">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NYC"/>
 *     &lt;enumeration value="UPSTATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "environmentCodeRef")
@XmlEnum
public enum EnvironmentCodeRef {

    NYC,
    UPSTATE;

    public String value() {
        return name();
    }

    public static EnvironmentCodeRef fromValue(String v) {
        return valueOf(v);
    }

}
