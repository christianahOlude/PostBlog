package org.example.services;

import org.example.dto.requests.UserLoginRequest;
import org.example.dto.requests.UserPostRequest;
import org.example.dto.requests.UserRegistrationRequest;
import org.example.dto.responses.UserLoginResponse;
import org.example.dto.responses.UserPostResponse;
import org.example.dto.responses.UserRegistrationResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserRegistrationResponse registration(UserRegistrationRequest userRegistrationRequest);

    UserLoginResponse login(UserLoginRequest userLoginRequest);

    UserPostResponse postBlog(UserPostRequest userPostRequest);
}
