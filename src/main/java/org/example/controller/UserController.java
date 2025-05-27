package org.example.controller;

import org.example.dto.requests.UserLoginRequest;
import org.example.dto.requests.UserPostRequest;
import org.example.dto.requests.UserRegistrationRequest;
import org.example.dto.responses.UserLoginResponse;
import org.example.dto.responses.UserPostResponse;
import org.example.dto.responses.UserRegistrationResponse;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/User")
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<UserRegistrationResponse> register(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        UserRegistrationResponse response = userService.registration(userRegistrationRequest);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
        UserLoginResponse response = userService.login(userLoginRequest);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/post")
    public ResponseEntity<UserPostResponse> login(@RequestBody UserPostRequest userPostRequest) {
        UserPostResponse response = userService.postBlog(userPostRequest);
        return ResponseEntity.ok(response);
    }

}
