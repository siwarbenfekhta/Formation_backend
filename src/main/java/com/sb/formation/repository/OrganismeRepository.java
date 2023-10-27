package com.sb.formation.repository;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Organisme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganismeRepository extends JpaRepository<Organisme, Long> {

    boolean existsByLibelle(String libelle);
}
