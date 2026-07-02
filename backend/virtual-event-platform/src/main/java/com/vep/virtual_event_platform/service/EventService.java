package com.vep.virtual_event_platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vep.virtual_event_platform.entity.Event;
import com.vep.virtual_event_platform.entity.User;
import com.vep.virtual_event_platform.repository.EventRepository;
import com.vep.virtual_event_platform.repository.UserRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Event updateEvent(Long id, Event updatedEvent) {

        Event event = eventRepository.findById(id).orElse(null);

        if (event != null) {
            event.setTitle(updatedEvent.getTitle());
            event.setDescription(updatedEvent.getDescription());
            event.setStartDate(updatedEvent.getStartDate());
            event.setEndDate(updatedEvent.getEndDate());
            event.setStatus(updatedEvent.getStatus());
            event.setMaxAttendees(updatedEvent.getMaxAttendees());
            event.setLocation(updatedEvent.getLocation());
            User organizer = userRepository
                .findById(updatedEvent.getOrganizer().getId())
                .orElseThrow();

            event.setOrganizer(organizer);

            return eventRepository.save(event);
        }

        return null;
    }
}