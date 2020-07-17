package alla.shtokal.repository;


import alla.shtokal.dto.foreigndto.event.AllEventsDto;
import alla.shtokal.soap.getAllEvents.GetAllEventsRequest;
import alla.shtokal.soap.getAllEvents.GetAllEventsResponse;
import alla.shtokal.soap.listtasks.GetAllTasksRequest;
import alla.shtokal.soap.listtasks.GetAllTasksResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "simple-client", url = "http://s0314:8085", configuration = MySoapClientConfiguration.class)
public interface StoredEvent {

    @Headers("")
    @GetMapping(value = "/power/api/tasks")
    AllEventsDto getStores( );

    @PostMapping(value = "/power/ws", consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    GetAllTasksResponse showResponseAllTasks(GetAllTasksRequest getAllTasksRequest);

    @PostMapping(value = "/ws", consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
   GetAllEventsResponse showResponseAllEvents(GetAllEventsRequest getAllEventsRequest);


}
