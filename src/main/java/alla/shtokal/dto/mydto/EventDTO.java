package alla.shtokal.dto.mydto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@ToString
@Log4j2
@EqualsAndHashCode
public class EventDTO implements Serializable {


    private Long id;
    private String eventType;
    private int powerLoss;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp endDate;
    private Long psId;
    private String psName;
    private int psPower;

    public EventDTO(Long id, String eventType, int powerLoss, Timestamp startDate, Timestamp endDate, Long psId, String psName, int psPower) {
        this.id = id;
        this.eventType = eventType;
        this.powerLoss = powerLoss;
        this.startDate = startDate;
        this.endDate = endDate;
        this.psId = psId;
        this.psName = psName;
        this.psPower = psPower;
    }

    public EventDTO(Long id, String eventType, int powerLoss, Timestamp startDate, Timestamp endDate) {
        this.id = id;
        this.eventType = eventType;
        this.powerLoss = powerLoss;
        this.startDate = startDate;
        this.endDate = endDate;

    }


    public EventDTO() {

    }

    public Long getId() {
        return id;
    }

    public String getEventType() {
        log.info("eventType " + eventType);
        return eventType;
    }

    public int getPowerLoss() {
        return powerLoss;
    }


    public Timestamp getStartDate() {
        log.info("startDate " + startDate);
        return startDate;
    }

    public Timestamp getEndDate() {
        log.info("endDate " + endDate);
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
