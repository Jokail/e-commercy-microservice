package com.jokail.product.controller;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "product is mandatory")
        Integer id,
        @Positive(message = "should be positive")
        double quantity
) {
}
