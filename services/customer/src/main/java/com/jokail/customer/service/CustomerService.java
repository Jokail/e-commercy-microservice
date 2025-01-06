package com.jokail.customer.service;

import com.jokail.customer.controller.CustomerRequest;
import com.jokail.customer.controller.CustomerResponse;
import com.jokail.customer.entity.Customer;
import com.jokail.customer.exception.CustomerNotFoundException;
import com.jokail.customer.mapper.CustomerMapper;
import com.jokail.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    public String create(CustomerRequest request) {
        var customer =  customerRepository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public String update(CustomerRequest request) {
        var customer = customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                    String.format("Cannot update customer:: " +
                            "No customer found with the provided ID:: %s", request.id())
                ));
        mergerCustomer(customer, request);
        customerRepository.save(customer);
        return customer.getId();
    }

    private void mergerCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())){
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())){
            customer.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())){
            customer.setEmail(request.email());
        }
        if (request.address() != null){
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(mapper::fromCustomer)
                .toList();
    }

    public CustomerResponse findById(String id) {
        var customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("customer not found with id: " + id));
        return mapper.fromCustomer(customer);
    }

    public void delete(String customerId) {
        customerRepository.deleteById(customerId);
    }
}
