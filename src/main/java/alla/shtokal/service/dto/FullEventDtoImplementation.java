package alla.shtokal.service.dto;

import alla.shtokal.dto.foreigndto.event.EventDTO;
import alla.shtokal.dto.mydto.FullEventDto;
import alla.shtokal.model.Event;
import alla.shtokal.model.PowerStation;
import alla.shtokal.repository.EventRepository;
import alla.shtokal.repository.PowerStationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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
    public FullEventDto getEventById(Long id) {
        Optional<Event> event = eventRepository.findById(id);

        FullEventDto fullEventDto = new FullEventDto();

        fullEventDto.setId(event.get().getId());
        fullEventDto.setEventType(event.get().getEventType());
        fullEventDto.setPowerLoss(event.get().getPowerLoss());

//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date(event.get().getStartDate().getTime()));
//        fullEventDto.setStartDate(c);

        fullEventDto.setStartDate(new Date(event.get().getStartDate().getTime()));

        //fullEventDto.setEndDate(event.get().getEndDate().toLocalDateTime());
        fullEventDto.setEndDate(new Date(event.get().getEndDate().getTime()));

//        fullEventDto.setEndDate( event.get().getEndDate());
//        fullEventDto.setStartDate(event.get().getStartDate());

        fullEventDto.setPsPower(event.get().getStation().getPower());
        fullEventDto.setPsName(event.get().getStation().getName());
        fullEventDto.setPsId(event.get().getStation().getId());

        return fullEventDto;

    }

    //save all fulleventdTOS
//    @Override
//    @Transactional
//    public List<EventDTO> addll() {
//
//        List<EventDTO> eventsDto = eventRepository.;
//        List<Event> eventsE = new ArrayList<>();
//
//        for (EventDTO e : awaria) {
//            Optional<PowerStation> p = powerStationRepository.findFirstByName(e.getNamePowerStation());
//            p.ifPresentOrElse(powerStation -> {
//                Event event = new Event(p.get(),
//                        e.getTaskType().toString(),
//                        e.getPowerLoss().intValue(),
//                        e.getStartDate(),
//                        e.getEndDate());
//                eventsE.add(event);
//            }, () -> log.info("Nie udało się"));
//
//        }
//
//        return eventRepository.saveAll(eventsE);
//
//    }

    @Override
    public Collection<FullEventDto> getAllEventDto() {

        List<Event> events = eventRepository.findAll();
        List<FullEventDto> eventsDto = new ArrayList<>();

        for (Event event : events) {

            FullEventDto fullevent = new FullEventDto();

            fullevent.setPsId(event.getStation().getId());
            fullevent.setPsName(event.getStation().getName());
            fullevent.setPsPower(event.getStation().getPower());

            fullevent.setId(event.getId());
            fullevent.setEventType(event.getEventType());
            fullevent.setPowerLoss(event.getPowerLoss());

            fullevent.setEndDate( event.getEndDate());
            fullevent.setStartDate(event.getStartDate());


            System.out.println(fullevent.toString());

            eventsDto.add(fullevent);
        }
        return eventsDto;

    }
}
