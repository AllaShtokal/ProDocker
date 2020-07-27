package alla.shtokal.elasticsearch.station;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElasticSearchStationRepository extends ElasticsearchRepository<StationDtoElasticSearch, Long> {

    //@Query("{ \"query\" : { \"bool\" : { \"must\" : [ { \"query_string\" : { \"query\" : \"?\", \"fields\" : [ \"name\" ] } } ] } }}")
    List<StationDtoElasticSearch> findByName (String name);


    List<StationDtoElasticSearch> findByPower (int power);
}
