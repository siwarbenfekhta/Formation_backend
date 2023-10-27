package com.sb.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.formation.entities.Formateur;
@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {
	boolean existsByNom(String nom);
}
