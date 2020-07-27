package alla.shtokal.elasticsearch.event;

import alla.shtokal.model.Event;
import alla.shtokal.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;

@Service
public class ElasticSearchEventDTOImplementation implements EventDTOElasticSearchService {

    private ElasticSearchEventRepositoryy elasticSearchEventRepositoryy;
    private final ModelMapper modelMapper;
    private final EventRepository eventRepo;

    public ElasticSearchEventDTOImplementation(ElasticSearchEventRepositoryy elasticSearchEventRepositoryy, ModelMapper modelMapper, EventRepository eventRepo) {
        this.elasticSearchEventRepositoryy = elasticSearchEventRepositoryy;
        this.modelMapper = modelMapper;
        this.eventRepo = eventRepo;
    }

    @Override
    public EventDtoElasticSearch getById(Long id) {

        return elasticSearchEventRepositoryy.findById(id).get();

    }


    @Override
    public Collection<EventDtoElasticSearch> getAll() {

       return (List<EventDtoElasticSearch>)elasticSearchEventRepositoryy.findAll();

    }

    @Override
    public String add() {
        List<Event> all = eventRepo.findAll();

        for (Event event : all) {

            EventDtoElasticSearch eventDTO = modelMapper.map(event, EventDtoElasticSearch.class);
//            eventDTO.setStartDate(new Date(event.getStartDate().getTime()));
//            eventDTO.setEndDate(new Date(event.getEndDate().getTime()));
            eventDTO.setStartDate(event.getStartDate().toLocalDateTime());
            eventDTO.setEndDate(event.getEndDate().toLocalDateTime());
            eventDTO.setPsId(event.getStation().getId());
            eventDTO.setPsName(event.getStation().getName());
            eventDTO.setPsPower(event.getStation().getPower());

            elasticSearchEventRepositoryy.save(eventDTO);
        }
        return "Well done!";

    }


}
