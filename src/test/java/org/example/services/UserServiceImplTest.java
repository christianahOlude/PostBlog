package org.example.services;

import org.example.data.repositories.PostRepository;
import org.example.data.repositories.UserRepository;
import org.example.dto.requests.UserLoginRequest;
import org.example.dto.requests.UserPostRequest;
import org.example.dto.requests.UserRegistrationRequest;
import org.example.dto.responses.UserLoginResponse;
import org.example.dto.responses.UserPostResponse;
import org.example.dto.responses.UserRegistrationResponse;
import org.example.exceptions.EmailNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @BeforeEach
    void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @BeforeEach
    void clearItemRepo() {
        postRepository.deleteAll();
    }


    public void setNewUser(UserRegistrationRequest userRegistrationRequest) {
        userRegistrationRequest.setName("name");
        userRegistrationRequest.setPassword("password");
        userRegistrationRequest.setEmailAddress("email@gmail.com");
    }

    public void getRegisteredUser(UserLoginRequest userLoginRequest) {
        userLoginRequest.setEmailAddress("email@gmail.com");
        userLoginRequest.setPassword("password");
    }
    @Test
    void registerUser() {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        setNewUser(userRegistrationRequest);
        UserRegistrationResponse response = userService.registration(userRegistrationRequest);
        String expected = userRegistrationRequest.getEmailAddress();
        assertEquals(expected, response.getEmailAddress());
        assertEquals("Registration Successful", response.getMessage());

    }

    @Test
    void throwExceptionIfUserAlreadyExists() {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        setNewUser(userRegistrationRequest);
        UserPostRequest userPostRequest = new UserPostRequest();
        userPostRequest.setEmailAddress("nonexistent@example.com");
        userPostRequest.setTitle("Test Title");
        userPostRequest.setDescription("Test Description");
        assertThrows(EmailNotFoundException.class, () -> userService.postBlog(userPostRequest));

    }
    @Test
    void loginUser() {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        setNewUser(userRegistrationRequest);
        UserRegistrationResponse userRegistrationResponse = userService.registration(userRegistrationRequest);
        String expected = userRegistrationRequest.getEmailAddress();
        assertEquals(expected, userRegistrationResponse.getEmailAddress());
        assertEquals("Registration Successful", userRegistrationResponse.getMessage());
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        getRegisteredUser(userLoginRequest);
        UserLoginResponse response = userService.login(userLoginRequest);
        String expect = userLoginRequest.getEmailAddress();
        assertEquals(expect, response.getEmailAddress());
        assertEquals("LoggedIn Successfully", response.getMessage());
    }
    @Test
    void post() {
        UserPostRequest userPostRequest = new UserPostRequest();
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        setNewUser(userRegistrationRequest);
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        getRegisteredUser(userLoginRequest);
        userPostRequest.setEmailAddress("email@gmail.com");
        userPostRequest.setTitle("title");
        userPostRequest.setDescription("description");
        userPostRequest.setCreatedAt(LocalDateTime.now());
        UserPostResponse userPostResponse = userService.postBlog(userPostRequest);
        System.out.println(userPostRequest);
        assertNotNull(userRegistrationRequest.getEmailAddress());
        System.out.println(userRegistrationRequest.getEmailAddress());
        assertNotNull(userPostResponse);
        System.out.println(userPostResponse);
        assertEquals("Post Successful",userPostResponse.getMessage());
    }
}