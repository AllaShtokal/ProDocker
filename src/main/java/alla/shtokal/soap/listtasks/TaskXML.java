
package alla.shtokal.soap.listtasks;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for task complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="task">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="namePowerStation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taskType" type="{http://s0314/gettask}type"/>
 *         &lt;element name="powerLoss" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "task", namespace = "http://s0314/gettask", propOrder = {
    "id",
    "namePowerStation",
        "taskTypeXML",
    "powerLoss",
    "startDate",
    "endDate"
})
public class TaskXML {

    @XmlElement(namespace = "http://s0314/gettask")
    protected long id;
    @XmlElement(namespace = "http://s0314/gettask", required = true)
    protected String namePowerStation;
    @XmlElement(namespace = "http://s0314/gettask", required = true)
    @XmlSchemaType(name = "string")
    protected TypeXML taskTypeXML;
    @XmlElement(namespace = "http://s0314/gettask", required = true)
    protected BigDecimal powerLoss;
    @XmlElement(namespace = "http://s0314/gettask", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(namespace = "http://s0314/gettask", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the namePowerStation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamePowerStation() {
        return namePowerStation;
    }

    /**
     * Sets the value of the namePowerStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamePowerStation(String value) {
        this.namePowerStation = value;
    }

    /**
     * Gets the value of the taskType property.
     * 
     * @return
     *     possible object is
     *     {@link TypeXML }
     *     
     */
    public TypeXML getTaskTypeXML() {
        return taskTypeXML;
    }

    /**
     * Sets the value of the taskType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeXML }
     *     
     */
    public void setTaskTypeXML(TypeXML value) {
        this.taskTypeXML = value;
    }

    /**
     * Gets the value of the powerLoss property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPowerLoss() {
        return powerLoss;
    }

    /**
     * Sets the value of the powerLoss property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPowerLoss(BigDecimal value) {
        this.powerLoss = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

}
