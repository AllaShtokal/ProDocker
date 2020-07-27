package alla.shtokal.elasticsearch.event;

import java.util.Collection;


public interface EventDTOElasticSearchService {

    Collection<EventDtoElasticSearch> getAll();
    EventDtoElasticSearch getById(Long id);
    String add();

}
