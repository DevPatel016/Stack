package com.pateldev.spring;

import com.pateldev.spring.customer.Customer;
import com.pateldev.spring.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication

public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args); // class name where spring start from.
        System.out.println("Hello");

        }
        @Bean
        CommandLineRunner runner(CustomerRepository customerRepository) {
            return args -> {
            Customer dev = new Customer(
                    "Dev",
                    "dev@gmail.com",
                    23
            );

            Customer keya = new Customer(
                    "Keya",
                    "Keya@gmail.com",
                    20
            );

                List<Customer> customers = List.of(dev, keya);
                customerRepository.saveAll(customers);
            };
    }


    }

