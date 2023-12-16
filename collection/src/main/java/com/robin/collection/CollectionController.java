package com.robin.collection;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/collection")
@AllArgsConstructor
@Transactional
public class CollectionController {

    private final CollectionService collectionService;


    @GetMapping(path = "{userId}")
    public CollectionCheckResponse listCollection(@PathVariable("userId") Integer userId){
        collectionService.addToCollection(userId);
        return new CollectionCheckResponse(true);
    }
}