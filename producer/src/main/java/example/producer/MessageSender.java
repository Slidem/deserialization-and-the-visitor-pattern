package example.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper;

    private final String exchangeName;

    public MessageSender(
            RabbitTemplate rabbitTemplate,
            ObjectMapper objectMapper,
            @Value("${message.exchangeName}") String exchangeName) {

        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
        this.exchangeName = exchangeName;
    }

    public void sendMessage(EventDTO eventDTO) throws JsonProcessingException {

        rabbitTemplate.convertAndSend(exchangeName, "", objectMapper.writeValueAsString(eventDTO));
    }

}
