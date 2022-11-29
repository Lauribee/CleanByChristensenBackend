package com.example.cleanbychristensenbackend.customer.service;

import com.example.cleanbychristensenbackend.customer.model.Customer;
import com.example.cleanbychristensenbackend.customer.repository.CustomerRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;

    }

    /**
     * Finder alle customers
     *
     * @return alle customers
     */

    public Iterable<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        Iterable<Customer> items = repository.findAll();
        items.forEach(list::add);
        return list;
    }

    /**
     * Finder enkelt customer med telefonnummer
     *
     * @return enkelt customer
     */

    public Optional<Customer> findCustomerByPhoneNumber(String value) {
        Optional<Customer> customer = repository.findByPhoneNumber(value);
        return customer;
    }

    /**
     * Finder enkelt customer med id
     *
     * @return enkelt customer
     */

    public Optional<Customer> find(Long id) throws ResourceNotFoundException {
        Optional<Customer> customer = repository.findById(id);
        return customer;
    }

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> update(Long id, Customer customer, boolean partial) {
        return repository.findById(id)
                .map(oldItem -> {
                    return repository.save(oldItem.updateFrom(customer, partial));
                });
    }

    public Customer delete(Long id) {
        repository.deleteById(id);
        return null;
    }


}
