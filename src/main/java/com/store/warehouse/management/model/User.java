package com.store.warehouse.management.model;


import java.io.Serializable;
import javax.persistence.*;


@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;
}
