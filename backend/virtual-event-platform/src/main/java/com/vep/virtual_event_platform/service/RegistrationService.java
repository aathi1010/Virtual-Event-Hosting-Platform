package com.vep.virtual_event_platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vep.virtual_event_platform.entity.Event;
import com.vep.virtual_event_platform.entity.Registration;
import com.vep.virtual_event_platform.entity.User;
import com.vep.virtual_event_platform.repository.EventRepository;
import com.vep.virtual_event_platform.repository.RegistrationRepository;
import com.vep.virtual_event_platform.repository.UserRepository;

@Service
public class RegistrationService {
    
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public Registration saveRegistration(Registration registration) {

        User user = userRepository.findById(
                registration.getUser().getId())
                .orElseThrow();

        Event event = eventRepository.findById(
                registration.getEvent().getId())
                .orElseThrow();

        registration.setUser(user);
        registration.setEvent(event);

        return registrationRepository.save(registration);
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration getRegistrationById(Long id) {
        return registrationRepository.findById(id).orElse(null);
    }

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    public Registration updateRegistration(Long id,
                                       Registration updatedRegistration) {

        Registration registration =
                registrationRepository.findById(id).orElse(null);

        if (registration != null) {

            registration.setRegistrationDate(
                    updatedRegistration.getRegistrationDate());

            registration.setStatus(
                    updatedRegistration.getStatus());

            User user = userRepository.findById(
                    updatedRegistration.getUser().getId())
                    .orElseThrow();

            Event event = eventRepository.findById(
                    updatedRegistration.getEvent().getId())
                    .orElseThrow();

            registration.setUser(user);
            registration.setEvent(event);

            return registrationRepository.save(registration);
        }

        return null;
    }
}
