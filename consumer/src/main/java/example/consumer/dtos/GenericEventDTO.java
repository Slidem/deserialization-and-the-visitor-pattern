package example.consumer.dtos;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import example.consumer.visitor.EventVisitor;

import java.util.Map;

public class GenericEventDTO extends EventDTO {

    private Map<String, String> details;

    @JsonAnyGetter
    public Map<String, String> getDetails() {
        return details;
    }

    @JsonAnyGetter
    public void addDetails(String key, String value) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "GenericEventDTO{" +
                "details=" + details +
                ", eventType='" + eventType + '\'' +
                '}';
    }

    @Override
    public void accept(EventVisitor eventVisitor) {
        eventVisitor.visit(this);
    }
}
