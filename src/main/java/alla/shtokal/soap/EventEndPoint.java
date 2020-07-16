package alla.shtokal.soap;


import alla.shtokal.dto.mydto.FullEventDto;
import alla.shtokal.service.EventImplementation;
import alla.shtokal.service.dto.FullEventDtoImplementation;
import alla.shtokal.soap.getAllEvents.GetAllEventsRequest;
import alla.shtokal.soap.getAllEvents.GetAllEventsResponse;
import alla.shtokal.soap.getEvent.GetEventByIdRequest;
import alla.shtokal.soap.getEvent.GetEventResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class EventEndPoint {

    private final FullEventDtoImplementation fullEventService;
    private final EventImplementation eventImplementation;

    public EventEndPoint(FullEventDtoImplementation eventService, EventImplementation eventImplementation) {
        this.fullEventService = eventService;
        this.eventImplementation = eventImplementation;
    }


    @PayloadRoot(namespace = "http://alla.com/getevent",localPart = "getEventByIdRequest")
    @ResponsePayload
    public GetEventResponse getEventById(@RequestPayload GetEventByIdRequest getEvent){
        FullEventDto eventById = fullEventService.getEventById( getEvent.getId());
        GetEventResponse getEventResponse = new GetEventResponse();
        getEventResponse.setEvent(eventById);
        return getEventResponse;
    }

    @PayloadRoot(namespace = "http://alla.com/getevent",localPart = "getAllEventsRequest")
    @ResponsePayload
    public GetAllEventsResponse getAllEvents(@RequestPayload GetAllEventsRequest getAllEvents){
        List<FullEventDto> eventList = new ArrayList<>();

        eventList = (List<FullEventDto>) fullEventService.getAllEventDto();
        GetAllEventsResponse getAllEventsResponse = new GetAllEventsResponse();
        List<FullEventDto> mylist = getAllEventsResponse.getMylist();
        mylist.addAll(eventList);

        return getAllEventsResponse;
    }


}
