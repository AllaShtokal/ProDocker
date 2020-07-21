package alla.shtokal.rest;

import alla.shtokal.anotations.LogController;
import alla.shtokal.dto.mydto.EventDTO;
import alla.shtokal.service.dto.EventDTOService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping(value = "/api/v1/events/eventsdto")
public class EventDTORestController {

    private EventDTOService eventDTOService;

    public EventDTORestController(EventDTOService eventDTOService) {
        this.eventDTOService = eventDTOService;
    }

    /**
     * getAllEventsDtos
     **/

    @LogController
    @GetMapping(value = "")
    public ResponseEntity<List<EventDTO>> getAllEventsDTO() {


        List<EventDTO> events = (List<EventDTO>) this.eventDTOService.getAllEventDto();

        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(events, HttpStatus.OK);
    }


    /**
     * getEventDTOById
     **/
    @GetMapping(value = "/{id}")
    public ResponseEntity<EventDTO> getEventDTO(@PathVariable("id") Long eventId) {
        if (eventId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EventDTO event = this.eventDTOService.getEventById(eventId);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(event, HttpStatus.OK);

    }

    /**
     * add new object
     **/
    @PostMapping(value = "")
    public ResponseEntity<EventDTO> saveEvent(@RequestBody EventDTO eventDTO) {

        HttpHeaders headers = new HttpHeaders();
        Long id = this.eventDTOService.add(eventDTO);

        EventDTO eventById = eventDTOService.getEventById(id);


        return new ResponseEntity<>(eventById, headers, HttpStatus.CREATED);
    }

    /**
     * delete ById
     **/

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EventDTO> deleteEvent(@PathVariable("id") Long id) {
        EventDTO eventDTO = this.eventDTOService.getEventById(id);

        if (eventDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.eventDTOService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
