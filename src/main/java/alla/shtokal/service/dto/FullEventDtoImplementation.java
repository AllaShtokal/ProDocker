package alla.shtokal.service.dto;

import alla.shtokal.dto.mydto.FullEventDto;
import alla.shtokal.model.Event;
import alla.shtokal.repository.EventRepository;
import alla.shtokal.repository.PowerStationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class FullEventDtoImplementation implements FullEventDtoService {


    private EventRepository eventRepository;
    private PowerStationRepository powerStationRepository;
    private final ModelMapper mapper;

    public FullEventDtoImplementation(EventRepository eventRepository, PowerStationRepository powerStationRepository, ModelMapper mapper) {
        this.eventRepository = eventRepository;
        this.powerStationRepository = powerStationRepository;
        this.mapper = mapper;
    }

    @Override
    public Collection<FullEventDto> getAllEventDto() {

        List<Event> events = eventRepository.findAll();
        List<FullEventDto> eventsDto = new ArrayList<>();

        for (Event event: events) {

            FullEventDto fullevent = new FullEventDto();

            fullevent.setPsId(event.getStation().getId());
            fullevent.setPsName(event.getStation().getName());
            fullevent.setPsPower(event.getStation().getPower());

            fullevent.setId(event.getId());
            fullevent.setEventType(event.getEventType());
            fullevent.setPowerLoss(event.getPowerLoss());
            fullevent.setEndDate(event.getEndDate());
            fullevent.setStartDate(event.getStartDate());

            System.out.println(fullevent.toString());

            eventsDto.add(fullevent);
        }
        return eventsDto;

    }
}
