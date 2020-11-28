package example.producer;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

    @Value("${message.exchangeName}")
    private String exchangeName;

    @Value("${message.queueName}")
    private String queueName;

    @Value("${message.isExampleQueueDurable}")
    private boolean isExampleQueueDurable;


    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange(exchangeName);
    }

    @Bean
    public Queue exampleQueue() {
        return new Queue(queueName, isExampleQueueDurable);
    }

    @Bean
    public Binding bindExampleQueue() {
        return BindingBuilder.bind(exampleQueue()).to(fanout());
    }

}
