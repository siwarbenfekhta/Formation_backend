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
import com.sb.formation.entities.Organisme;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.OrganismeServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/organisme")
public class OrganismeController {
    @Autowired
    private OrganismeServiceImpl organismeService;
    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Organisme> findAll() {
        return organismeService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponse save(@RequestBody Organisme organisme) {
        return organismeService.save(organisme);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponse update(@RequestBody Organisme organisme) {
        return organismeService.update( organisme);
    }

   @GetMapping("/{code}")
   @PreAuthorize("hasRole('ADMIN')")
    public Organisme findById(@PathVariable("code") Long id) {
        return organismeService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponse delete(@PathVariable Long id) {
        return organismeService.delete(id);
    }
    @PostMapping(value = "/delete")
    public MessageResponse deleteAll(@RequestBody List<Organisme> organismes) {
        return organismeService.deleteAll(organismes);
    }
}
