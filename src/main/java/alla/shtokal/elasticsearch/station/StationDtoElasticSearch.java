package alla.shtokal.elasticsearch.station;

import org.hibernate.search.engine.backend.document.model.dsl.ObjectFieldStorage;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.springframework.context.annotation.Profile;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.Nested;
import static org.springframework.data.elasticsearch.annotations.FieldType.Text;
import static org.springframework.data.elasticsearch.annotations.FieldType.Integer;

@Document(indexName = "station")
@Profile("elasticSearch")

public class StationDtoElasticSearch {

    @FullTextField(analyzer = "cleaned_text")
    private Long id;

    @FullTextField(analyzer = "cleaned_text")
    @Field(type = Text )
    private String name;
    @FullTextField(analyzer = "cleaned_text")
    @Field(type = Integer)
    private int power;

    @IndexedEmbedded(
            includePaths = {"id","eventType", "powerLoss","startDate","endDate"},
            storage =  ObjectFieldStorage.NESTED
    )
    @Field(type = Nested, includeInParent = true)
    private List<SEventDtoElasticSearch> events;

    public StationDtoElasticSearch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public List<SEventDtoElasticSearch> getEvents() {
        return events;
    }

    public void setEvents(List<SEventDtoElasticSearch> events) {
        this.events = events;
    }
}
