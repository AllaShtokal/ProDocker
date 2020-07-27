
package alla.shtokal.elasticsearch.event;

import alla.shtokal.anotations.LogController;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
@RequestMapping(value = "/api/v1/events/search")
public class EventElasticController {

    private final EventDTOElasticSearchService eventDTOElasticSearchService;

    public EventElasticController(EventDTOElasticSearchService eventDTOService) {
        this.eventDTOElasticSearchService = eventDTOService;
    }

    /**
     * getAllEventsDtos
     **/


    @LogController
    @GetMapping(value = "/getAllFromElastic")
    public ResponseEntity<List<EventDtoElasticSearch>> getAllFromElastic() {


        List<EventDtoElasticSearch> events = (List<EventDtoElasticSearch>) this.eventDTOElasticSearchService.getAll();

        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(events, HttpStatus.OK);
    }


    /**
     * getEventDTOById
     **/
    @GetMapping(value = "/getByIdFromElastic/{id}")
    public ResponseEntity<List<EventDtoElasticSearch>> getByIdFromElastic(@PathVariable("id") Long eventId) {
        if (eventId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EventDtoElasticSearch event = this.eventDTOElasticSearchService.getById(eventId);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<EventDtoElasticSearch> list = new ArrayList<>();
        list.add(event);
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping(value = "/addAllFromJPA")
    public ResponseEntity<String> addAllFromJPA() {


        String d =  this.eventDTOElasticSearchService.add();


        return new ResponseEntity<>(d, HttpStatus.OK);
    }
}