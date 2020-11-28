package example.consumer.dtos;

import example.consumer.visitor.EventVisitor;

public class DeleteEventDTO extends EventDTO {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DeleteEventDTO{" +
                "userId='" + userId + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }

    @Override
    public void accept(EventVisitor eventVisitor) {
        eventVisitor.visit(this);
    }
}
