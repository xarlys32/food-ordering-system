package com.food.ordering.system.order.infrastructure.messaging.event;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderItemCreatedKafka(UUID orderId,
                                    UUID customerId,
                                    BigDecimal totalAmount,
                                    List<OrderItemCreatedKafka> orderItems,
                                    ProductCreatedKafka product) {
}
