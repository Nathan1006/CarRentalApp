package com.carrental.app.controllers;

import com.carrental.app.models.Customer;
import com.carrental.app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customers;

    @GetMapping
    public @ResponseBody List<Customer> getCustomers() {
        return customers.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Customer findCustomer (@PathVariable Long id){
        return customers.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer (@RequestBody Customer newCustomer) {
        return new ResponseEntity<>(customers.save(newCustomer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Customer updateCustomer (@PathVariable Long id, @RequestBody Customer updates) {
        Customer customer = customers.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) customer.setName(updates.getName());
        if (updates.getEmail() != null) customer.setEmail(updates.getEmail());

        return customers.save(updates);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer (@PathVariable Long id) {
        customers.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
