package alla.shtokal.elasticsearch;

import alla.shtokal.dto.mydto.EventDTO;

import java.util.Collection;


public interface EventDTOElasticSearchService {

    Collection<EventDTO> getAll();
    EventDTO getById(Long id);
    Long add();
    void delete(Long id);

}
