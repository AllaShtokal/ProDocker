package alla.shtokal.rabitmq;


import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class RabbitMqController {

    @Value("${spring.rabbitmq.username}")
    private String value;


    private RabbitTemplate template;

    public RabbitMqController(RabbitTemplate template) {
        this.template = template;
      this.template.setExchange("test-mateusz-exchange");
        this.template.setRoutingKey("foo.bar.baz");
    }



    @RequestMapping("/process")
    @ResponseBody
    String home() {
        return "Empty mapping";
    }

//    @GetMapping("/process/{message}")
//    String error(@PathVariable("message") String message) {
//
//        String response = (String) template.convertSendAndReceive("99-exchange",message);
//        return String.valueOf("returned from worker : " + response);
//    }

    @GetMapping("/test")
    public void test()
    {

        template.convertAndSend("wiadomość");

    }




}
