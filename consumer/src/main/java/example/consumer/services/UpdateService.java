package example.consumer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public void updateUser(String userId, String newUsername, String newAddress) {

        LOGGER.info("Updating user with id {} with newUsername: {} and newAddress: {}", userId, newUsername, newAddress);
    }
}
