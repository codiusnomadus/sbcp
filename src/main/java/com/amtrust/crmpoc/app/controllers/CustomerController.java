package com.amtrust.crmpoc.app.services;

import com.amtrust.crmpoc.app.entities.Customer;
import com.amtrust.crmpoc.app.repositories.CustomerRepository;
import com.amtrust.crmpoc.exceptions.CustomerIdMismatchException;
import com.amtrust.crmpoc.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public Iterable<Customer> index() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer show(@PathVariable Long id) throws CustomerNotFoundException {
        return customerRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable Long id) {
        if (customer.getId() != id) {
            throw new CustomerIdMismatchException();
        }

        customerRepository.findById(id)
            .orElseThrow(CustomerNotFoundException::new);

        return customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void destroy(@PathVariable Long id) {
        customerRepository.findById(id)
                .orElseThrow(CustomerNotFoundException::new);
        customerRepository.deleteById(id);
    }
}
