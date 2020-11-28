package example.consumer.visitor;

import example.consumer.dtos.*;

public interface EventVisitor {

    void visit(DeleteEventDTO deleteEventDTO);

    void visit(CreateEventDTO createEventDTO);

    void visit(UpdateEventDTO updateEventDTO);

    void visit(GenericEventDTO genericEventDTO);
}

