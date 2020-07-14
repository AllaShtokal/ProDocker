package alla.shtokal.service.dto;

import alla.shtokal.dto.foreigndto.event.EventDto;
import alla.shtokal.dto.mydto.FullEventDto;
import alla.shtokal.model.Event;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface FullEventDtoService {
    Collection<FullEventDto> getAllEventDto();
}
