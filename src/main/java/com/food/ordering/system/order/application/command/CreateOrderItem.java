package com.food.ordering.system.order.application.command;


import java.util.List;

public record CreateOrderItem(int quantity,
        Double price,
        Double subTotal,
        List<CreateProduct> items) {
}
