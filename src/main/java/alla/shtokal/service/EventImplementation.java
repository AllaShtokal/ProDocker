package alla.shtokal.service;

import alla.shtokal.dto.AllEventsDto;
import alla.shtokal.dto.EventDto;
import alla.shtokal.model.Event;
import alla.shtokal.model.PowerStation;
import alla.shtokal.repository.EventRepository;
import alla.shtokal.repository.PowerStationRepository;
import alla.shtokal.repository.StoredEvent;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventImplementation implements EventService {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    PowerStationRepository powerStationRepository;

    @Autowired
    StoredEvent storedEvent;




    @Override
    public Event getById(Long id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public void add(Event event) {
        eventRepository.save(event);

    }

    @Override
    @Transactional
    public List<Event> addll() {
        //System.out.println(storedEvent.getStores().getEmpty());

//        RestTemplate restTemplate = new RestTemplate();
//        String Url
//                = "http://S0314:8085/power/api/tasks/?page=0&size=30";
//        ResponseEntity<AllEventsDto> forEntity = restTemplate.getForEntity(Url, AllEventsDto.class);
//
//        List<EventDto> awaria = forEntity.getBody().getContent()
//                .stream().peek(eventDto -> System.out.println(eventDto.getNamePowerStation()))
//                .filter(eventDto -> eventDto.getTaskType().toString().equals("AWARIA")).limit(100)
//                .collect(Collectors.toList());
//
        ArrayList<EventDto> awaria = storedEvent.getStores().getContent();
        List<Event> eventsE = new ArrayList<>();

        for (EventDto e : awaria) {
            Optional<PowerStation> p = powerStationRepository.findFirstByName(e.getNamePowerStation());
            p.ifPresentOrElse(powerStation -> {
                Event event = new Event(p.get(),
                        e.getTaskType().toString(),
                        e.getPowerLoss(),
                        e.getStartDate(),
                        e.getEndDate());
                eventsE.add(event);
            }, () -> System.out.println("Nie udało się"));

        }

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
