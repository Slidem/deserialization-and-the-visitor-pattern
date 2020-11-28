package example.consumer.dtos;

import example.consumer.visitor.EventVisitor;

public class UpdateEventDTO extends EventDTO {

    private String userId;

    private String newUsername;

    private String newAddress;

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UpdateEventDTO{" +
                "userId='" + userId + '\'' +
                ", newUsername='" + newUsername + '\'' +
                ", newAddress='" + newAddress + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }

    @Override
    public void accept(EventVisitor eventVisitor) {
        eventVisitor.visit(this);
    }
}
