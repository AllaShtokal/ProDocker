package alla.shtokal.service.dto;

import alla.shtokal.dto.foreigndto.event.TaskDTO;
import alla.shtokal.dto.mydto.EventDTO;
import alla.shtokal.model.Event;
import alla.shtokal.model.PowerStation;
import alla.shtokal.repository.EventRepository;
import alla.shtokal.repository.PowerStationRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Log4j2
public class EventDTOImplementation implements EventDTOService {


    private EventRepository eventRepository;
    private PowerStationRepository powerStationRepository;
    private final ModelMapper modelMapper;

    public EventDTOImplementation(EventRepository eventRepository, PowerStationRepository powerStationRepository, ModelMapper mapper) {
        this.eventRepository = eventRepository;
        this.powerStationRepository = powerStationRepository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public Long add(EventDTO eventDTO) {

        Optional<PowerStation> p = powerStationRepository.findById(eventDTO.getPsId());
        Event e = modelMapper.map(eventDTO, Event.class);
        p.ifPresent(powerStation -> {
            powerStation.addEvent(e);
            powerStationRepository.save(powerStation);
        });
        Event topByOrderByIdDesc = eventRepository.findTopByOrderByIdDesc();
        return topByOrderByIdDesc.getId();

    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public EventDTO getEventById(Long id) {

        Event event = eventRepository.findById(id).get();
        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);

        eventDTO.setPsId(event.getStation().getId());
        eventDTO.setPsName(event.getStation().getName());
        eventDTO.setPsPower(event.getStation().getPower());
        return eventDTO;

    }

    @Override
    public Collection<EventDTO> getAllEventDto() {

        List<Event> events = eventRepository.findAll();
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


}
