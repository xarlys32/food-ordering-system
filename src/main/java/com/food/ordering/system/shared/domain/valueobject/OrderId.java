package com.food.ordering.system.shared.domain.valueobject;

import java.util.UUID;

public class OrderId {
    private final UUID value;

    public OrderId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof OrderId other) {
            return this.value.equals(other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
