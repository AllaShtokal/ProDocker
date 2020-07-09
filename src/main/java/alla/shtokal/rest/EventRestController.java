package alla.shtokal.rest;

import alla.shtokal.model.Event;
import alla.shtokal.model.PowerStation;
import alla.shtokal.service.EventService;
import alla.shtokal.service.PowerStationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventRestController {


    private final EventService eventService;
    private final PowerStationService powerStationService;

    public EventRestController(EventService eventService, PowerStationService powerStationService) {
        this.eventService = eventService;
        this.powerStationService = powerStationService;
    }

    //getById
    @GetMapping(value = "/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable("id") Long eventId) {
        if (eventId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Event event = this.eventService.getById(eventId);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(event, HttpStatus.OK);

    }

    //getAll
    @GetMapping(value = "")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = (List<Event>) this.eventService.getAllEvents();

        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    //POST add new object
    @PostMapping(value = "/add")
    public ResponseEntity<Event> saveStation(@RequestBody Event event, @RequestParam("id") Long id) {
        event.setStation(this.powerStationService.getById(id));
        HttpHeaders headers = new HttpHeaders();
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.eventService.add(event);
        return new ResponseEntity<>(event, headers, HttpStatus.CREATED);
    }

    //deleteById
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PowerStation> deleteEvent(@PathVariable("id") Long id) {
        Event event = this.eventService.getById(id);

        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.eventService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
