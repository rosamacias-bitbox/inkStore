package com.store.warehouse.management.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class PriceReduction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Item item;

    @Column
    private double reducedPrice;

    @Column
    private Date startDate;

    @Column
    private Date endtDate;
}
