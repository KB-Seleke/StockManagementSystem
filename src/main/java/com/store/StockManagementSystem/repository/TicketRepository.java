package com.store.StockManagementSystem.repository;

import com.store.StockManagementSystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {}
