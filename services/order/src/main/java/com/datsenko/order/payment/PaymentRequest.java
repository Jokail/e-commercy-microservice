package com.datsenko.order.payment;

import com.datsenko.order.customer.CustomerResponse;
import com.datsenko.order.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
