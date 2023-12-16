package com.robin.cheater;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CheaterCheckService {

    private final CheaterCheckHistoryRepository cheaterCheckHistoryRepository;

    public boolean cheatingUser(Integer userId){
        boolean check = false;
        //this would reference an in depth system checking whether a particular user has cheated before in different applications.
        //due to the limited scope of the exam I have simply done a basic check that can easily be verified that the state of "check" is saved to the database.
        if (userId > 90){
            check = true;

        }
        cheaterCheckHistoryRepository.save(
                CheaterCheckHistory.builder()
                        .cheater(check).userId(userId)
                .build()
        );

        return false;
    }
}
