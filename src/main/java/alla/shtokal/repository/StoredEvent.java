package alla.shtokal.repository;


import alla.shtokal.dto.AllEventsDto;
import alla.shtokal.dto.EventDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@FeignClient(name = "simple-client", url = "http://S0314:8085")
public interface StoredEvent {

    @GetMapping( value = "/power/api/tasks")
    public AllEventsDto getStores();


}
