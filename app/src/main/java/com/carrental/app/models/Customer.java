package com.carrental.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String[] carsRented;

    public Customer() {}

    public Customer(Long id, String name, String email,String[] carsRented) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.carsRented = carsRented;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getCarsRented() {
        return carsRented;
    }

    public void setCarsRented(String[] carsRented) {
        this.carsRented = carsRented;
    }
}
