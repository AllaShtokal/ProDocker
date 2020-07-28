package alla.shtokal.repository;


import alla.shtokal.dto.foreigndto.event.AllTasksDTO;
import com.alla.getallevents.GetAllEventsRequest;
import com.alla.getallevents.GetAllEventsResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Profile("feign")
@FeignClient(name = "simple-client", url = "http://localhost:9966", configuration = MySoapClientConfiguration.class)
public interface StoredEvent {

    @Headers("")
    @GetMapping(value = "/power/api/tasks")
    AllTasksDTO getStores( );

//    @PostMapping(value = "/power/ws", consumewss = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
//    GetAllTasksResponse showResponseAllTasks(GetAllTasksRequest getAllTasksRequest);

    @PostMapping(value = "/ws", consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    GetAllEventsResponse showResponseAllEvents(GetAllEventsRequest getAllEventsRequest);


}
