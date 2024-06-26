package com.pateldev.spring.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);
    void insertCustomer(Customer customer);
    boolean existPersonWithEmail(String email);
    boolean existsPersonWithId(Integer id);
    void deleteCustomerById(Integer customerId);
    boolean existPersonWithAge(Integer age);
    boolean existPersonWithName(String name);

    void updateCustomer(Customer update);
}
