package com.tickets.Controller;

import com.tickets.Entity.Project;
import com.tickets.Repository.ProjectRepo;
import com.tickets.Repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private TicketRepo ticketRepo;
    @PostMapping()
    public Project createProject(@RequestBody Project project) {
        return projectRepo.save(project);
    }

    @GetMapping
    public List<Project> getprojects() {
        return projectRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public  void deleteProjectById(@PathVariable String id){
        ticketRepo.deleteByProjectIn_Id(id);
        projectRepo.deleteById(id);
    }
}
