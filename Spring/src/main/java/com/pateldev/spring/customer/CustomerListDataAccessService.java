package com.pateldev.spring.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository("list")
public class CustomerListDataAccessService implements CustomerDao{
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
        Customer keya = new Customer(
                2,
                "Keya",
                "Keya@gmail.com",
                20
        );
        customers.add(keya);
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

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existPersonWithEmail(String email) {
        return customers.stream()
                .anyMatch(c -> c.getEmail().equals(email));
    }

    @Override
    public boolean existsPersonWithId(Integer id) {
        return customers.stream()
                .anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public void deleteCustomerById(Integer customerId) {
        customers.stream()
                .filter(c -> c.getId().equals(customerId))
                .findFirst()
                .ifPresent(customers::remove);

    }

    @Override
    public boolean existPersonWithAge(Integer age) {
        return customers.stream()
                .anyMatch(c ->c.getAge().equals(age));
    }

    @Override
    public boolean existPersonWithName(String name) {
        return customers.stream()
                .anyMatch(c -> c.getEmail().equals(name));
    }

    @Override
    public void updateCustomer(Customer customer) {
        customers.add(customer);
    }


}
