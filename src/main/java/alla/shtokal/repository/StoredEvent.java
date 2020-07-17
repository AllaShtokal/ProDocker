package alla.shtokal.repository;


import alla.shtokal.dto.foreigndto.event.AllEventsDto;
import com.alla.getallevents.GetAllEventsRequest;
import com.alla.getallevents.GetAllEventsResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import s0314.gettask.GetAllTasksRequest;
import s0314.gettask.GetAllTasksResponse;

@FeignClient(name = "simple-client", url = "http://localhost:9966", configuration = MySoapClientConfiguration.class)
public interface StoredEvent {

    @Headers("")
    @GetMapping(value = "/power/api/tasks")
    AllEventsDto getStores( );

//    @PostMapping(value = "/power/ws", consumewss = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
//    GetAllTasksResponse showResponseAllTasks(GetAllTasksRequest getAllTasksRequest);

    @PostMapping(value = "/ws", consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    GetAllEventsResponse showResponseAllEvents(GetAllEventsRequest getAllEventsRequest);


}
