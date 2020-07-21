package alla.shtokal.service.dto;

import alla.shtokal.dto.mydto.EventDTO;
import alla.shtokal.model.Event;

import java.util.Collection;


public interface EventDTOService {
    Collection<EventDTO> getAllEventDto();
    EventDTO getEventById(Long id);
    Long add(EventDTO event);
    void delete(Long id);
}
