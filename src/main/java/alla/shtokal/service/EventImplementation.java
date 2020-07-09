package alla.shtokal.service;

import alla.shtokal.model.Event;
import alla.shtokal.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventImplementation implements EventService {

    @Autowired
    EventRepository eventRepository;


    @Override
    public Event getById(Long id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public void add(Event event) {
        eventRepository.save(event);

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
