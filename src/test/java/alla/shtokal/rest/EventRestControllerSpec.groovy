package alla.shtokal.rest

import alla.shtokal.dto.mydto.FullEventDto
import alla.shtokal.model.Event
import alla.shtokal.repository.EventRepository
import alla.shtokal.repository.StoredEvent
import alla.shtokal.service.EventService
import alla.shtokal.service.PowerStationService
import alla.shtokal.service.dto.FullEventDtoService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

class EventRestControllerSpec extends Specification {
    //initial setup and variables

    EventRestController eventRestController;
    MockMvc mockMvc;

    FullEventDtoService fullEventDtoService;
    EventService eventService;
    PowerStationService powerStationService;
    StoredEvent storedEvent;

    ObjectMapper mapper = new ObjectMapper()
    def requestUri = '/api/v1/events/fullinfo'

    //our data

    FullEventDto ev1
    FullEventDto ev2
    Event ev3
    String ev1JsonString
    String ev2JsonString
    String ev3JsonString

    void setup() {

        fullEventDtoService = Mock(FullEventDtoService)
        eventService = Mock(EventService)
        powerStationService = Mock(PowerStationService)
        storedEvent = Mock(StoredEvent)

        eventRestController = new EventRestController( eventService,powerStationService,
                                                       storedEvent)
        mockMvc = MockMvcBuilders
                .standaloneSetup(eventRestController)
                .alwaysDo(MockMvcResultHandlers.print())
                .build()
        ev1 = new FullEventDto(["id"       : 10,
                                "eventType": "AWARIA",
                                "powerLoss": 500,
                                "startDate": new Date(1589752800000L * 1000),
                                "endDate"  : new Date(1589925600000L * 1000),
                                "psId"     : 1,
                                "psName"   : "Pierwsza",
                                "psPower"  : 12000])
        ev2 = new FullEventDto(["id"       : 11,
                                "eventType": "AWARIA",
                                "powerLoss": 500,
                                "startDate": new Date(1589752800000L * 1000),
                                "endDate"  : new Date(1589925600000L * 1000),
                                "psId"     : 1,
                                "psName"   : "Pierwsza2",
                                "psPower"  : 12000])
        ev3 = new Event(["id":1,
                         "eventType":"AWARIA",
                         "powerLoss":500,
                         "startDate":"2020-05-18 00:00:00",
                         "endDate":"2020-05-20 00:00:00"])
        ev1JsonString = mapper.writeValueAsString(ev1)
        ev2JsonString = mapper.writeValueAsString(ev2)
        ev3JsonString = mapper.writeValueAsString(ev3)

    }

    void 'getAllEventDto api should return a list of customers'() {
        given:
        fullEventDtoService.getAllEventDto() >> [ev1, ev2]

        and:
        def response = [ev1JsonString, ev2JsonString].toString()

        expect:
        mockMvc.perform(MockMvcRequestBuilders
                .get(requestUri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(response))
    }

    void 'getEventById api should return customer by id'() {

        given:
        fullEventDtoService.getEventById(1) >> ev2

        expect:
        mockMvc.perform(MockMvcRequestBuilders
                .get(requestUri + '/{id}', 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(ev2JsonString))
    }

//    void 'save Event'() {
//        given:
//        1 * eventService.add(ev3) >> null
//
//        expect:
//        mockMvc.perform(MockMvcRequestBuilders
//                .post(requestUri).contentType("").content(ev3JsonString))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//    }


}


