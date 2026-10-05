package com.food.ordering.system.shared.domain.valueobject;

import java.util.UUID;

public class OrderItemId extends ValueObject{

    private final UUID value;

    public OrderItemId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof OrderItemId other) {
            return this.value.equals(other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
