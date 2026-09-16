package com.food.ordering.system.order.infrastructure.messaging.event;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * Kafka message payload for the "order.created" topic.
 * This is an infrastructure DTO — completely decoupled from the domain event.
 */
public record OrderCreatedRabbitEvent(
        String eventId,
        String eventType,
        Instant occurredOn,
        UUID orderId,
        com.food.ordering.system.shared.domain.valueobject.CustomerId customerId,
        BigDecimal totalAmount
) {}

