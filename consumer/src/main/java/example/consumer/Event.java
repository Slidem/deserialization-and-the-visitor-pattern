package example.consumer;

import example.consumer.dtos.EventDTO;
import org.springframework.context.ApplicationEvent;

public class Event extends ApplicationEvent {

    private final EventDTO eventDTO;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public Event(Object source, EventDTO eventDTO) {
        super(source);
        this.eventDTO = eventDTO;
    }

    public EventDTO getEventDTO() {
        return this.eventDTO;
    }
}
