package com.store.warehouse.management.model.entity;

import javax.persistence.*;
import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndtDate() {
        return endtDate;
    }

    public void setEndtDate(Date endtDate) {
        this.endtDate = endtDate;
    }
}
