package com.store.warehouse.management.services.impl;

import com.store.warehouse.management.dto.ItemDTO;
import com.store.warehouse.management.model.entity.Item;
import com.store.warehouse.management.model.entity.User;
import com.store.warehouse.management.repositories.ItemRepository;
import com.store.warehouse.management.repositories.UserRepository;
import com.store.warehouse.management.services.ItemService;
import com.store.warehouse.management.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
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
        if (optionalItem.isPresent())
            return  Optional.of(modelMapper.map(optionalItem.get(), ItemDTO.class));
        return Optional.empty();
    }


    @Override
    public Optional<ItemDTO> saveItem(ItemDTO itemDTO) {
        if (Optional.of(itemDTO).isPresent()) {
            if (itemDTO.getUser() == null) //it's a new item, set its creator
                itemDTO.setUser(getLoggedUser());
            Item item = itemRepository.save(modelMapper.map(itemDTO, Item.class));
            return Optional.of(modelMapper.map(item, ItemDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public void deleteItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        item.ifPresent(i->itemRepository.delete(i));
    }


    private User getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username);
    }
}
