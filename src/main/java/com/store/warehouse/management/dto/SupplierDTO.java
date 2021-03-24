package com.store.warehouse.management.dto;


import com.store.warehouse.management.model.entity.Item;

import java.util.Set;

public class SupplierDTO {

    private Long id;
    private String name;
    private String country;
    //private Set<Item> items;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /*
    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

     */
}
