package com.food.ordering.system.order.domain.model;

import com.food.ordering.system.order.domain.event.OrderCreated;
import com.food.ordering.system.order.domain.exception.OrderDomainException;
import com.food.ordering.system.order.domain.model.valueobject.OrderId;
import com.food.ordering.system.order.domain.model.valueobject.OrderStatus;
import com.food.ordering.system.order.domain.model.valueobject.StreetAddress;
import com.food.ordering.system.order.domain.model.valueobject.TrackingId;
import com.food.ordering.system.shared.domain.model.AggregateRoot;
import com.food.ordering.system.shared.domain.valueobject.CustomerId;
import com.food.ordering.system.shared.domain.valueobject.Money;
import lombok.Getter;

import java.math.Money;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * Order Aggregate Root.
 * Encapsulates all business rules related to an Order.
 */
@Getter
public class Order extends AggregateRoot {

    private final OrderId id;
    private final CustomerId customerId;
    private final Money totalAmount;
    private final StreetAddress address;
    private final List<OrderItem> items;
    private final OrderStatus status;
    private final TrackingId trackingId;
    private final Instant createdAt;
    private Instant updatedAt;

    private Order(OrderId id, CustomerId customerId, Money totalAmount, StreetAddress address, List<OrderItem> items, TrackingId trackingId) {
        this.id = id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.address = address;
        this.items = items;
        this.trackingId = trackingId;
        this.status = OrderStatus.PENDING;
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }

    private Order(OrderId id, CustomerId customerId, Money totalAmount, StreetAddress address, List<OrderItem> items,
                  OrderStatus status, TrackingId trackingId, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNull(id);
        this.customerId = Objects.requireNonNull(customerId);
        this.totalAmount = Objects.requireNonNull(totalAmount);
        this.address = address;
        this.items = items;
        this.status = Objects.requireNonNull(status);
        this.trackingId = trackingId;
        this.createdAt = Objects.requireNonNull(createdAt);
        this.updatedAt = Objects.requireNonNull(updatedAt);
    }


    /**
     * Factory method: creates a new Order and registers the corresponding domain event.
     */
    public static Order create(CustomerId customerId, Money totalAmount) {
        if (customerId == null) {
            throw new OrderDomainException("Customer ID must not be blank");
        }
        if (totalAmount == null || totalAmount.getValue().compareTo(0.0) <= 0) {
            throw new OrderDomainException("Total amount must be greater than zero");
        }

        Order order = new Order(OrderId.generate(), customerId, totalAmount);
        order.registerEvent(new OrderCreated(order.id, order.customerId, order.totalAmount));
        return order;
    }

    public void confirm() {
        if (this.status != OrderStatus.PENDING) {
            throw new OrderDomainException("Only PENDING orders can be confirmed");
        }
        this.status = OrderStatus.CONFIRMED;
        this.updatedAt = Instant.now();
    }

    public boolean isCancellable() {
        return this.status == OrderStatus.PENDING
                || this.status == OrderStatus.CONFIRMED;
    }

    public void cancel() {
        if (!isCancellable()) {
            throw new OrderDomainException("Cannot cancel an order that is already SHIPPED or DELIVERED");
        }
        this.status = OrderStatus.CANCELLED;
        this.updatedAt = Instant.now();
    }


}



