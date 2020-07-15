package alla.shtokal.rabitmq;

import alla.shtokal.dto.foreigndto.event.TaskDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
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



  @RabbitListener(queues = {"app","app2"})
  public void worker11(String message) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      TaskDTO taskDTO = objectMapper.readValue(message, TaskDTO.class);
      log.info("accepted on app1 : " + taskDTO.toString());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }



}
