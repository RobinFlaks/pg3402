package com.robin.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController{

    private final UserService userService;
    @PostMapping
    public void registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        log.info("new user: {}", userRegistrationRequest);
        userService.registerUser(userRegistrationRequest);
    }
}
