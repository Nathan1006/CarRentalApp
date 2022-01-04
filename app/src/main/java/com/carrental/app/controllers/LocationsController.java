package com.carrental.app.controllers;

import com.carrental.app.models.Location;
import com.carrental.app.repositories.CustomerRepository;
import com.carrental.app.repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/locations")
public class LocationsController {
    @Autowired
    private LocationsRepository locations;

    @GetMapping
    public @ResponseBody List<Location> getAllVehicles() {
        return locations.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Location findLocation (@PathVariable Long id){
        return locations.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Location> createLocation (@RequestBody Location newLocation) {
        return new ResponseEntity<>(locations.save(newLocation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Location updateLocation (@PathVariable Long id, @RequestBody Location updates) {
        Location location = locations.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getId() != null) location.setId(updates.getId());

        return locations.save(updates);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation (@PathVariable Long id) {
        locations.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
