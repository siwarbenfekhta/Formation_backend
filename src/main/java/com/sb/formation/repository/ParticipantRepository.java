package com.sb.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.formation.entities.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long>{
	boolean existsByNom(String nom);
}
