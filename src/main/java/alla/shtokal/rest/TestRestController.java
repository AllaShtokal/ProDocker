package alla.shtokal.rest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/addMessage")
    public String get(@RequestParam String message) {
        rabbitTemplate.convertAndSend("eggs", message);

        return "sent";
    }


    @GetMapping("/receiveMessage")
    public String get() {
        Object message = rabbitTemplate.receiveAndConvert("eggs");
        return message.toString();
    }
}
