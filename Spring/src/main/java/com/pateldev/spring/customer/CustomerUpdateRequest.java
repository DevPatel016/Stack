package com.pateldev.spring.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}
