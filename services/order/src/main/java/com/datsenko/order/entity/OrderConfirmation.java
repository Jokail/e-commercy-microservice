package com.datsenko.order.entity;

import com.datsenko.order.customer.CustomerResponse;
import com.datsenko.order.entity.resonse.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
){
}
