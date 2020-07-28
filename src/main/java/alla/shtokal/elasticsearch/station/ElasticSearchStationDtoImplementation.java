package alla.shtokal.elasticsearch.station;

import alla.shtokal.model.Event;
import alla.shtokal.model.PowerStation;
import alla.shtokal.repository.PowerStationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Profile("elasticSearch")
public class ElasticSearchStationDtoImplementation implements StationDtoElasticSearchService {

    private final ElasticSearchStationRepository elasticSearchStationRepository;
    private final ModelMapper modelMapper;
    private final PowerStationRepository powerStationRepository;

    public ElasticSearchStationDtoImplementation(ElasticSearchStationRepository elasticSearchStationRepository, ModelMapper modelMapper, PowerStationRepository powerStationRepository) {
        this.elasticSearchStationRepository = elasticSearchStationRepository;
        this.modelMapper = modelMapper;
        this.powerStationRepository = powerStationRepository;
    }


    @Override
    public Collection<StationDtoElasticSearch> getAll() {

        return (Collection<StationDtoElasticSearch>) elasticSearchStationRepository.findAll();


    }

    @Override
    public StationDtoElasticSearch getById(Long id) {
        return elasticSearchStationRepository.findById(id).orElse(null);
           }

    @Override
    public String add() {
        List<PowerStation> powerStationList = powerStationRepository.findAll();

        for (PowerStation ps : powerStationList) {

            StationDtoElasticSearch stationDtoElasticSearch = modelMapper.map(ps, StationDtoElasticSearch.class);

            List<Event> events = ps.getEvents();
            List<SEventDtoElasticSearch> sEventDtoElasticSearches = new ArrayList<>();
            for (Event ev : events) {

                sEventDtoElasticSearches.add(new SEventDtoElasticSearch(
                        ev.getId(), ev.getEventType(), ev.getPowerLoss(), ev.getStartDate().toLocalDateTime(), ev.getEndDate().toLocalDateTime()
                ));
            }
            stationDtoElasticSearch.setEvents(sEventDtoElasticSearches);
            elasticSearchStationRepository.save(stationDtoElasticSearch);
        }
        return "Done!";
    }
}
