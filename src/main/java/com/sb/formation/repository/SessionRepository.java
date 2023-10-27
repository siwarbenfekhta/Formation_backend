package com.sb.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.formation.entities.Session;

public interface SessionRepository  extends JpaRepository<Session, Long>{

}
