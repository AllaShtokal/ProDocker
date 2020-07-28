package alla.shtokal.elasticsearch.station;

import org.springframework.context.annotation.Profile;

import java.util.Collection;

@Profile("elasticSearch")
public interface StationDtoElasticSearchService {

    Collection<StationDtoElasticSearch> getAll();
    StationDtoElasticSearch getById(Long id);
    String add();
}
