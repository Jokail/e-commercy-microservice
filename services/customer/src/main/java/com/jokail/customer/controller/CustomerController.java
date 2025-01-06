package com.jokail.customer.controller;

import com.jokail.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.create(request));
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(
            @RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.update(request));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable("customer-id") String id
    ) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("customer-id") String customerId
    ) {
        customerService.delete(customerId);
        return ResponseEntity.noContent().build();
    }


}
