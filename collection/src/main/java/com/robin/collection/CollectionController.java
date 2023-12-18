package com.robin.collection;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

@RestController
@RequestMapping("api/collection")
@AllArgsConstructor
@Transactional
@Component
public class CollectionController {

    private final CollectionService collectionService;


    @RabbitListener(queues = "exchangeName", concurrency = "1")
    public void addToCollection(String message){
        System.out.println("message: " + message);
        Integer userId = Integer.valueOf(message);
        System.out.println("user recieved!");
        collectionService.addToCollection(userId);
    }
}