package com.pateldev.spring.customer;

import com.pateldev.spring.exception.DuplicateResourceException;
import com.pateldev.spring.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
// Business layer
    private final CustomerDao customerDao;
// Qualifier will help to know which on inject jpa, list, jdbc
    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers();
    }
public Customer getcustomer(Integer id){
        return customerDao.selectCustomerById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Customer with id [%s] not found".formatted(id))
                );
    }
    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        //check if email exists
        String email = customerRegistrationRequest.email();
        if(customerDao.existPersonWithEmail(email)){
            throw new DuplicateResourceException("Email already taken");
        }
        Customer customer = new Customer(
                customerRegistrationRequest.name(),
                customerRegistrationRequest.email(),
                customerRegistrationRequest.age()
        );
        customerDao.insertCustomer(customer); // this line connects with the JPA SQL
    }

    public void deleteCustomerById(Integer customerId){
        if (!customerDao.existsPersonWithId(customerId)){
            throw new ResourceNotFoundException("Id does not exit");
        }
        customerDao.deleteCustomerById(customerId);

    }
}
