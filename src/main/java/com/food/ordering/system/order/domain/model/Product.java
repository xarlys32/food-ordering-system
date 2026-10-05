package com.food.ordering.system.order.domain.model;

import com.food.ordering.system.shared.domain.valueobject.Money;
import com.food.ordering.system.shared.domain.valueobject.ProductId;
import lombok.Getter;

@Getter
public class Product {
    private final ProductId productId;
    private final String productName;
    private final Money productPrice;

    public Product(ProductId productId, String productName, Money productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
