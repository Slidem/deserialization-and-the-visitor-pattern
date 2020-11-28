package example.consumer.visitor;

import example.consumer.Event;
import example.consumer.dtos.EventDTO;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VisitorEventListener {

    private final List<EventVisitor> eventVisitors;

    public VisitorEventListener(List<EventVisitor> eventVisitors) {
        this.eventVisitors = eventVisitors;
    }

    /**
     * This illustrates the difference when using the visitor pattern
     * Taking advantage of double polymorphism, we delegate the responsibility
     * of resolving the type of the implementation to the visitee.
     *
     * The visitee resolves then visits the accepted visitor if needed.
     *
     * The visitor (as show in {@link EventVisitor#visit} methods) overloads the visit method with
     * every concrete implementation.
     */
    @EventListener
    public void handleEvent(Event event) {
        EventDTO eventDTO = event.getEventDTO();
        eventVisitors.forEach(eventDTO::accept);
    }
}
