
package alla.shtokal.soap.listtasks;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AWARIA"/>
 *     &lt;enumeration value="REMONT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "type", namespace = "http://s0314/gettask")
@XmlEnum
public enum TypeXML {

    AWARIA,
    REMONT;

    public String value() {
        return name();
    }

    public static TypeXML fromValue(String v) {
        return valueOf(v);
    }

}
