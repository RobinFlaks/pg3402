package com.robin.users;

import com.robin.cheater.CheaterCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UsersService {
    private final UsersRepository userRepository;
    private final RestTemplate restTemplate;

    public void registerUser(UsersRegistrationRequest request) {
        Users aUser = Users.builder()
                .username(request.username())
                .password(request.password())
                .currency(100)
                .build();


        //todo: check if username is not taken
        userRepository.saveAndFlush(aUser);

        CheaterCheckResponse cheaterCheckResponse = restTemplate.getForObject("http://CHEATER/api/check_cheater/{userId}", CheaterCheckResponse.class, aUser.getId());

        if(cheaterCheckResponse != null){
            if (cheaterCheckResponse.isCheater()){
                throw new IllegalStateException(aUser.getUsername() + " is a known cheater");
            }
        }
    }
}
