package com.food.ordering.system.shared.domain.valueobject;

import java.util.Objects;

public class Money extends ValueObject {

    private final Double value;

    public Money(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        if (!Objects.equals(value, money.value)) return false;
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
