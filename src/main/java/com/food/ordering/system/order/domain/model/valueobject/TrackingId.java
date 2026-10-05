package com.food.ordering.system.order.domain.model.valueobject;

import com.food.ordering.system.shared.domain.valueobject.ValueObject;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class TrackingId extends ValueObject {
     private final UUID value;

    public TrackingId(UUID value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackingId that = (TrackingId) o;
        if (!Objects.equals(value, that.value)) return false;
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
