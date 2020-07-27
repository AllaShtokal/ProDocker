package alla.shtokal.elasticsearch.station;

import alla.shtokal.elasticsearch.event.EventDtoElasticSearch;

import java.util.Collection;

public interface StationDtoElasticSearchService {

    Collection<StationDtoElasticSearch> getAll();
    StationDtoElasticSearch getById(Long id);
    String add();
}
