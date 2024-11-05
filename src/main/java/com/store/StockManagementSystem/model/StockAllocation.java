package com.store.StockManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StockAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Inventory inventoryItem;

    private Integer allocatedQuantity;

    @ManyToOne
    private User allocatedBy;
    
    private LocalDateTime allocatedAt = LocalDateTime.now();

    public StockAllocation(Ticket ticket, Inventory inventoryItem, Integer allocatedQuantity, User allocatedBy) {
        this.ticket = ticket;
        this.inventoryItem = inventoryItem;
        this.allocatedQuantity = allocatedQuantity;
        this.allocatedBy = allocatedBy;
    }
}
