package org.example.utils.userMapper;

import org.example.data.models.Post;
import org.example.data.models.User;
import org.example.dto.requests.UserPostRequest;
import org.example.dto.requests.UserRegistrationRequest;
import org.example.dto.responses.UserLoginResponse;
import org.example.dto.responses.UserPostResponse;
import org.example.dto.responses.UserRegistrationResponse;

import java.time.LocalDateTime;

public class UserMapper {
    public static User mapUserToRegisterRequest(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setName(userRegistrationRequest.getName());
        user.setPassword(userRegistrationRequest.getPassword());
        user.setEmail(userRegistrationRequest.getEmailAddress());
        return user;
    }

    public static UserRegistrationResponse mapRegisterToResponse(User newUser) {
        UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
        userRegistrationResponse.setEmailAddress(newUser.getEmail());
        userRegistrationResponse.setMessage("Registration Successful");
        return userRegistrationResponse;
    }
    public static UserLoginResponse mapUserToLogin(User user) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setEmailAddress(user.getEmail());
        userLoginResponse.setMessage("LoggedIn Successfully");
        return userLoginResponse;
    }
    public static Post mapPostToRequest(UserPostRequest userPostRequest) {
        Post post = new Post();
        post.setEmailAddress(userPostRequest.getEmailAddress());
        post.setTitle(userPostRequest.getTitle());
        post.setDescription(userPostRequest.getDescription());
        post.setCreatedAt(LocalDateTime.now());
        return post;
    }
    public static UserPostResponse mapPostToResponse(Post newPost) {
        UserPostResponse userPostResponse = new UserPostResponse();
        userPostResponse.setCreatedAt(LocalDateTime.now());
        userPostResponse.setEmailAddress(newPost.getEmailAddress());
        userPostResponse.setMessage("Post Successful");
        return userPostResponse;
    }
}
