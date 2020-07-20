package alla.shtokal.service.dto;

import alla.shtokal.dto.foreigndto.event.EventDTO;
import alla.shtokal.dto.mydto.FullEventDto;

import java.util.Collection;
import java.util.List;


public interface FullEventDtoService {
    Collection<FullEventDto> getAllEventDto();
    FullEventDto getEventById(Long id);
}
