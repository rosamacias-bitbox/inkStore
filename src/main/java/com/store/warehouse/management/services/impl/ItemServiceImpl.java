package com.store.warehouse.management.services.impl;

import com.store.warehouse.management.dto.ItemDTO;
import com.store.warehouse.management.model.entity.Item;
import com.store.warehouse.management.repositories.ItemRepository;
import com.store.warehouse.management.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    private ModelMapper modelMapper;

    @Override
    public List<ItemDTO> getItems() {
        List<Item> items = itemRepository.findAll();
        List<ItemDTO> itemDTOs = new ArrayList<ItemDTO>();
        items.forEach(item->itemDTOs.add(modelMapper.map(item, ItemDTO.class)));
        return itemDTOs;
    }

    public Optional<ItemDTO> getItemById(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        return Optional.of(modelMapper.map(optionalItem.get(), ItemDTO.class));
    }


    @Override
    public void saveItem(ItemDTO itemDTO) {
        Optional.of(itemDTO).ifPresent(i->itemRepository.save(modelMapper.map(i, Item.class)));
    }

    @Override
    public void deleteItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        item.ifPresent(i->itemRepository.delete(i));
    }

}
