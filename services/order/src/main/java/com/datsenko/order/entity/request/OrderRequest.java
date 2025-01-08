package com.datsenko.order.entity.request;

import com.datsenko.order.entity.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        Integer id,
        String reference,
        @Positive(message = "must be positive")
        BigDecimal amount,
        @NotNull(message = "should be present")
        PaymentMethod paymentMethod,
        @NotNull(message = "should be present")
        @NotBlank(message = "should be present")
        @NotEmpty(message = "should be present")
        String customerId,
        @NotEmpty(message = "you should at least purchase one product")
        List<PurchaseRequest> products

) {
}
