package example.consumer.visitor;

import example.consumer.dtos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuditingEventVisitor implements EventVisitor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void visit(DeleteEventDTO deleteEventDTO) {

        mockAuditing(deleteEventDTO);
    }

    @Override
    public void visit(CreateEventDTO createEventDTO) {

        mockAuditing(createEventDTO);
    }

    @Override
    public void visit(UpdateEventDTO updateEventDTO) {

        mockAuditing(updateEventDTO);
    }

    @Override
    public void visit(GenericEventDTO genericEventDTO) {

        mockAuditing(genericEventDTO);
    }

    private void mockAuditing(EventDTO eventDTO) {
        logger.info("Auditing event {}", eventDTO);
    }
}
