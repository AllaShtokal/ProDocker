package alla.shtokal.elasticsearch.event;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticSearchEventRepositoryy extends ElasticsearchRepository<EventDtoElasticSearch, Long> {






}
