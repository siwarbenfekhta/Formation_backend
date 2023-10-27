package com.sb.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.formation.entities.Profil;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.ProfilServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/profil")
public class ProfilController {

    @Autowired
    private ProfilServiceImpl profilService;
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Profil> findAll() {
        return profilService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponse save(@RequestBody Profil profil) {
        return profilService.save(profil);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponse update(@RequestBody Profil profil) {
        return profilService.update(profil);
    }

   @GetMapping("/{code}")
   @PreAuthorize("hasRole('ADMIN')")
    public Profil findById(@PathVariable("code") Long id) {
        return profilService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponse delete(@PathVariable Long id) {
        return profilService.delete(id);
    }
}


