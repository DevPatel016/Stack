package com.pateldev.spring.customer;

public record CustomerRegistrationRequest(
        String name,
        String email,
        Integer age
) {

}
