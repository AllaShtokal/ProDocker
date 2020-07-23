package alla.shtokal.rest

import alla.shtokal.dto.mydto.EventDTO
import alla.shtokal.service.dto.EventDTOService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import java.sql.Timestamp


class EventDTORestControllerSpec extends Specification {

    EventDTORestController eventDTORestController;
    MockMvc mockMvc;

    EventDTOService eventDTOService;

    ObjectMapper mapper = new ObjectMapper()
    def requestUri = '/api/v1/events/eventsdto'

    EventDTO ev1
    EventDTO ev2
    EventDTO ev3

    String ev1JsonString
    String ev2JsonString
    String ev3JsonString

    void setup() {

        eventDTOService = Mock(EventDTOService)

        eventDTORestController = new EventDTORestController(eventDTOService)
        mockMvc = MockMvcBuilders
                .standaloneSetup(eventDTORestController)
                .alwaysDo(MockMvcResultHandlers.print())
                .build()

        ev1 = new EventDTO(["id"       : 10,
                            "eventType": "AWARIA",
                            "powerLoss": 500,
                            "startDate": Timestamp.valueOf("2020-05-01 00:00:00"),
                            "endDate": Timestamp.valueOf("2020-05-01 00:00:00"),
                            "psId"     : 1,
                            "psName"   : "Pierwsza",
                            "psPower"  : 12000])
        ev2 = new EventDTO(["id"       : 11,
                            "eventType": "AWARIA",
                            "powerLoss": 500,
                            "startDate": Timestamp.valueOf("2020-05-01 00:00:00"),
                            "endDate": Timestamp.valueOf("2020-05-01 00:00:00"),
                            "psId"     : 1,
                            "psName"   : "Pierwsza2",
                            "psPower"  : 12000])
        ev3 = new EventDTO(["id"       : 10,
                         "eventType": "500",
                          "powerLoss": 5000,
                         "startDate": Timestamp.valueOf("2020-05-01 00:00:00"),
                         "endDate": Timestamp.valueOf("2020-05-01 00:00:00")])



        ev1JsonString = mapper.writeValueAsString(ev1)
        ev2JsonString = mapper.writeValueAsString(ev2)
        ev3JsonString = mapper.writeValueAsString(ev3)

    }

    void 'getAllEventDto api should return a list of events'() {

        given:
        eventDTOService.getAll() >> [ev1, ev2]

        and:
        def response = [ev1JsonString, ev2JsonString].toString()

        expect:
        mockMvc.perform(MockMvcRequestBuilders
                .get(requestUri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(response))
    }

    void 'getEventDTOById  should return eventDTO by id'() {

        given:
        eventDTOService.getById(1) >> ev1

        expect:
        mockMvc.perform(MockMvcRequestBuilders
                .get(requestUri + '/{id}', 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(ev1JsonString))
    }

    void '/add  should add  and return added event'() {

        given:
        eventDTOService.add(_ as EventDTO) >> 10
        eventDTOService.getById(10) >> ev3

        expect:
        mockMvc.perform(MockMvcRequestBuilders
                .post(requestUri).contentType(MediaType.APPLICATION_JSON).content(ev3JsonString))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(ev3JsonString))
    }


    void '/delete  should delete event'() {

        given:
        eventDTOService.getById(1) >> ev1
        eventDTOService.delete(1) >> null

        expect:
        mockMvc.perform(MockMvcRequestBuilders
                .delete(requestUri + '/{id}',1))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
    }

}


