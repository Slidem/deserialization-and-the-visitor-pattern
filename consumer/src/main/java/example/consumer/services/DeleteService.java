package example.consumer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public void deleteUser(String userId) {

        LOGGER.info("Deleting user with id {}", userId);
    }
}
