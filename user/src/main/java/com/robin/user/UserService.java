package com.robin.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public void registerUser(UserRegistrationRequest request) {
        Users user = Users.builder()
                .username(request.username())
                .password(request.password())
                .currency(100)
                .build();


        //todo: check if username is not taken
        userRepository.saveAndFlush(user);
        //todo: check if user is a known cheater
        restTemplate.getForObject("http:localhost:8082/api/check_cheater/{userId}", CheaterCheckResponse.class, user.getId());

        if(something != null){

        }
    }
}
