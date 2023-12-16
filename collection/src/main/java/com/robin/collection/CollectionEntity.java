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
public class CollectionEntity {
    @EmbeddedId
    private CollectionEntityId id;
    private int cardQuantity;

}
