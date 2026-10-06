package com.food.ordering.system.order.domain.event;

import com.food.ordering.system.order.domain.model.Product;

import java.util.UUID;

public record OrderItemCreated(UUID orderItemId,
                               UUID orderId,
                               ProductCreated product,
                               int quantity,
                               Double price,
                               Double subTotal) {
}
