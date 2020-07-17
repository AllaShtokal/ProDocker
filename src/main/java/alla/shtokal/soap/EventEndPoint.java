package alla.shtokal.soap;


import alla.shtokal.dto.mydto.FullEventDto;
import alla.shtokal.service.EventImplementation;
import alla.shtokal.service.dto.FullEventDtoImplementation;
import com.alla.getallevents.GetAllEventsRequest;
import com.alla.getallevents.GetAllEventsResponse;

import com.alla.getevent.Event;
import com.alla.getevent.GetEventByIdRequest;
import com.alla.getevent.GetEventResponse;
import org.modelmapper.ModelMapper;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class EventEndPoint {

    private final FullEventDtoImplementation fullEventService;
    private final EventImplementation eventImplementation;
    private final ModelMapper modelMapper;

    public EventEndPoint(FullEventDtoImplementation eventService, EventImplementation eventImplementation, ModelMapper modelMapper) {
        this.fullEventService = eventService;
        this.eventImplementation = eventImplementation;
        this.modelMapper = modelMapper;
    }


    @PayloadRoot(namespace = "http://alla.com/getevent",localPart = "getEventByIdRequest")
    @ResponsePayload
    public GetEventResponse getEventById(@RequestPayload GetEventByIdRequest getEvent){
        FullEventDto eventById = fullEventService.getEventById( getEvent.getId());
        GetEventResponse getEventResponse = new GetEventResponse();
        getEventResponse.setEvent(modelMapper.map(eventById, Event.class));
        return getEventResponse;
    }

    @PayloadRoot(namespace = "http://alla.com/getallevents",localPart = "getAllEventsRequest")
    @ResponsePayload
    public GetAllEventsResponse getAllEvents(@RequestPayload GetAllEventsRequest getAllEvents){
        List<FullEventDto> eventList = new ArrayList<>();

        eventList = (List<FullEventDto>) fullEventService.getAllEventDto();
        GetAllEventsResponse getAllEventsResponse = new GetAllEventsResponse();
        List<com.alla.getallevents.Event> collect = eventList.stream().map(fullEventDto -> {
            com.alla.getallevents.Event map = modelMapper.map(fullEventDto, com.alla.getallevents.Event.class);
            return map;
        }).collect(Collectors.toList());

        List<com.alla.getallevents.Event> mylist = getAllEventsResponse.getMylist();
        mylist.addAll(collect);

        return getAllEventsResponse;
    }


}
