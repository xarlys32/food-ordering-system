package com.food.ordering.system.order.infrastructure.messaging.event;

import java.util.UUID;

public record ProductCreatedKafka(UUID productId) {
}
