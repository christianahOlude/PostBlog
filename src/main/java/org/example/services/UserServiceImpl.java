package org.example.services;

import org.example.data.models.Post;
import org.example.data.models.User;
import org.example.data.repositories.PostRepository;
import org.example.data.repositories.UserRepository;
import org.example.dto.requests.UserLoginRequest;
import org.example.dto.requests.UserPostRequest;
import org.example.dto.requests.UserRegistrationRequest;
import org.example.dto.responses.UserLoginResponse;
import org.example.dto.responses.UserPostResponse;
import org.example.dto.responses.UserRegistrationResponse;
import org.example.exceptions.EmailCantBeEmptyException;
import org.example.exceptions.EmailNotFoundException;
import org.example.exceptions.InvalidPasswordException;
import org.example.utils.PasswordUtil;
import org.example.utils.userMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
  public class UserServiceImpl implements UserService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRegistrationResponse registration(UserRegistrationRequest userRegistrationRequest) {
        String emailAddress = userRegistrationRequest.getEmailAddress();
        if(emailAddress == null || emailAddress.isEmpty()) throw new EmailCantBeEmptyException("Email address can't be empty");
        String passwordEncrypt = PasswordUtil.hashPassword(userRegistrationRequest.getPassword());
        userRegistrationRequest.setPassword(passwordEncrypt);
        User newUser = UserMapper.mapUserToRegisterRequest(userRegistrationRequest);
        userRepository.save(newUser);
        return UserMapper.mapRegisterToResponse(newUser);
    }

    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        User foundUser = userRepository.findByEmail(userLoginRequest.getEmailAddress())
                .orElseThrow(() -> new EmailNotFoundException("Email address not found"));

        boolean passwordMatches = PasswordUtil.checkPassword(userLoginRequest.getPassword(), foundUser.getPassword());

        if (!passwordMatches) {
            throw new  InvalidPasswordException("Incorrect password");
        }

        return UserMapper.mapUserToLogin(foundUser);
    }


    @Override
    public UserPostResponse postBlog(UserPostRequest userPostRequest) {
//        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
//        userPostRequest.setEmail(userRegistrationRequest.getEmailAddress());
        Post newPost = UserMapper.mapPostToRequest(userPostRequest);
        postRepository.save(newPost);
        return UserMapper.mapPostToResponse(newPost);
    }
}
