package com.food.ordering.system.order.domain.event;

import com.food.ordering.system.order.domain.model.valueobject.OrderId;
import com.food.ordering.system.shared.domain.event.DomainEvent;
import com.food.ordering.system.shared.domain.valueobject.CustomerId;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Domain Event raised when a new Order is created.
 */
@Getter
public class OrderCreated extends DomainEvent {

    public static final String EVENT_TYPE = "order.created";

    private final UUID orderId;
    private final UUID customerId;
    private final Double totalAmount;
    private final List<OrderItemCreated> orderItems;

    public OrderCreated(UUID orderId, UUID customerId, Double totalAmount, List<OrderItemCreated> orderItems) {
        super();
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.orderItems = orderItems;
    }

    @Override
    public String getEventType() {
        return EVENT_TYPE;
    }
}

