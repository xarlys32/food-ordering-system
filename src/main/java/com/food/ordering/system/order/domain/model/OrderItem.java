package com.food.ordering.system.order.domain.model;

import com.food.ordering.system.shared.domain.valueobject.Money;
import com.food.ordering.system.shared.domain.valueobject.OrderId;
import com.food.ordering.system.shared.domain.valueobject.OrderItemId;
import lombok.Getter;

@Getter
public class OrderItem {
    private final OrderItemId orderItemId;
    private final OrderId orderId;
    private final Product product;
    private final int quantity;
    private final Money price;
    private final Money subTotal;

    public OrderItem(OrderItemId orderItemId, OrderId orderId, Product product, int quantity, Money price, Money subTotal) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
    }
}
