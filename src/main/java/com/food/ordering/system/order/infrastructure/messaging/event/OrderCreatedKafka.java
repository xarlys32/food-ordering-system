package com.food.ordering.system.order.infrastructure.messaging.event;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * Kafka message payload for the "order.created" topic.
 * This is an infrastructure DTO — completely decoupled from the domain event.
 */
public record OrderCreatedKafka(
        String eventId,
        String eventType,
        Instant occurredOn,
        UUID orderId,
        UUID customerId,
        BigDecimal totalAmount,
        List<OrderItemCreatedKafka> orderItems,
        ProductCreatedKafka product
) {}

