package alla.shtokal.rest;

import alla.shtokal.anotations.LogController;
import alla.shtokal.dto.mydto.EventDTO;
import alla.shtokal.service.dto.EventDTOService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<EventDTO>> getAll() {


        List<EventDTO> events = (List<EventDTO>) this.eventDTOService.getAll();

        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(events, HttpStatus.OK);
    }


    /**
     * getEventDTOById
     **/
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<EventDTO>> getById(@PathVariable("id") Long eventId) {
        if (eventId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EventDTO event = this.eventDTOService.getById(eventId);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<EventDTO> list = new ArrayList<>();
        list.add(event);
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    /**
     * add new object
     **/
    @PostMapping(value = "")
    public ResponseEntity<EventDTO> save(@RequestBody EventDTO eventDTO) {

        HttpHeaders headers = new HttpHeaders();
        Long id = this.eventDTOService.add(eventDTO);


        EventDTO eventById = eventDTOService.getById(id);



        return new ResponseEntity<>(eventById, headers, HttpStatus.CREATED);
    }

    /**
     * delete ById
     **/

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EventDTO> delete(@PathVariable("id") Long id) {
        EventDTO eventDTO = this.eventDTOService.getById(id);

        if (eventDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.eventDTOService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
