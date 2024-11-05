package com.store.StockManagementSystem.service;

import com.store.StockManagementSystem.model.Inventory;
import com.store.StockManagementSystem.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryItemById(Long id) {
        return inventoryRepository.findById(id);
    }

    public Inventory addInventoryItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventoryQuantity(Long id, Integer quantity) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
        if (inventoryOptional.isPresent()) {
            Inventory inventory = inventoryOptional.get();
            inventory.setQuantity(quantity);
            return inventoryRepository.save(inventory);
        }
        return null;
    }
}
