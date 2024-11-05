package com.store.StockManagementSystem.controller;

import com.store.StockManagementSystem.model.Ticket;
import com.store.StockManagementSystem.model.TicketStatus;
import com.store.StockManagementSystem.model.User;
import com.store.StockManagementSystem.service.TicketService;
import com.store.StockManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final UserService userService;

    @Autowired
    public TicketController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.ok(createdTicket);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticketOptional = ticketService.getTicketById(id);
        return ticketOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/assign")
    public ResponseEntity<Ticket> assignTechnician(@PathVariable Long id, @RequestParam Long technicianId) {
        Optional<User> technicianOptional = userService.getUserById(technicianId);
        if (technicianOptional.isPresent()) {
            Ticket updatedTicket = ticketService.assignTechnician(id, technicianOptional.get());
            return ResponseEntity.ok(updatedTicket);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Ticket> updateTicketStatus(@PathVariable Long id, @RequestParam TicketStatus status) {
        Ticket updatedTicket = ticketService.updateTicketStatus(id, status);
        if (updatedTicket != null) {
            return ResponseEntity.ok(updatedTicket);
        }
        return ResponseEntity.notFound().build();
    }
}
