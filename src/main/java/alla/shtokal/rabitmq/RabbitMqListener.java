package alla.shtokal.rabitmq;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class RabbitMqListener {


  @RabbitListener(queues = "query-example-6")
  public String worker1(String message) throws InterruptedException {

    Thread.sleep(10000);
    log.info("Received on worker : " + message);
    return "Received on worker : " + message;
  }
}
