package com.pateldev.spring.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("{CustomerId}")
    public Customer getCustomer(@PathVariable("CustomerId") Integer customerId){
      return customerService.getcustomer(customerId);
    }
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request){
        customerService.addCustomer(request);
    }
}
