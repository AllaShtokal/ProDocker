package alla.shtokal.elasticsearch;

import alla.shtokal.model.Event;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElasticSearchEventRepositoryy extends ElasticsearchRepository<Event, Long> {

    List<Event> findAllByPowerLoss (int powerLoss);




}
