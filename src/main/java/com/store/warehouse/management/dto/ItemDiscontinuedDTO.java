package com.store.warehouse.management.dto;


import com.store.warehouse.management.model.entity.Item;
import com.store.warehouse.management.model.entity.User;
import java.util.Date;

public class ItemDiscontinuedDTO {

    private Long id;
    private Item item;
    private Date date;
    private User user;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
