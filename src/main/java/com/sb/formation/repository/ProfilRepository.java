package com.sb.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.formation.entities.Profil;

public interface ProfilRepository extends JpaRepository<Profil, Long> {
    boolean existsByLibelle(String libelle);

}
