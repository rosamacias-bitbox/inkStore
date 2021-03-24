package com.store.warehouse.management.services.impl;


import com.store.warehouse.management.dto.SupplierDTO;
import com.store.warehouse.management.model.entity.Supplier;
import com.store.warehouse.management.repositories.SupplierRepository;
import com.store.warehouse.management.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SupplierDTO> getSuppliers(){
        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierDTO> supplierDTOs = new ArrayList<SupplierDTO>();
        suppliers.forEach(supplier->supplierDTOs.add(modelMapper.map(supplier, SupplierDTO.class)));
        return supplierDTOs;
    }

    @Override
    public Optional<SupplierDTO> getSupplierById(Long id) {
        Optional<Supplier> optional = supplierRepository.findById(id);
        if (optional.isPresent())
            return  Optional.of(modelMapper.map(optional.get(), SupplierDTO.class));
        return Optional.empty();
    }

    @Override
    public Optional<SupplierDTO> saveSupplier(SupplierDTO supplierDTO) {
        if (Optional.of(supplierDTO).isPresent()) {
            Supplier supplier = supplierRepository.save(modelMapper.map(supplierDTO, Supplier.class));
            return Optional.of(modelMapper.map(supplier, SupplierDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public void deleteSupplier(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        supplier.ifPresent(i->supplierRepository.delete(i));
    }
}
