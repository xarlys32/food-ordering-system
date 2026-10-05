package com.food.ordering.system.order.infrastructure.messaging.event;

import com.food.ordering.system.order.domain.event.OrderCreated;

import java.math.BigDecimal;
import java.time.Instant;
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
        OrderCreated order,
        BigDecimal totalAmount
) {}

