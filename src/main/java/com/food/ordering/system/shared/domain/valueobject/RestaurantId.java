package com.food.ordering.system.shared.domain.valueobject;

import java.util.UUID;

public class RestaurantId extends ValueObject {
    private final UUID value;

    public RestaurantId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RestaurantId other) {
            return this.value.equals(other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
