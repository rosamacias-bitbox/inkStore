package com.store.warehouse.management.controller;

import com.store.warehouse.management.dto.ItemDTO;
import com.store.warehouse.management.services.ItemService;
import com.store.warehouse.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<ItemDTO> findAll () {
        return itemService.getItems();
    }

    @RequestMapping("/findById")
    public ResponseEntity<ItemDTO> findById(@PathParam("id") Long id) {
        return ResponseEntity.of(itemService.getItemById(id));
    }

    @PostMapping("/save")
    public ResponseEntity createItem(@RequestBody ItemDTO item) {
        Optional<ItemDTO> itemDTO =  itemService.saveItem(item);
        if (itemDTO.isEmpty())
            new ResponseEntity("Error creating item", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/delete")
    public void deleteItem(@PathParam("id") Long id) {
        itemService.deleteItem(id);
    }
}
