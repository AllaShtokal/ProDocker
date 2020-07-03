package alla.shtokal.service;
import alla.shtokal.model.Event;

import java.util.Collection;


public interface EventService {
    Event getById(Long id);
    void add(Event event);
    void delete(Long id);
    Collection<Event> getAllEvents();
    int getNumberOfAwariaEventsById(Long id);

}
