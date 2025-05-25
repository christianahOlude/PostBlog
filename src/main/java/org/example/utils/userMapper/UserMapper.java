package org.example.utils.userMapper;

import org.example.data.models.User;
import org.example.dto.requests.UserRegistrationRequest;
import org.example.dto.responses.UserRegistrationResponse;

public class UserMapper {
    public UserRegistrationResponse toUserRegistrationResponse(UserRegistrationRequest userRegistrationRequest) {
        User newUser = new User();
        newUser.setName(userRegistrationRequest.getName());
        newUser.setPassword(userRegistrationRequest.getPassword());
        return new UserRegistrationResponse();
    }
}
