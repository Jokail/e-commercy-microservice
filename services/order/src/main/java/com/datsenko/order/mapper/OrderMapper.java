package com.datsenko.order.mapper;

import com.datsenko.order.entity.Order;
import com.datsenko.order.entity.OrderResponse;
import com.datsenko.order.entity.request.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {


    public static Order toObject(OrderRequest request) {
        return Order.builder()
                .id(request.id())
                .customerId(request.customerId())
                .reference(request.reference())
                .totalAmount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }

    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
