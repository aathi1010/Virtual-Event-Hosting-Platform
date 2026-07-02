package com.vep.virtual_event_platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vep.virtual_event_platform.entity.Session;
import com.vep.virtual_event_platform.service.SessionService;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping
    public Session saveSession(@RequestBody Session session) {
        return sessionService.saveSession(session);
    }

    @GetMapping
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/{id}")
    public Session getSession(@PathVariable Long id) {
        return sessionService.getSessionById(id);
    }

    @PutMapping("/{id}")
    public Session updateSession(@PathVariable Long id,
                                 @RequestBody Session session) {
        return sessionService.updateSession(id, session);
    }

    @DeleteMapping("/{id}")
    public String deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
        return "Session deleted successfully";
    }
}