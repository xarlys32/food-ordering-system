package com.food.ordering.system.shared.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

/**
 * Value Object representing the unique identifier of a Customer.
 */
public class CustomerId extends ValueObject {

    private final UUID value;

    private CustomerId(UUID value) {
        assertNotNull(value, "CustomerId");
        this.value = value;
    }

    /** Creates a CustomerId from an existing UUID. */
    public static CustomerId of(UUID value) {
        return new CustomerId(value);
    }

    /** Creates a CustomerId by parsing a UUID string. */
    public static CustomerId of(String value) {
        return new CustomerId(UUID.fromString(value));
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerId that)) return false;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
