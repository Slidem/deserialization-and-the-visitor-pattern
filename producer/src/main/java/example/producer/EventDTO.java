package example.producer;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class EventDTO {

    private EventType eventType;

    private Map<String, Object> details;

    public EventDTO() {
    }

    public EventDTO(EventType eventType) {
        this.eventType = eventType;
        this.details = new HashMap<>();
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @JsonAnyGetter
    public Map<String, Object> getDetails() {
        return details;
    }

    @JsonAnySetter
    public void addDetails(String key, Object value) {
        if (this.details == null) {
            this.details = new HashMap<>();
        }
        this.details.put(key, value);
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "eventType=" + eventType +
                ", details=" + details +
                '}';
    }
}
