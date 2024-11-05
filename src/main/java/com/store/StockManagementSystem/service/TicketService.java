package com.store.StockManagementSystem.service;

import com.store.StockManagementSystem.model.Ticket;
import com.store.StockManagementSystem.model.TicketStatus;
import com.store.StockManagementSystem.model.User;
import com.store.StockManagementSystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket) {
        ticket.setStatus(TicketStatus.NEW);
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket assignTechnician(Long ticketId, User technician) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            ticket.setAssignedTechnician(technician);
            ticket.setStatus(TicketStatus.ASSIGNED);
            return ticketRepository.save(ticket);
        }
        return null;
    }

    public Ticket updateTicketStatus(Long ticketId, TicketStatus status) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            ticket.setStatus(status);
            return ticketRepository.save(ticket);
        }
        return null;
    }
}
