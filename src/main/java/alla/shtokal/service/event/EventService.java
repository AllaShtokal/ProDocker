package alla.shtokal.service.event;
import alla.shtokal.model.Event;

import java.util.Collection;
import java.util.List;


public interface EventService {
    List<Event> addll();
    Event getById(Long id);
    void add(Event event);
    void delete(Long id);
    Collection<Event> getAllEvents();
    int getNumberOfAwariaEventsById(Long id);

}
