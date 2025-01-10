package com.datsenko.payment.mapper;

import com.datsenko.payment.entity.Payment;
import com.datsenko.payment.entity.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapping {

    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .orderId(request.orderId())
                .build();
    }

}
