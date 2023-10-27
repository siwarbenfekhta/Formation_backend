package com.sb.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.formation.entities.Pays;

public interface PaysRepository extends JpaRepository<Pays, Long>{
	boolean existsByLibelle(String libelle);

}

	