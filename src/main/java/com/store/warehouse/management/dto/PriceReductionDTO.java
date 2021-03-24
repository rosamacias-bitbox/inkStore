package com.store.warehouse.management.dto;

import com.store.warehouse.management.model.entity.Item;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

public class PriceReductionDTO {

    private Long id;
    private Item item;
    private double reducedPrice;
    private Date startDate;

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

    private Date endtDate;

}
