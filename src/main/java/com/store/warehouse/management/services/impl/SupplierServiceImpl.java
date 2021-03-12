package com.store.warehouse.management.services.impl;

import com.store.warehouse.management.dto.ItemDTO;
import com.store.warehouse.management.dto.SupplierDTO;
import com.store.warehouse.management.model.entity.Supplier;
import com.store.warehouse.management.repositories.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl {

    @Autowired
    private SupplierRepository supplierRepository;

    private ModelMapper modelMapper;

    public List<SupplierDTO> getSuppliers(){
        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierDTO> supplierDTOs = new ArrayList<SupplierDTO>();
        suppliers.forEach(supplier->supplierDTOs.add(modelMapper.map(supplier, SupplierDTO.class)));
        return supplierDTOs;
    }
}
