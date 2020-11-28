package example.consumer;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Simple configuration, declares test queue if non exists
 */
@Configuration
public class MessagingConfiguration {

    @Value("${message.queueName}")
    private String queueName;

    @Bean
    public Queue exampleQueue() {
        return new Queue(queueName, false);
    }

}
