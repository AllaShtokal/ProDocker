package alla.shtokal.elasticsearch;

import alla.shtokal.dto.mydto.EventDTO;
import alla.shtokal.model.Event;
import alla.shtokal.repository.EventRepository;
import alla.shtokal.service.event.EventImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public EventDTO getById(Long id) {

        Event event = elasticSearchEventRepositoryy.findById(id).get();
        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);

        eventDTO.setPsId(event.getStation().getId());
        eventDTO.setPsName(event.getStation().getName());
        eventDTO.setPsPower(event.getStation().getPower());
        return eventDTO;

    }



    @Override
    public Collection<EventDTO> getAll() {

        List<Event> events = (List<Event>) elasticSearchEventRepositoryy.findAll();
        List<EventDTO> eventsDto = new ArrayList<>();

        for (Event event : events) {

            EventDTO eventDTO = modelMapper.map(event, EventDTO.class);
            eventDTO.setPsId(event.getStation().getId());
            eventDTO.setPsName(event.getStation().getName());
            eventDTO.setPsPower(event.getStation().getPower());

            eventsDto.add(eventDTO);
        }
        return eventsDto;

    }

    @Override
    public Long add() {
        List<Event> all = eventRepo.findAll();
        for (Event e: all)
        {
            elasticSearchEventRepositoryy.save(e);
        }
        return 1L;

    }

    @Override
    public void delete(Long id) {

    }
}
