package com.robin.cheater;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/check_cheater")
public class CheaterController {

    private final CheaterCheckService cheaterCheckService;

    @GetMapping
    public CheaterCheckResponse isCheating(@PathVariable("userId") Integer userId){
        boolean cheating = cheaterCheckService.cheatingUser(userId);

        return new CheaterCheckResponse(cheating);
    }
}
