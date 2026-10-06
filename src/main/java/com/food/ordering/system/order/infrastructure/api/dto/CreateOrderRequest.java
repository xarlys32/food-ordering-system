package com.food.ordering.system.order.infrastructure.api.dto;

import com.food.ordering.system.order.application.dto.response.OrderResponse;
import com.food.ordering.system.shared.application.cqrs.Command;

import java.util.List;

/**
 * Command to create a new Order.
 * Carries the intent and the data needed to fulfill it.
 */
public record CreateOrderRequest(
        String customerId,
        Double totalAmount,
        String address,
        String status,
        List<CreateOrderItemRequest> items
) implements Command<OrderResponse> {
}


