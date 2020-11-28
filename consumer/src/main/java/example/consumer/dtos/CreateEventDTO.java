package example.consumer.dtos;

import example.consumer.visitor.EventVisitor;

public class CreateEventDTO extends EventDTO {

    private String username;

    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CreateEventDTO{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }

    @Override
    public void accept(EventVisitor eventVisitor) {
        eventVisitor.visit(this);
    }
}
