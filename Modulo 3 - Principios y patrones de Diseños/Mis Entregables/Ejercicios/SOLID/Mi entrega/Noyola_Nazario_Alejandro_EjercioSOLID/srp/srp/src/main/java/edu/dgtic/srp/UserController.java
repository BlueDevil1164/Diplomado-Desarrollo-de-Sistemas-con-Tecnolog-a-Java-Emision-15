package edu.dgtic.srp;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController {

    private UserPersistenceService persistenceService = new UserPersistenceService();

    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);
        return persistenceService.saveUser(user);
    }
}
