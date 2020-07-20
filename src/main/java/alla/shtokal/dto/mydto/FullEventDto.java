package alla.shtokal.dto.mydto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
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

    @NotNull
    private String eventType;

    @NotNull
    private int powerLoss;

    private Date startDate;

    private Date endDate;

    @NotNull
    private Long psId;


    private String psName;

    @NotNull
    private int psPower;

    public FullEventDto(Long id, @NotNull String eventType, @NotNull int powerLoss, Date startDate, Date endDate, @NotNull Long psId, String psName, @NotNull int psPower) {
        this.id = id;
        this.eventType = eventType;
        this.powerLoss = powerLoss;
        this.startDate = startDate;
        this.endDate = endDate;
        this.psId = psId;
        this.psName = psName;
        this.psPower = psPower;
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
