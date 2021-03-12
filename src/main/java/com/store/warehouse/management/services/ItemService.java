package com.store.warehouse.management.services;

import com.store.warehouse.management.model.Item;
import com.store.warehouse.management.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemsRepository;

    public List<Item> list() {
        return itemsRepository.findAll();
    }
}
