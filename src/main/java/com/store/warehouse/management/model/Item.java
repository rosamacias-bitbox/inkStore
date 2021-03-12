package com.store.warehouse.management.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column(nullable = false, unique = true)
    private Long code;

    @Column
    @NotNull
    private String description;

    @Column
    private double price;

    @Column
    @Enumerated(EnumType.STRING)
    private STATE state;

    @Column
    private Date creationDate;

    @ManyToMany
    private Set<Supplier> suppliers;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<PriceReduction> priceReductions;

    @ManyToOne
    @NotNull
    private User user;


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<ItemDiscontinuedAction> discontinuedAction;


    public Item() {
        this.state = STATE.AVAILABLE;
        this.creationDate = new Date();
        this.suppliers = new HashSet<Supplier>();
        this.priceReductions =new HashSet<PriceReduction>();
        this.discontinuedAction = new HashSet<ItemDiscontinuedAction>();
    }

    public Item(String name, Long code, String description, double price, STATE state, Set<Supplier> suppliers, User user) {
        this();
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
        this.suppliers = suppliers;
        this.user = user;
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

    public void addSupplier(Supplier supplier){
        if (this.suppliers == null)
            this.suppliers = new HashSet<Supplier>();
        if (!this.suppliers.contains(supplier))
            this.suppliers.add(supplier);
    }

    public Set<PriceReduction> getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(Set<PriceReduction> priceReductions) {
        this.priceReductions = priceReductions;
    }

    public void addPriceReductions(PriceReduction priceReduction) {
        if (this.priceReductions == null)
            this.priceReductions = new HashSet<PriceReduction>();
        this.priceReductions.add(priceReduction);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ItemDiscontinuedAction> getDiscontinuedAction() {
        return discontinuedAction;
    }

    public void setDiscontinuedAction(Set<ItemDiscontinuedAction> discontinuedAction) {
        this.discontinuedAction = discontinuedAction;
    }
}
