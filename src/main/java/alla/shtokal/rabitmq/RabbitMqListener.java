package alla.shtokal.rabitmq;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class RabbitMqListener {


  @RabbitListener(queues = "q1" )
  public void worker1(List<Object> message) throws InterruptedException {

    //Thread.sleep(10000);
    log.info("Received on worker : " + message.toString());
    //return "Received on worker : " + message.toString()     ;
  }
}
