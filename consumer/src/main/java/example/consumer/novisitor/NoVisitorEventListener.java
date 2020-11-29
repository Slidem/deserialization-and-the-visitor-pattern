package example.consumer.novisitor;

import example.consumer.Event;
import example.consumer.dtos.CreateEventDTO;
import example.consumer.dtos.EventDTO;
import example.consumer.dtos.DeleteEventDTO;
import example.consumer.dtos.UpdateEventDTO;
import example.consumer.services.CreateService;
import example.consumer.services.DeleteService;
import example.consumer.services.UpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;

//@Component
public class NoVisitorEventListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CreateService createService;

    private final DeleteService deleteService;

    private final UpdateService updateService;

    public NoVisitorEventListener(CreateService createService, DeleteService deleteService, UpdateService updateService) {
        this.createService = createService;
        this.deleteService = deleteService;
        this.updateService = updateService;
    }

    /**
     * Example of treating each event based on their type
     * This shows the disadvantage of casting the events to their concrete implementation
     */
    @EventListener
    public void handleEvent(Event event) {

        logger.info("Application event received");

        EventDTO eventDTO = event.getEventDTO();

        String eventType = eventDTO.getEventType();

        if ("CREATE".equals(eventType)) {
            UpdateEventDTO updateEventDTO = (UpdateEventDTO) eventDTO;
            updateService.updateUser(
                    updateEventDTO.getUserId(),
                    updateEventDTO.getNewUsername(),
                    updateEventDTO.getNewAddress()
            );
        }


        if ("DELETE".equals(eventType)) {
            DeleteEventDTO deleteEventDTO = (DeleteEventDTO) eventDTO;
            deleteService.deleteUser(deleteEventDTO.getUserId());
        }

        if ("UPDATE".equals(eventType)) {
            CreateEventDTO createEventDTO = (CreateEventDTO) eventDTO;
            createService.createUser(
                    createEventDTO.getUsername(),
                    createEventDTO.getAddress()
            );
        }
    }

}
