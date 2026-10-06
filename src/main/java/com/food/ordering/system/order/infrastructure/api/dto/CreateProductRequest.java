package com.food.ordering.system.order.infrastructure.api.dto;

import java.util.UUID;

public record CreateProductRequest(UUID productId, String name, Double price) {
}
