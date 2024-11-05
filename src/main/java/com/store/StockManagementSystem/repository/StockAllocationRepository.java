package com.store.StockManagementSystem.repository;


import com.store.StockManagementSystem.model.StockAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockAllocationRepository extends JpaRepository<StockAllocation, Long> {}
