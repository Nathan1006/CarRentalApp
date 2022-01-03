package com.carrental.app.controllers;

import com.carrental.app.repositories.CustomerRepository;
import com.carrental.app.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalRepository rentals;

}
