package com.food.ordering.system.order.domain.model.valueobject;

import com.food.ordering.system.shared.domain.valueobject.ValueObject;
import lombok.Getter;

import java.util.Objects;

@Getter
public class StreetAddress extends ValueObject {
    private final String street;
    private final String city;
    private final String postalCode;

    public StreetAddress(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StreetAddress that)) return false;
        return Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(postalCode, that.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, postalCode);
    }
}
