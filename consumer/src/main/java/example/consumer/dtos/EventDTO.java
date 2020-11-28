package example.consumer.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import example.consumer.visitor.EventVisitor;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;

/**
 * We are using jackson to deserialize the events based
 * on the evenType discriminator.
 *
 * Invalid event types are defaulted to GenericEventDTO
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = PROPERTY, property = "eventType", visible = true, defaultImpl = GenericEventDTO.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateEventDTO.class, name = "CREATE"),
        @JsonSubTypes.Type(value = DeleteEventDTO.class, name = "DELETE"),
        @JsonSubTypes.Type(value = UpdateEventDTO.class, name = "UPDATE"),
})
public abstract class EventDTO {

    protected String eventType;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @JsonIgnore
    public abstract void accept(EventVisitor eventVisitor);
}
