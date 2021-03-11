package com.store.warehouse.management.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String country;

    @ManyToMany (mappedBy = "suppliers")
    private Set<Item> items;
}
