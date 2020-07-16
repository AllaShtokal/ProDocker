package alla.shtokal.dto.mydto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Setter
@ToString
@Log4j2
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "event", namespace = "http://alla.com/getevent", propOrder = {
        "id",
        "eventType",
        "powerLoss",
        "startDate",
        "endDate",
        "psId",
        "psName",
        "psPower"
})
public class FullEventDto implements Serializable {

    
    private Long id;

    @NotNull @XmlElement(required = true)
    private String eventType;

    @NotNull
    private int powerLoss;

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    private Date startDate;

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    private Date endDate;

    @NotNull
    private Long psId;

    @NotNull @XmlElement(required = true)
    private String psName;

    @NotNull
    private int psPower;

    public FullEventDto(Long id) {
    }

    public FullEventDto() {

    }

    public Long getId() {
        return id;
    }

    public String getEventType() {
        log.info("eventType "+eventType);
        return eventType;
    }

    public int getPowerLoss() {
        return powerLoss;
    }


    public Date getStartDate() {
        log.info("startDate "+startDate);
        return startDate;
    }

    public Date getEndDate() {
        log.info("endDate "+endDate);
        return endDate;
    }

    public Long getPsId() {
        return psId;
    }

    public String getPsName() {
        return psName;
    }

    public int getPsPower() {
        return psPower;
    }
}
