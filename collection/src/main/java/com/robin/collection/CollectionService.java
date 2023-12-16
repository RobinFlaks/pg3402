package com.robin.collection;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Transactional
@AllArgsConstructor
public class CollectionService {

    private EntityManager entityManager;
    public void addToCollection(int userId){
        String[] cards = new String[]{"Island", "Dessert", "Moon", "Sun", "Ocean", "Light", "Dark"};
        Random rand = new Random();
        CollectionEntityId collectionEntityId;


        for(int x= 0; x < 5; x++){
            int cardNr = rand.nextInt(6);
            collectionEntityId = new CollectionEntityId(userId, cards[cardNr]);
            System.out.println("the card that was chosen for number " + (x+1) + " in the pack was: " + cardNr + " witch is: " + cards[cardNr]);
            CollectionEntity entity = entityManager.find(CollectionEntity.class, collectionEntityId);
            if (entity == null){
                entity = CollectionEntity.builder()
                        .id(collectionEntityId)
                        .cardQuantity(1)
                        .build();

            } else {
                entity.setCardQuantity(entity.getCardQuantity()+1);
            }
            entityManager.merge(entity);
        }
    }
}
