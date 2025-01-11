package com.datsenko.notification.kafka.order;

import com.datsenko.notification.kafka.payment.PaymentConfirmation;
import com.datsenko.notification.kafka.payment.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
