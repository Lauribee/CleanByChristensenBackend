package com.example.cleanbychristensenbackend.customer.repository;

import com.example.cleanbychristensenbackend.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByPhoneNumber(String phoneNumber);
    Optional<Customer> findById(long id);
}
