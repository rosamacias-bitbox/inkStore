package com.store.warehouse.management.repositories;

import com.store.warehouse.management.model.entity.PriceReduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceReductionRepository extends JpaRepository<PriceReduction, Long> {
}
