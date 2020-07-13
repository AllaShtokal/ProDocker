package alla.shtokal.service;

import alla.shtokal.model.Event;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface EventDtoService {
    Collection<Event> getAllEventDto();
}
