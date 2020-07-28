package alla.shtokal.elasticsearch.station;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.springframework.context.annotation.Profile;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Profile("elasticSearch")
public class SEventDtoElasticSearch {

    @FullTextField(analyzer = "cleaned_text")
    private Long id;
    @FullTextField(analyzer = "cleaned_text")
    private String eventType;
    @FullTextField(analyzer = "cleaned_text")
    private int powerLoss;
    @FullTextField(analyzer = "cleaned_text")
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private LocalDateTime startDate;
    @FullTextField(analyzer = "cleaned_text")
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
