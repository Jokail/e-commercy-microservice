package com.datsenko.order.controller;

import com.datsenko.order.entity.OrderLineResponse;
import com.datsenko.order.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {

    private final OrderLineService orderLineService;

    @GetMapping("/order/{}order-id")
    public ResponseEntity<List<OrderLineResponse>> getOrderLines(
            @PathVariable("order-id") Integer orderId
    ) {
        return ResponseEntity.ok(orderLineService.findAllByOrderId(orderId));
    }

}
