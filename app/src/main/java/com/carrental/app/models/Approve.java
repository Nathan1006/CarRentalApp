package com.carrental.app.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;

@Entity
public class Approve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonIncludeProperties("id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id", referencedColumnName = "id")
    @JsonIncludeProperties("id")
    private Rental rental;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @JsonIncludeProperties("id")
    private Vehicle vehicle;

    public Approve() {
    }

    public Approve(Customer customer, Rental rental, Vehicle vehicle) {
        this.customer = customer;
        this.rental = rental;
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
