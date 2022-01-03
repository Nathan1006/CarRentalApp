package com.carrental.app.controllers;

import com.carrental.app.models.Rental;
import com.carrental.app.repositories.CustomerRepository;
import com.carrental.app.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalRepository rentals;

    @GetMapping
    public @ResponseBody
    List<Rental> getAllRentals() {
        return rentals.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Rental findRental (@PathVariable Long id){
        return rentals.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Rental> createRental (@RequestBody Rental newRental) {
        return new ResponseEntity<>(rentals.save(newRental), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Rental updateRental (@PathVariable Long id, @RequestBody Rental updates) {
        Rental rental = rentals.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getId() != null) rental.setId(updates.getId());

        return rentals.save(updates);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRental (@PathVariable Long id) {
        rentals.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
