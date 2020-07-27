package alla.shtokal.elasticsearch.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Date;


public class EventDtoElasticSearch implements Serializable {

    private Long id;

    private String eventType;

    private int powerLoss;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private LocalDateTime startDate;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private LocalDateTime  endDate;

    private Long psId;

    private String psName;

    private int psPower;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getPowerLoss() {
        return powerLoss;
    }

    public void setPowerLoss(int powerLoss) {
        this.powerLoss = powerLoss;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getPsId() {
        return psId;
    }

    public void setPsId(Long psId) {
        this.psId = psId;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public int getPsPower() {
        return psPower;
    }

    public void setPsPower(int psPower) {
        this.psPower = psPower;
    }
}
