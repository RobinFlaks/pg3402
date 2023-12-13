package com.robin.collection;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/collection")
@AllArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;


    @GetMapping(path = "{userId}")
    public CollectionCheckResponse listCollection(@PathVariable("userId") Integer userId){
        String[] collection = collectionService.findCollection(userId);
        return new CollectionCheckResponse(collection);
    }
}
