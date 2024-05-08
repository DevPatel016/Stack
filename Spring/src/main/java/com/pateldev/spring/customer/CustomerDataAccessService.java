package com.pateldev.spring.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class CustomerDataAccessService implements CustomerDao{
    //    Fake bd initial one
    private static List<Customer> customers;
    static {
        customers = new ArrayList<>();
        Customer dev = new Customer(
                1,
                "Dev",
                "dev@gmail.com",
                23
        );
        customers.add(dev);
        Customer Keya = new Customer(
                2,
                "Keya",
                "Keya@gmail.com",
                20
        );
        customers.add(Keya);
    }
    @Override
    public List<Customer> selectAllCustomers() {

        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

    }
}
