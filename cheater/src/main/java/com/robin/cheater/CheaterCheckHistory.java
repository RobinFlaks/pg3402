package com.robin.cheater;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class CheaterCheckHistory {
    @Id
    @SequenceGenerator(name = "cheater_id_sequence", sequenceName = "cheater_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cheater_id_sequence")
    private Integer id;
    private Integer userId;
    private boolean cheater;
}
