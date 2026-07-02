package com.vep.virtual_event_platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vep.virtual_event_platform.entity.Event;
import com.vep.virtual_event_platform.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public Event saveEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id,
                             @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "Event deleted successfully";
    }
}