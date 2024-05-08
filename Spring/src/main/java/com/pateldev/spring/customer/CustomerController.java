package com.pateldev.spring.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("api/v1/cuvstomers")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("api/v1/customer/{CustomerId}")
    public Customer getCustomer(@PathVariable("CustomerId") Integer customerId){
      return customerService.getcustomer(customerId);

    }
}
