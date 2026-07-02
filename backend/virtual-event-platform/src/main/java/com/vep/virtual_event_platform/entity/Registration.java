package com.vep.virtual_event_platform.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime registrationDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public Registration() {
    }

    public Registration(Long id, LocalDateTime registrationDate,
                        String status, User user, Event event) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.status = status;
        this.user = user;
        this.event = event;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}