package com.store.warehouse.management.repositories;

import com.store.warehouse.management.model.Item;
import com.store.warehouse.management.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
