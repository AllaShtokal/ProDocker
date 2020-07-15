package alla.shtokal;

import alla.shtokal.dto.foreigndto.event.AllEventsDto;
import alla.shtokal.dto.foreigndto.event.EventDTO;
import alla.shtokal.model.Event;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class EventsRepositoryIntegrationTest {

    public static class Dog {
        public String message;
        public String status;


        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    @Test
    @Disabled("")
    public void test1() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://dog.ceo/api/breeds/image/random";
        ResponseEntity<Dog> forEntity = restTemplate.getForEntity(fooResourceUrl, Dog.class);
        System.out.println(forEntity.getBody().getStatus());

    }

    @Test @Disabled("")
    public void test2() {
        RestTemplate restTemplate = new RestTemplate();
        String Url
                = "http://S0314:8085/power/api/tasks/?page=0&size=30";
        ResponseEntity<AllEventsDto> forEntity = restTemplate.getForEntity(Url, AllEventsDto.class);

        List<EventDTO> awaria = forEntity.getBody().getContent()
                .stream().peek(eventDto -> System.out.println(eventDto.getNamePowerStation()))
                .filter(eventDto -> eventDto.getTaskType().toString().equals("AWARIA")).limit(100)
                .collect(Collectors.toList());


//        List<Event> eventsE = new ArrayList<>();
//        for (EventDto e : awaria) {
//           // PowerStation p = powerStationRepository.findFirstByName(e.getNamePowerStation());
//            if (p != null) {
//                Event event = new Event(p, e.getTaskType().toString(), e.getPowerLoss(), e.getStartDate(), e.getEndDate());
//                eventsE.add(event);
//            }
//        }


    }

    @Test
    @Disabled("")
    public void testAddEvent() {
        MultiValueMap<String, String> mapauth = new LinkedMultiValueMap<>();
        List<String> strings = List.of("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJzdGF0aW9uczp3cml0ZSJ9LHsiYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9LHsiYXV0aG9yaXR5IjoiZXZlbnRzOnJlYWQifSx7ImF1dGhvcml0eSI6ImV2ZW50czp3cml0ZSJ9LHsiYXV0aG9yaXR5Ijoic3RhdGlvbnM6cmVhZCJ9XSwiaWF0IjoxNTk0MjkzNDY1LCJleHAiOjE1OTUxMDk2MDB9.Fk_PnPYyFC6-Rnf0Twi5RHalo_b6wYTexjswL6sM1o5Wv-RnlxYAGifshw-ctv5qcdhTnn1FxmgDd8Jr0Vuu9A");
        mapauth.put("Authorization", strings);
        String url
                = "http://localhost:9966/management/api/v1/events/add?id=5";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Event> request = new HttpEntity<>(new Event("AWARIA11",
                500,
                java.sql.Timestamp.valueOf(LocalDateTime.now()),
                java.sql.Timestamp.valueOf(LocalDateTime.now())), mapauth);

        Event body = restTemplate.exchange(url, HttpMethod.POST, request, Event.class).getBody();
        System.out.println(body.getPowerLoss());


    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testRabbit() {

        rabbitTemplate.convertAndSend("eggs", "message11");


    }


}
