package com.robin.user;

import org.springframework.stereotype.Service;

@Service
public record UserService(UserRepository userRepository) {
    public void registerUser(UserRegistrationRequest request) {
        User user = User.builder().username(request.username()).build();

        //todo: check if username is not taken
        userRepository.save(user);
    }
}
