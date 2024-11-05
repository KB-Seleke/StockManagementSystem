package com.store.StockManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private Integer quantity;
    private Integer minRequired;

    public Inventory(String itemName, Integer quantity, Integer minRequired) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.minRequired = minRequired;
    }
}
