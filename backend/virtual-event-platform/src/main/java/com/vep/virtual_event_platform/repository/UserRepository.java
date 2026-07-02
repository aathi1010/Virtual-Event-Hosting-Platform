package com.vep.virtual_event_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vep.virtual_event_platform.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
