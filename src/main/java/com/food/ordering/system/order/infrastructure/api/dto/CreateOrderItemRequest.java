package com.food.ordering.system.order.infrastructure.api.dto;


import java.util.List;

public record CreateOrderItemRequest(int quantity,
                                     Double price,
                                     Double subTotal,
                                     List<CreateProductRequest> items) {
}
