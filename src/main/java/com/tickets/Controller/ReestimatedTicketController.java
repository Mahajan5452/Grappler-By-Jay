package com.tickets.Controller;

import com.tickets.Entity.ReestimatedTicket;
import com.tickets.Repository.RestimationRepo;
import com.tickets.service.RestiamtedTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reestimated-tickets")
public class ReestimatedTicketController {

    @Autowired
    private RestiamtedTicketService reestimatedTicketService;

    @PostMapping
    public ReestimatedTicket createReestimatedTicket(@RequestBody ReestimatedTicket reestimatedTicket) {
        return reestimatedTicketService.createReestimatedTicket(reestimatedTicket);
    }

    @GetMapping
    public List<ReestimatedTicket> getReestimatedTickets() {
        return reestimatedTicketService.getReestimatedTickets();
    }

    @GetMapping("/{id}")
    public Optional<ReestimatedTicket> getReestimatedTicketById(@PathVariable String id) {
        return reestimatedTicketService.getReestimatedTicketById(id);
    }

    @PutMapping("/{id}")
    public ReestimatedTicket updateReestimatedTicket(@PathVariable String id, @RequestBody ReestimatedTicket reestimatedTicket) {
        return reestimatedTicketService.updateReestimatedTicket(id, reestimatedTicket);
    }

    @DeleteMapping("/{id}")
    public String deleteReestimatedTicket(@PathVariable String id) {
        return reestimatedTicketService.deleteReestimatedTicket(id);
    }

}

