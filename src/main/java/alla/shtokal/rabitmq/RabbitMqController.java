package alla.shtokal.rabitmq;


import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class RabbitMqController {

    @Value("${spring.rabbitmq.username}")
    private String value;

    @Autowired
    RabbitTemplate template;

    @RequestMapping("/process")
    @ResponseBody
    String home() {
        return "Empty mapping";
    }

    @RequestMapping("/process/{message}")
    @ResponseBody
    String error(@PathVariable("message") String message) {
        log.info(String.format("Emit '%s'",message));
        String response = getResponse(message);

        log.info(String.format("Received on producer '%s'",response));
        return String.valueOf("returned from worker : " + response);
    }

    @GetMapping("/test")
    public void test()
    {
        template.convertAndSend("q1", "testowe");

    }

   // @Async
     public String getResponse(@PathVariable("message") String message) {
        return (String) template.convertSendAndReceive("q1",message);
    }
}
