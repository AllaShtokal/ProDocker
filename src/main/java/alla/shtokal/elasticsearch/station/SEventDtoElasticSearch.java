package alla.shtokal.elasticsearch.station;

import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;


public class SEventDtoElasticSearch {

    private Long id;

    private String eventType;

    private int powerLoss;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private LocalDateTime startDate;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private LocalDateTime  endDate;
    public SEventDtoElasticSearch(){}

    public SEventDtoElasticSearch(Long id, String eventType, int powerLoss, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.eventType = eventType;
        this.powerLoss = powerLoss;
        this.startDate = startDate;
        this.endDate = endDate;
    }

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
}
