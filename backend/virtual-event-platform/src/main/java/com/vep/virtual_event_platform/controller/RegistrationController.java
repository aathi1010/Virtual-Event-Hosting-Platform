package com.vep.virtual_event_platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vep.virtual_event_platform.entity.Registration;
import com.vep.virtual_event_platform.service.RegistrationService;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public Registration saveRegistration(
            @RequestBody Registration registration) {

        return registrationService.saveRegistration(registration);
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public Registration getRegistration(
            @PathVariable Long id) {

        return registrationService.getRegistrationById(id);
    }

    @PutMapping("/{id}")
    public Registration updateRegistration(
            @PathVariable Long id,
            @RequestBody Registration registration) {

        return registrationService.updateRegistration(id, registration);
    }

    @DeleteMapping("/{id}")
    public String deleteRegistration(
            @PathVariable Long id) {

        registrationService.deleteRegistration(id);
        return "Registration deleted successfully";
    }
}
