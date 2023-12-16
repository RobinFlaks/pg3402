package com.robin.users;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UsersController {

    private final UsersService userService;
    @PostMapping
    public void registerUser(@RequestBody UsersRegistrationRequest aUserRegistrationRequest){
        log.info("new user: {}", aUserRegistrationRequest);
        userService.registerUser(aUserRegistrationRequest);
    }
}
