package com.robin.buy;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/buy")
@Transactional
public class BuyController {

    private final BuyCheckCurrency buyCheckCurrency;

    @GetMapping(path = "{userId}")
    public BuyCheckResponse isCheating(@PathVariable("userId") Integer userId){
        boolean bought;
        System.out.println("we have started a request for buying a pack");

        if(buyCheckCurrency.buyPack(userId)){
            bought = true;
            //todo send request to collection to add 5 random cards to users collection
        } else{
            bought = false;
        }
        return new BuyCheckResponse(bought);
    }
}
