package alla.shtokal.rest;

import alla.shtokal.anotations.LogController;
import alla.shtokal.dto.foreigndto.event.AllTasksDTO;
import alla.shtokal.model.Event;
import alla.shtokal.model.PowerStation;
import alla.shtokal.repository.StoredEvent;
import alla.shtokal.service.event.EventService;
import alla.shtokal.service.station.PowerStationService;
import com.alla.getallevents.GetAllEventsRequest;
import com.alla.getallevents.GetAllEventsResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping(value = "/api/v1/events")
public class EventRestController {


    private final EventService eventService;
    private final PowerStationService powerStationService;
    private final StoredEvent storedEvent;


    public EventRestController(EventService eventService,
                               PowerStationService powerStationService,
                               StoredEvent storedEvent) {
        this.eventService = eventService;
        this.powerStationService = powerStationService;
        this.storedEvent = storedEvent;
    }

    /**
     * get ById
     **/
    @GetMapping(value = "/{id}")
    public ResponseEntity<Event> getByID(@PathVariable("id") Long eventId) {
        if (eventId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Event event = this.eventService.getById(eventId);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(event, HttpStatus.OK);

    }


    /**
     * get All
     **/
    @LogController
    @GetMapping(value = "")
    public ResponseEntity<List<Event>> getAll() {
        List<Event> events = (List<Event>) this.eventService.getAll();


        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }


    /**
     *  add new object
     **/
    @PostMapping(value = "/add")
    public ResponseEntity<Event> save(@RequestBody Event event, @RequestParam("id") Long id) {
        event.setStation(this.powerStationService.getById(id));
        HttpHeaders headers = new HttpHeaders();
        this.eventService.add(event);
        return new ResponseEntity<>(event, headers, HttpStatus.CREATED);
    }

    /**
     * delete ById
     **/

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PowerStation> delete(@PathVariable("id") Long id) {
        Event event = this.eventService.getById(id);

        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.eventService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * API just for Test
     **/


    @GetMapping(value = "/test")
    public AllTasksDTO test() {

        return storedEvent.getStores();
    }


    //Add from Mateusz
    @GetMapping(value = "/addfrom")
    public ResponseEntity<List<Event>> getAllAdded() {
        List<Event> events = this.eventService.addll();

        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }


//    @GetMapping(value= "/test2")
//    public List<TaskXML> test2(){
//
//        GetAllTasksRequest getAllTasksRequest = new GetAllTasksRequest();
//        GetAllTasksResponse getAllTasksResponse = storedEvent.showResponseAllTasks(getAllTasksRequest);
//        log.info("getTaskXMLS().size()"+ getAllTasksResponse.getTasks().size());
//        return getAllTasksResponse.getTasks();
//    }

    @GetMapping(value = "/test3")
    public List<com.alla.getallevents.Event> test3() {

        GetAllEventsRequest getAllEventsRequest = new GetAllEventsRequest();
        GetAllEventsResponse getAllTasksResponse = storedEvent.showResponseAllEvents(getAllEventsRequest);
        log.info("getMylist().size()" + getAllTasksResponse.getMylist().size());
        return getAllTasksResponse.getMylist();
    }


}
