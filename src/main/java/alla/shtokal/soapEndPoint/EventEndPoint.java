package alla.shtokal.soapEndPoint;


import alla.shtokal.dto.mydto.FullEventDto;
import alla.shtokal.service.EventImplementation;
import alla.shtokal.service.EventService;
import alla.shtokal.service.dto.FullEventDtoImplementation;
import mypackage1.GetEventByIdRequest;
import mypackage1.GetEventResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EventEndPoint {

    private final FullEventDtoImplementation eventService;

    public EventEndPoint(FullEventDtoImplementation eventService) {
        this.eventService = eventService;
    }


    @PayloadRoot(namespace = "http://alla.com/getevent",localPart = "getEventByIdRequest")
    @ResponsePayload
    public GetEventResponse getEventById(@RequestPayload GetEventByIdRequest getEvent){
        FullEventDto eventById = eventService.getEventById( getEvent.getId());
        GetEventResponse getEventResponse = new GetEventResponse();
        getEventResponse.setEvent(eventById);
        return getEventResponse;
    }


}
