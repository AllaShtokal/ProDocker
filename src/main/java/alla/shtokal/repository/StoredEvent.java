package alla.shtokal.repository;


import alla.shtokal.dto.foreigndto.event.AllEventsDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "simple-client", url = "http://S0314:9966")
public interface StoredEvent {

    @Headers("")
    @GetMapping( value = "/power/api/tasks")
    public AllEventsDto getStores();

//    @PostMapping(value = "", consumes = MediaType.TEXT_HTML_VALUE, produces = MediaType.TEXT_XML_VALUE)
//    AddResponse calculate(@RequestBody Add addRequest);


}
