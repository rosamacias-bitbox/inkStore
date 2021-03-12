package com.store.warehouse.management.repositories;

import com.store.warehouse.management.model.entity.ItemDiscontinuedAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDiscontinuedActionRepository extends JpaRepository<ItemDiscontinuedAction, Long> {
}
