package com.pateldev.spring.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("jpa")
public class CustomerJPADataAccessService implements CustomerDao{
    private final CustomerRepository customerRepository;

    public CustomerJPADataAccessService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public boolean existPersonWithEmail(String email) {
        return customerRepository.existsCustomerByEmail(email);
    }

    @Override
    public boolean existsPersonWithId(Integer id) {
        return customerRepository.existsCustomerById(id);
    }

    @Override
    public void deleteCustomerById(Integer customerId) {
         customerRepository.deleteById(customerId);
    }

    @Override
    public boolean existPersonWithAge(Integer age) {
        return customerRepository.existsCustomerByAge(age);
    }

    @Override
    public boolean existPersonWithName(String name) {
        return customerRepository.existsCustomerByName(name);
    }

    @Override
    public void updateCustomer(Customer update) {
        customerRepository.save(update);
    }


}
