package com.store.warehouse.management.controller;

import com.store.warehouse.management.dto.SupplierDTO;
import com.store.warehouse.management.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/findAll")
    public ResponseEntity<List<SupplierDTO>> findAll () {
        List<SupplierDTO> suppliers = supplierService.getSuppliers();
        return ResponseEntity.ok().body(suppliers);
    }

    @RequestMapping("/findById")
    public ResponseEntity<SupplierDTO> findById(@PathParam("id") Long id) {
        return ResponseEntity.of(supplierService.getSupplierById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<SupplierDTO> create(@RequestBody SupplierDTO suppliers) {
        Optional<SupplierDTO> savedSupplierDTO =  supplierService.saveSupplier(suppliers);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedSupplierDTO.get().getId())
                .toUri();
        return ResponseEntity.created(location).body(savedSupplierDTO.get());
    }

    
    @DeleteMapping("/delete")
    public ResponseEntity<SupplierDTO> delete(@PathParam("id") Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

}
