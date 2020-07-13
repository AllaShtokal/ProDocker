package alla.shtokal.rabitmq;


import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class RabbitMqController {

    @Autowired
    RabbitTemplate template;

    @RequestMapping("/")
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

   // @Async
     public String getResponse(@PathVariable("message") String message) {
        return (String) template.convertSendAndReceive("query-example-6",message);
    }
}
