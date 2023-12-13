package com.robin.collection;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Collection {
    @Id
    @SequenceGenerator(
            name = "collection_id_sequence",
            sequenceName = "collection_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "collection_id_sequence"
    )
    private Integer id;
    private Integer userId;
    private String card;
    private int cardQuantity;

}
