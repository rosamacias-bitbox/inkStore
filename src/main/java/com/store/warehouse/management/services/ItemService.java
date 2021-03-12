package com.store.warehouse.management.services;

import com.store.warehouse.management.dto.ItemDTO;
import com.store.warehouse.management.model.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    public List<ItemDTO> getItems() ;
    public Optional<ItemDTO> getItemById(Long id);
    public void saveItem(ItemDTO item);
    public void deleteItem(Long id);

}
