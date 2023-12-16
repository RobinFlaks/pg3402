package com.robin.collection;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CollectionEntityId implements Serializable {
    private Integer userId;
    private String card;

    public CollectionEntityId(){

    }
    public CollectionEntityId(Integer userId, String card){
        this.userId = userId;
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionEntityId that = (CollectionEntityId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, card);
    }
}
