package com.jokail.product.controller;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        @NotNull(message = "is required")
        String name,
        @NotNull(message = "is required")
        String description,
        @Positive(message = "should be positive")
        double availableQuality,
        @Positive(message = "should be positive")
        BigDecimal price,
        @NotNull(message = "is required")
        Integer categoryId,
        String categoryName,
        String categoryDescription

) {
}
