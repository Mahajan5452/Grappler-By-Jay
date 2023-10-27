package com.tickets.Repository;

import com.tickets.Entity.Department;
import com.tickets.Entity.ReestimatedTicket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface RestimationRepo extends MongoRepository<ReestimatedTicket,String> {
    List<ReestimatedTicket> findByTicket_Id(String ticketId);
}
