package alla.shtokal.rabitmq;

import alla.shtokal.dto.foreigndto.event.TaskDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class RabbitMqListener {

  private RabbitTemplate template;

  public RabbitMqListener(RabbitTemplate template) {
    this.template = template;

  }

//  @RabbitListener(queues = "q1" )
//  public String worker11111(String message)  {
//
//    log.info("Odczytałam :  " + message.toString());
//    return "Odczytałam : " + message.toString() ;
//  }

//  @RabbitListener(queues = "app")
//  public void worker1(String message) {
//    log.info("accepted on app : " + message);
//    //return "to jest app1";
//    //template.convertAndSend("exchange-example-3","" ,"wiadomość2222222");
//  }

//  @RabbitListener(queues = "app2")
//  public void worker2(String message) {
//    log.info("accepted on app2 : " + message);
//    //return "to jest app2";
//    //template.convertAndSend("exchange-example-3","" ,"wiadomość2222222");
//  }

  @RabbitListener(queues = "app")
  public void worker11(ObjectMapper message) {
    log.info("accepted on app2 : " + message.toString());
    //return "to jest app2";
    //template.convertAndSend("exchange-example-3","" ,"wiadomość2222222");
  }
  @RabbitListener(queues = "app2")
  public void worker22( ObjectMapper message) {
    log.info("accepted on app2 : " + message.toString());
    //return "to jest app2";
    //template.convertAndSend("exchange-example-3","" ,"wiadomość2222222");
  }


}
