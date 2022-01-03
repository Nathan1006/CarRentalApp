package com.carrental.app.controllers;

import com.carrental.app.models.Customer;
import com.carrental.app.models.Vehicle;
import com.carrental.app.repositories.CustomerRepository;
import com.carrental.app.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/vehicles")
public class VehiclesController {
    @Autowired
    private VehicleRepository vehicles;

    @GetMapping
    public @ResponseBody
    List<Vehicle> getAllVehicles() {
        return vehicles.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Vehicle findVehicle (@PathVariable Long id){
        return vehicles.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle (@RequestBody Vehicle newVehicle) {
        return new ResponseEntity<>(vehicles.save(newVehicle), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Vehicle updateVehicle (@PathVariable Long id, @RequestBody Vehicle updates) {
        Vehicle vehicle = vehicles.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getAvailable() != null) vehicle.setAvailable(updates.getAvailable());

        return vehicles.save(updates);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle (@PathVariable Long id) {
        vehicles.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
