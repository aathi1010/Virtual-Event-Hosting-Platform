package com.vep.virtual_event_platform.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Integer maxAttendees;

    @Column(nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;

    // Default Constructor
    public Event() {
    }

    // Parameterized Constructor
    public Event(Long id, String title, String description,
                 LocalDateTime startDate, LocalDateTime endDate,
                 String status, Integer maxAttendees, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.maxAttendees = maxAttendees;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public Integer getMaxAttendees() {
        return maxAttendees;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMaxAttendees(Integer maxAttendees) {
        this.maxAttendees = maxAttendees;
    }

    public String getLocation() {
        return location;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }
}
