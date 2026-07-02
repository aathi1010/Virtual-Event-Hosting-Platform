package com.vep.virtual_event_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vep.virtual_event_platform.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}