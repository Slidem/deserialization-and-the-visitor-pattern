package example.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceMessage {

    private final MessageSender messageSender;

    public ProduceMessage(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostMapping("/produce")
    public String produceMessage(@RequestBody EventDTO eventDTO) throws JsonProcessingException {
        messageSender.sendMessage(eventDTO);
        return "Message sent ";
    }

}
