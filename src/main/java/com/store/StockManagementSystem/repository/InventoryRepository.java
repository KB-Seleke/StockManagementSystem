package com.store.StockManagementSystem.repository;

import com.store.StockManagementSystem.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {}
