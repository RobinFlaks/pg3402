package com.robin.cheater;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CheaterCheckService {

    private final CheaterCheckHistoryRepository cheaterCheckHistoryRepository;

    public boolean cheatingUser(Integer userId){
        cheaterCheckHistoryRepository.save(
                CheaterCheckHistory.builder()
                        .cheater(false).userId(userId)
                .build()
        );

        return false;
    }
}
