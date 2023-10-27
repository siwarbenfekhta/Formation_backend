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
import com.sb.formation.entities.Formateur;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.FormateurServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/formateur")
public class FormateurController {
	
	@Autowired
    private FormateurServiceImpl formateurService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<Formateur> findAll() {
        return formateurService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public MessageResponse save(@RequestBody Formateur formateur) {
        return formateurService.save(formateur);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public MessageResponse update(@RequestBody Formateur formateur) {
        return formateurService.update(formateur);
    }

   @GetMapping("/{code}")
   @PreAuthorize("hasRole('USER')")
    public Formateur findById(@PathVariable("code") Long id) {
        return formateurService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public MessageResponse delete(@PathVariable Long id) {
        return formateurService.delete(id);
    }

}
