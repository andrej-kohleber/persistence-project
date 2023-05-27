package com.baeldung.lsd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();
    
    private String name;
    
    private String description;
    
    private LocalDate dueDate;
    
    private TaskStatus status;
    
    @ManyToOne(optional = false)
    private Project project;
    
    @ManyToOne
    private Worker assignee;
    
    public Task() {}

    public Task(String name, String description, LocalDate dueDate, Project project, TaskStatus status) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;
    }

    public Task(String name, String description, LocalDate dueDate, Project project) {
        this(name, description, dueDate, project, TaskStatus.IN_PROGRESS);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Worker getAssignee() {
        return assignee;
    }

    public void setAssignee(Worker assignee) {
        this.assignee = assignee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task other = (Task) o;
        if (uuid == null) {
            if (other.uuid != null) 
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
