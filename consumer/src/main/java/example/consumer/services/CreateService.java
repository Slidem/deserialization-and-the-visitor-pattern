package example.consumer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public void createUser(String username, String address) {

        LOGGER.info("Creating user with username: {} and address: {}", username, address);
    }

}
