package com.store.warehouse.management.dto;

import com.store.warehouse.management.model.STATE;
import com.store.warehouse.management.model.entity.PriceReduction;
import com.store.warehouse.management.model.entity.Supplier;
import com.store.warehouse.management.model.entity.User;

import java.util.Date;
import java.util.Set;

public class ItemDTO {

    private Long id;
    private String name;
    private Long code;
    private String description;
    private double price;
    private STATE state;
    private Date creationDate;
    private Set<Supplier> suppliers;
    private Set<PriceReduction> priceReductions;
    private User user;

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

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public STATE getState() {
        return state;
    }

    public void setState(STATE state) {
        this.state = state;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<PriceReduction> getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(Set<PriceReduction> priceReductions) {
        this.priceReductions = priceReductions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
