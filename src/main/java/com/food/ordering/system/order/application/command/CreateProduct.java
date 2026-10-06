package com.food.ordering.system.order.application.command;

import java.util.UUID;

public record CreateProduct(UUID productId, String name, Double price) {
}
