package com.jokail.customer.controller;

import com.jokail.customer.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerResponse(
        String id,
        @NotNull(message = "cutomer firstname is required")
        String firstName,
        @NotNull(message = "cutomer lastname is required")
        String lastName,
        @NotNull(message = "cutomer email is required")
        @Email(message = "Customer email is not a valid email address")
        String email,
        Address address
) {
}
