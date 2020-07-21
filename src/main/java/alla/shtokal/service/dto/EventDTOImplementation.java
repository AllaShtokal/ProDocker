package alla.shtokal.service.dto;

import alla.shtokal.dto.mydto.EventDTO;
import alla.shtokal.model.Event;
import alla.shtokal.model.PowerStation;
import alla.shtokal.repository.EventRepository;
import alla.shtokal.repository.PowerStationRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

@Service
@Log4j2
public class EventDTOImplementation implements EventDTOService {


    private EventRepository eventRepository;
    private PowerStationRepository powerStationRepository;
    private final ModelMapper mapper;

    public EventDTOImplementation(EventRepository eventRepository, PowerStationRepository powerStationRepository, ModelMapper mapper) {
        this.eventRepository = eventRepository;
        this.powerStationRepository = powerStationRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Long add(EventDTO eventDTO) {

        Optional<PowerStation> p = powerStationRepository.findById(eventDTO.getPsId());
        Event e = mapper.map(eventDTO, Event.class);
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
        Optional<Event> event = Optional.ofNullable(eventRepository.findById(id).orElse(null));

        EventDTO eventDTO = new EventDTO();

        eventDTO.setId(event.get().getId());
        eventDTO.setEventType(event.get().getEventType());
        eventDTO.setPowerLoss(event.get().getPowerLoss());
        eventDTO.setStartDate(event.get().getStartDate());
        eventDTO.setEndDate(event.get().getEndDate());

        eventDTO.setPsPower(event.get().getStation().getPower());
        eventDTO.setPsName(event.get().getStation().getName());
        eventDTO.setPsId(event.get().getStation().getId());

        return eventDTO;

    }

    //save all eventdTOS from Mateusz
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
    public Collection<EventDTO> getAllEventDto() {

        List<Event> events = eventRepository.findAll();
        List<EventDTO> eventsDto = new ArrayList<>();

        for (Event event : events) {

            EventDTO fullevent = new EventDTO();

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
