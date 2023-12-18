package com.robin.buy;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/buy")
@Transactional
public class BuyController {

    private final BuyCheckCurrency buyCheckCurrency;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping(path = "{userId}")
    public BuyCheckResponse isCheating(@PathVariable("userId") Integer userId){
        boolean bought;
        System.out.println("we have started a request for buying a pack");

        if(buyCheckCurrency.buyPack(userId)){
            bought = true;
            amqpTemplate.convertAndSend("directExchange", "routingKey", userId.toString());
            System.out.println("tried to send message to collection");
        } else{
            bought = false;
        }
        return new BuyCheckResponse(bought);
    }
}
