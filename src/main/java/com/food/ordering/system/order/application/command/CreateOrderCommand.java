package com.food.ordering.system.order.application.command;

import com.food.ordering.system.order.application.dto.response.OrderResponse;
import com.food.ordering.system.shared.application.cqrs.Command;

import java.math.BigDecimal;
import java.util.List;

/**
 * Command to create a new Order.
 * Carries the intent and the data needed to fulfill it.
 */
public record CreateOrderCommand(
        String customerId,
        Double totalAmount,
        String address,
        String status,
        List<CreateOrderItem> items
) implements Command<OrderResponse> {
}


