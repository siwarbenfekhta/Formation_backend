package com.sb.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sb.formation.entities.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
	boolean existsByTitre(String titre);
	
	@Query(value = "SELECT count(*) FROM `formation` WHERE type_formation='NATIONAL' " , nativeQuery = true)
	int  nbNat();
	
	@Query(value = "SELECT count(*) FROM `formation` WHERE type_formation='INTERNATIONAL' " , nativeQuery = true)
	int  nbInterna();

}
