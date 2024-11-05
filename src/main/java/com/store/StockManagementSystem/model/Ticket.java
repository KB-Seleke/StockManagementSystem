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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @ManyToOne
    private User assignedTechnician;

    @ManyToOne
    private User createdBy;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Ticket(String title, String description, TicketStatus status, User createdBy) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
    }
}
