package com.datsenko.payment.service;

import com.datsenko.payment.entity.PaymentRequest;
import com.datsenko.payment.mapper.PaymentMapping;
import com.datsenko.payment.notification.NotificationProducer;
import com.datsenko.payment.notification.PaymentNotificationRequest;
import com.datsenko.payment.repository.PaymentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapping paymentMapping;
    private final NotificationProducer notification;

    public Integer create(@Valid PaymentRequest request) {
        var payment =  paymentRepository.save(paymentMapping.toPayment(request));

        notification.sendNotification(new PaymentNotificationRequest(
                request.orderReference(),
                request.amount(),
                request.paymentMethod(),
                request.customer().firstName(),
                request.customer().lastName(),
                request.customer().email()
        ));

        return payment.getId();
    }
}
