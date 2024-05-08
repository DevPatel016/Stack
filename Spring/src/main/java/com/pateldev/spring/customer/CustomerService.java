package com.pateldev.spring.customer;

import com.pateldev.spring.exception.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
// Business layer
    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers();
    }
public Customer getcustomer(Integer id){
        return customerDao.selectCustomerById(id)
                .orElseThrow(
                        () -> new ResourceNotFound("Customer with id [%s] not found".formatted(id))
                );
    }

}
