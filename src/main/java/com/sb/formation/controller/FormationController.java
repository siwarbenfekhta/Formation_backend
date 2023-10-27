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

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Formation;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.FormationRepository;
import com.sb.formation.service.DomaineServiceImpl;
import com.sb.formation.service.FormationServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/formation")
public class FormationController {

    @Autowired
    private FormationServiceImpl formationService;
    
    @Autowired
    private FormationRepository formRepo ;
    
    
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Formation> findAll() {
        return formationService.findAll();
    }
    
    @GetMapping("/nat")
    public int nbNat() {
        return formRepo.nbNat();
    }
    
    
    @GetMapping("/intern")
    public int nbIntern() {
        return formRepo.nbInterna();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public MessageResponse save(@RequestBody Formation formation) {
        return formationService.save(formation);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public MessageResponse update(@RequestBody Formation formation) {
        return formationService.update( formation);
    }

   @GetMapping("/{code}")
   @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Formation findById(@PathVariable("code") Long id) {
        return formationService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public MessageResponse delete(@PathVariable Long id) {
        return formationService.delete(id);
    }
}
