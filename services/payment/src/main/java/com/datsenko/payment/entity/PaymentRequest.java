package com.datsenko.payment.entity;

import java.math.BigDecimal;
import java.text.Bidi;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
