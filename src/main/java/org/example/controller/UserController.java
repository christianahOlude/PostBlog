package org.example.controller;

import org.example.dto.requests.UserRegistrationRequest;
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
}
