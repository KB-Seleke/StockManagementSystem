package com.store.StockManagementSystem.controller;

import com.store.StockManagementSystem.model.Inventory;
import com.store.StockManagementSystem.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventoryItems() {
        return ResponseEntity.ok(inventoryService.getAllInventoryItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryItemById(@PathVariable Long id) {
        Optional<Inventory> inventoryOptional = inventoryService.getInventoryItemById(id);
        return inventoryOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inventory> addInventoryItem(@RequestBody Inventory inventory) {
        Inventory addedInventory = inventoryService.addInventoryItem(inventory);
        return ResponseEntity.ok(addedInventory);
    }

    @PutMapping("/{id}/quantity")
    public ResponseEntity<Inventory> updateInventoryQuantity(@PathVariable Long id, @RequestParam Integer quantity) {
        Inventory updatedInventory = inventoryService.updateInventoryQuantity(id, quantity);
        if (updatedInventory != null) {
            return ResponseEntity.ok(updatedInventory);
        }
        return ResponseEntity.notFound().build();
    }
}
