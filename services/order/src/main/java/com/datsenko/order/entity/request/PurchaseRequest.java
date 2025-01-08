package com.datsenko.order.entity.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "should be present")
        Integer productId,
        @Positive(message = "must be positive")
        Integer quantity
) {
}
