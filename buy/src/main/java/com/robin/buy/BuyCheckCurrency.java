package com.robin.buy;

import com.robin.users.Users;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
@EntityScan(basePackageClasses = Users.class)
@Transactional
public class BuyCheckCurrency {

    private EntityManager entityManager;

    public boolean buyPack(int id){
        Users user = entityManager.find(Users.class, id);
        System.out.println("user id in int: " + id + ". user id in user: " + user.getId());
        if(user != null){
            if (user.getCurrency()>=10) {
                user.setCurrency(user.getCurrency() - 10);
                entityManager.merge(user);
                log.info("user {} bought a new pack", user.getUsername());
                return true;
            } else {
                log.info("user {} couldn't buy a new pack due to insufficient funds", user.getUsername());
                return false;
            }
        } else{
            log.info("user was null when trying to buy a pack");
            return false;
        }
    }
}
