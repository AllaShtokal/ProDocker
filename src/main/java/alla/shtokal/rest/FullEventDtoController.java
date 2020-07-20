package alla.shtokal.rest;

import alla.shtokal.anotations.LogController;
import alla.shtokal.dto.foreigndto.event.AllEventsDto;
import alla.shtokal.dto.mydto.FullEventDto;
import alla.shtokal.model.Event;
import alla.shtokal.service.PowerStationService;
import alla.shtokal.service.dto.FullEventDtoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping(value ="/api/v1/events/fullevent")
public class FullEventDtoController {

    private FullEventDtoService fullEventDtoService;
    private PowerStationService powerStationService;

    public FullEventDtoController(FullEventDtoService fullEventDtoService,PowerStationService powerStationService) {
        this.fullEventDtoService = fullEventDtoService;
        this.powerStationService = powerStationService;
    }

    //getAllEventDtos
    @LogController
    @GetMapping(value = "/fullinfo")
    public ResponseEntity<List<FullEventDto>> getAllEventsDto() {


        List<FullEventDto> events = (List<FullEventDto>) this.fullEventDtoService.getAllEventDto();

        //events.forEach(System.out::println);


        if (events.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    //getFullEventById
    @GetMapping(value = "/fullinfo/{id}")
    public ResponseEntity<FullEventDto> getFullEvent(@PathVariable("id") Long eventId) {
        if (eventId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        FullEventDto event = this.fullEventDtoService.getEventById(eventId);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(event, HttpStatus.OK);

    }

//    //POST add new object
//    @PostMapping(value = "/add")
//    public ResponseEntity<FullEventDto> saveStation(@RequestBody FullEventDto fullEvent) {
//
//        HttpHeaders headers = new HttpHeaders();
//        if (fullEvent == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        this.fullEventDtoService.(fullEvent);
//        return new ResponseEntity<>(event, headers, HttpStatus.CREATED);
//    }

}
