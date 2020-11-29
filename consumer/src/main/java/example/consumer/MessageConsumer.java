package example.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.consumer.dtos.EventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Consumer of the rabbit mq messages.
 * The messages are deserialized into {@link EventDTO} type instances
 * and are wrapped into a spring event and published.
 */
@Service
public class MessageConsumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ObjectMapper objectMapper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public MessageConsumer(ObjectMapper objectMapper, ApplicationEventPublisher applicationEventPublisher) {
        this.objectMapper = objectMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @RabbitListener(queues = "${message.queueName}")
    public void receive(String message) {

        try {
            EventDTO eventDTO = objectMapper.readValue(message, EventDTO.class);
            applicationEventPublisher.publishEvent(new Event(this, eventDTO));
        } catch (JsonProcessingException e) {
            logger.error("Could not read message from queue.", e);
        }
    }
}
