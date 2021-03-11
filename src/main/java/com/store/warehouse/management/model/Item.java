package com.store.warehouse.management.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column
    private String name;

    @Column(nullable=false, unique=true)
    private Long code;

    @Column
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


    @OneToMany
    private Set<PriceReduction> priceReductions;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

}
