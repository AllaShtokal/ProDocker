package alla.shtokal.rabitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitConfiguration {


    static final String queueName1 = "app";
    static final String queueName2 = "app2";

    @Bean
    public FanoutExchange fanoutExchangeA(){
        return new FanoutExchange("test-mateusz-exchange");
    }
//    @Bean
//    MessageListenerAdapter listenerAdapter(RabbitMqListener receiver) {
//        return new MessageListenerAdapter(receiver, "worker11");
//    }

//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(queueName1,queueName2);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }

    @Bean
    public Queue myQueue1() {
        return new Queue(queueName1);
    }

    //
    @Bean
    public Queue myQueue2() {
        return new Queue(queueName2);
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(myQueue1()).to(fanoutExchangeA());
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(myQueue2()).to(fanoutExchangeA());
    }


}
