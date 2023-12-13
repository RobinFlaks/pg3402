package com.robin.buy;

import com.robin.user.Users;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuyCheckCurrency {

    private EntityManager entityManager;

    public void buyPack(int id){
        Users user = entityManager.find(Users.class, id);

        if(user != null){
            user.setCurrency(user.getCurrency() - 10);
            entityManager.merge(user);
        } else{
            
        }
    }
}
