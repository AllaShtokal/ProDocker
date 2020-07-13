package alla.shtokal.repository;


import alla.shtokal.dto.foreigndto.event.AllEventsDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



@FeignClient(name = "simple-client", url = "http://S0314:8085")
public interface StoredEvent {

    @Headers("")
    @GetMapping( value = "/power/api/tasks")
    public AllEventsDto getStores();


}
