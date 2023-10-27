package com.tickets.Entity;

import com.tickets.DTO.RequestBodyTicket;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tickets")
public class Ticket {
    @Id
    private String id;

//    @NotBlank(message = "Name is required")
//    @Size(max = 255, message = "Name cannot be more than 255 characters")
//    private String name;
//
//    @NotBlank(message = "Description is required")
//    @Size(max = 1000, message = "Description cannot be more than 1000 characters")
//    private String description;
//
//    @NotBlank(message = "Created By is required")
//    private String createdBy;
//
//    @NotNull(message = "Start Date is required")
//    private Date startDate;
//
//    @NotNull(message = "End Date is required")
//    private Date endDate;
//
//    @NotNull(message = "Project In is required")
//    @DBRef
//    private Project projectIn;
//
//    @NotBlank(message = "Stage is required")
//    private String stage;
private String name;
    private String description;
    private String createdBy;
    private LocalDateTime startDate;

    private Date endDate;
    private Instant endTime;
    @DBRef
    private Project projectIn;
    private String stage;

    private Priority priority;

    @DBRef
    private Ticket blockedBy;

    @DBRef
    private Ticket parent;


    @DBRef
    private List<User> usersAssignedTo;


  public Ticket(RequestBodyTicket requestBodyTicket) {
      this.id=  requestBodyTicket.getId();
      this.name = requestBodyTicket.getName();
      this.description = requestBodyTicket.getDescription();
     // this.createdBy = requestBodyTicket.getCreatedBy();
      this.startDate = LocalDateTime.now();
      this.endDate = requestBodyTicket.getEndDate();
      this.endTime=Instant.parse(requestBodyTicket.getEndTime());
      this.projectIn = new Project(requestBodyTicket.getProjectIn());
      this.stage = requestBodyTicket.getStage();
      this.priority = Priority.valueOf(requestBodyTicket.getPriority().toUpperCase());


      this.usersAssignedTo = requestBodyTicket.getUsersAssignedTo().stream()
              .map(User::new)
              .collect(Collectors.toList());
  }
    }


