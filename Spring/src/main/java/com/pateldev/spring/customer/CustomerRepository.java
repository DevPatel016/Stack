package com.pateldev.spring.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsCustomerByEmail(String email);
    boolean existsCustomerById(Integer id);
    boolean existsCustomerByAge(Integer age);
    boolean existsCustomerByName(String name);
}
