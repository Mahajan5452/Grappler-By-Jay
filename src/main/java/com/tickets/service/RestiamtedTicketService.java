package com.tickets.service;

import com.tickets.Entity.ReestimatedTicket;
import com.tickets.Repository.RestimationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestiamtedTicketService {

    @Autowired
    private RestimationRepo reestimatedTicketRepository;


    public ReestimatedTicket createReestimatedTicket(ReestimatedTicket reestimatedTicket) {
        return reestimatedTicketRepository.save(reestimatedTicket);
    }


    public List<ReestimatedTicket> getReestimatedTickets() {
        return reestimatedTicketRepository.findAll();
    }


    public Optional<ReestimatedTicket> getReestimatedTicketById(String id) {
        return reestimatedTicketRepository.findById(id);
    }


    public ReestimatedTicket updateReestimatedTicket(String id, ReestimatedTicket reestimatedTicket) {
        Optional<ReestimatedTicket> existingTicket = reestimatedTicketRepository.findById(id);
        if (existingTicket.isPresent()) {
            ReestimatedTicket updatedTicket = existingTicket.get();
            updatedTicket.setNewDate(reestimatedTicket.getNewDate());
            updatedTicket.setReason(reestimatedTicket.getReason());
            updatedTicket.setStatus(reestimatedTicket.getStatus());
            return reestimatedTicketRepository.save(updatedTicket);
        }
        return null;
    }


    public String deleteReestimatedTicket(String id) {
        reestimatedTicketRepository.deleteById(id);
        return "Reestimated Ticket with ID " + id + " has been deleted.";
    }
}
