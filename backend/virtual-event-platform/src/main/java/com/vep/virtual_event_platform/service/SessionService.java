package com.vep.virtual_event_platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vep.virtual_event_platform.entity.Event;
import com.vep.virtual_event_platform.entity.Session;
import com.vep.virtual_event_platform.repository.EventRepository;
import com.vep.virtual_event_platform.repository.SessionRepository;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private EventRepository eventRepository;

    public Session saveSession(Session session) {

        Event event = eventRepository
                .findById(session.getEvent().getId())
                .orElseThrow();

        session.setEvent(event);

        return sessionRepository.save(session);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session getSessionById(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }

    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }

    public Session updateSession(Long id, Session updatedSession) {

        Session session = sessionRepository.findById(id).orElse(null);

        if (session != null) {

            session.setTitle(updatedSession.getTitle());
            session.setDescription(updatedSession.getDescription());
            session.setSpeaker(updatedSession.getSpeaker());
            session.setStartTime(updatedSession.getStartTime());
            session.setEndTime(updatedSession.getEndTime());
            session.setMeetingLink(updatedSession.getMeetingLink());

            Event event = eventRepository
                    .findById(updatedSession.getEvent().getId())
                    .orElseThrow();

            session.setEvent(event);

            return sessionRepository.save(session);
        }

        return null;
    }
}