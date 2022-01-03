package com.carrental.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rental {
    @Id
    @GeneratedValue
    private Long id;
    private String pickupDate;
    private String returnDate;
    private String finalCost;

    public Rental() {
    }

    public Rental(Long id, String pickupDate, String returnDate, String finalCost) {
        this.id = id;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.finalCost = finalCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(String finalCost) {
        this.finalCost = finalCost;
    }
}
