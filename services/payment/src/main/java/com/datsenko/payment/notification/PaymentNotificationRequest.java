package com.datsenko.payment.notification;

import com.datsenko.payment.entity.Payment;
import com.datsenko.payment.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail

) {
}
