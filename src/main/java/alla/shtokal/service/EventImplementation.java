package alla.shtokal.service;

import alla.shtokal.dto.foreigndto.event.EventDTO;
import alla.shtokal.model.Event;
import alla.shtokal.repository.EventRepository;
import alla.shtokal.repository.PowerStationRepository;
import alla.shtokal.repository.StoredEvent;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Log4j2
@Service
public class EventImplementation implements EventService {


    private EventRepository eventRepository;

    @Autowired
    PowerStationRepository powerStationRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StoredEvent storedEvent;

    public EventImplementation(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public Event getById(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);

        return optionalEvent.orElseGet(Event::new);
        //eventRepository.getOne()
        //return  eventRepository.findById(id).get();
              //  eventRepository.findById(id).get();
    }

    @Override
    public void add(Event event) {
        eventRepository.save(event);

    }

    @Override
    @Transactional
    public List<Event> addll() {

        List<EventDTO> awaria = storedEvent.getStores().getContent();
        List<Event> eventsE = new ArrayList<>();

//        for (EventDto e : awaria) {
//            Optional<PowerStation> p = powerStationRepository.findFirstByName(e.getNamePowerStation());
//            p.ifPresentOrElse(powerStation -> {
//                Event event = new Event(p.get(),
//                        e.getTaskType().toString(),
//                        e.getPowerLoss(),
//                        e.getStartDate(),
//                        e.getEndDate());
//                eventsE.add(event);
//            }, () -> log.info("Nie udało się"));
//
//        }

        return eventRepository.saveAll(eventsE);

    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);

    }

    @Override
    public Collection<Event> getAllEvents() {

        return eventRepository.findAll();

    }

    /**
     * a)	Należy przygotować metodę, która zliczy ilość zdarzeń
     * typu ‘AWARIA’ dla elektrowni o zadanym ID.
     */

    @Override
    public int getNumberOfAwariaEventsById(Long id) {
        int num = 0;
        List<Event> events = (List<Event>) getAllEvents();
        for (Event item : events) {
            if (item.getStation().getId().equals(id) && item.getEventType().equals("AWARIA"))
                num++;
        }
        return num;
    }


}
