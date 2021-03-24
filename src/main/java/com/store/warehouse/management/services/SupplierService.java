package com.store.warehouse.management.services;

import com.store.warehouse.management.dto.SupplierDTO;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    public List<SupplierDTO> getSuppliers();
    public Optional<SupplierDTO> getSupplierById(Long id);
    public Optional<SupplierDTO> saveSupplier(SupplierDTO item);
    public void deleteSupplier(Long id);

}
