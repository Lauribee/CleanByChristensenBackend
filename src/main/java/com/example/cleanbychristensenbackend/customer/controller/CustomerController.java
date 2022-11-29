package com.example.cleanbychristensenbackend.customer.controller;


import com.example.cleanbychristensenbackend.customer.model.Customer;
import com.example.cleanbychristensenbackend.customer.service.CustomerService;
import com.example.cleanbychristensenbackend.dto.CustomerDto;
import com.example.cleanbychristensenbackend.factory.DtoFactory;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin // Allow all domain origins.
@RestController
@RequestMapping("api/customers")
public class CustomerController {



    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    /**
     * Henter/finder alle customers
     *
     * @return customers
     */
    @GetMapping
    ResponseEntity<List<CustomerDto>> findAll() {
        List<Customer> all = (List<Customer>) service.findAll();
        return ResponseEntity.ok().body(DtoFactory.fromCustomers(all));
    }

    /**
     * Henter/finder en customer.
     *
     * @param value
     * @return customer
     * @throws ResourceNotFoundException
     */

    @GetMapping("/phonenumber/{value}")
    ResponseEntity<CustomerDto> findByPhoneNumber(@PathVariable("value") String value)  {
        Optional<Customer> item = Optional.of(service.findCustomerByPhoneNumber(value)
                .orElseThrow(()-> new ResourceNotFoundException("Customer med telefonnummer %d ikke fundet".formatted(value))));
        return ResponseEntity.ok().body(DtoFactory.fromCustomer(item.get()));
    }

    /**
     * Henter/finder en customer.
     *
     * @param id
     * @return customer
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> find(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Optional<Customer> item = Optional.of(service.find(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer %d ikke fundet.".formatted(id))));
        return ResponseEntity.ok().body(DtoFactory.fromCustomer(item.get()));
    }

    /**
     * Poster/Skaber en ny customer.
     *
     * @param dto
     * @return ny customer
     */
    @PostMapping
    public ResponseEntity<CustomerDto> create(@Valid @RequestBody CustomerDto dto) {
        Customer item = service.create(DtoFactory.fromCustomerDto(dto));
        return ResponseEntity.ok().body(DtoFactory.fromCustomer(item));
    }

    /**
     * Putter/opdaterer en customer.
     *
     * @param id
     * @param dto
     * @return opdateret customer
     */
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> put(@PathVariable("id") Long id, @Valid @RequestBody CustomerDto dto) {
        return ResponseEntity.ok().body(update(id, dto, false));
    }

    /**
     * Patcher en customer.
     *
     * @param id
     * @param dto
     * @return opdateret customer
     */
    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDto> patch(@PathVariable("id") Long id, @Valid @RequestBody CustomerDto dto) {
        return ResponseEntity.ok().body(update(id, dto, true));
    }

    /**
     * Opdaterer en customer Dto fra en anden customer Dto.
     *
     * @param id
     * @param dto
     * @return Den opdaterede Dto
     */
    private CustomerDto update(Long id, CustomerDto dto, boolean partial) {
        Optional<Customer> item = Optional.ofNullable(service.update(id, DtoFactory.fromCustomerDto(dto), partial).orElseThrow(() -> {
            throw new ResourceNotFoundException("Customer %d ikke fundet".formatted(id));
        }));
        return DtoFactory.fromCustomer(item.get());
    }

    /**
     * Sletter en customer.
     *
     * @param id
     * @return en customer med værdien null
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Long id) {
        service.find(id).orElseThrow(() -> new ResourceNotFoundException("Customer %d ikke fundet.".formatted(id)));

        Customer delete = service.delete(id);
        return ResponseEntity.ok().body(delete);
    }

}
