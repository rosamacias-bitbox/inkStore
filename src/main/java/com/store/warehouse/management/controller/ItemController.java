package com.store.warehouse.management.controller;

import com.store.warehouse.management.dto.ItemDTO;
import com.store.warehouse.management.services.ItemService;
import com.store.warehouse.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ResponseEntity<List<ItemDTO>> findAll () {
        List<ItemDTO> items = itemService.getItems();
        return ResponseEntity.ok().body(items);
    }

    @RequestMapping("/findById")
    public ResponseEntity<ItemDTO> findById(@PathParam("id") Long id) {
        return ResponseEntity.of(itemService.getItemById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO item) {
        Optional<ItemDTO> savedItemDTO =  itemService.saveItem(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedItemDTO.get().getId())
                .toUri();
        return ResponseEntity.created(location).body(savedItemDTO.get());
    }

    @PostMapping("/update")
    public ResponseEntity<ItemDTO> update(@RequestBody ItemDTO item) {
        Optional<ItemDTO> savedItemDTO =  itemService.saveItem(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedItemDTO.get().getId())
                .toUri();
        return ResponseEntity.created(location).body(savedItemDTO.get());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ItemDTO> delete(@PathParam("id") Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

}
