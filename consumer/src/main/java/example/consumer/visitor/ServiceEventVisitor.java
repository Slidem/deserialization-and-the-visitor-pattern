package example.consumer.visitor;

import example.consumer.dtos.*;
import example.consumer.services.CreateService;
import example.consumer.services.DeleteService;
import example.consumer.services.UpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceEventVisitor implements EventVisitor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CreateService createService;

    private final DeleteService deleteService;

    private final UpdateService updateService;

    public ServiceEventVisitor(CreateService createService, DeleteService deleteService, UpdateService updateService) {
        this.createService = createService;
        this.deleteService = deleteService;
        this.updateService = updateService;
    }

    @Override
    public void visit(DeleteEventDTO deleteEventDTO) {
        deleteService.deleteUser(deleteEventDTO.getUserId());
    }

    @Override
    public void visit(CreateEventDTO createEventDTO) {
        createService.createUser(createEventDTO.getUsername(), createEventDTO.getAddress());
    }

    @Override
    public void visit(UpdateEventDTO updateEventDTO) {
        updateService.updateUser(
                updateEventDTO.getUserId(),
                updateEventDTO.getNewUsername(),
                updateEventDTO.getNewAddress()
        );
    }

    @Override
    public void visit(GenericEventDTO genericEventDTO) {
        logger.info("Generic object received. No actions to be done here... {}", genericEventDTO);
    }
}
