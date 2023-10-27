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
import com.sb.formation.entities.Session;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.SessionServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/session")
public class SessionController {
	
	@Autowired
    private SessionServiceImpl sessionService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<Session> findAll() {
        return sessionService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public MessageResponse save(@RequestBody Session session) {
        return sessionService.save(session);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public MessageResponse update(@RequestBody Session session) {
        return sessionService.update(session);
    }

   @GetMapping("/{code}")
   @PreAuthorize("hasRole('USER')")
    public Session findById(@PathVariable("code") Long id) {
        return sessionService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public MessageResponse delete(@PathVariable Long id) {
        return sessionService.delete(id);
    }
    @PostMapping(value = "/delete")
    public MessageResponse deleteAll(@RequestBody List<Session> sessions) {
        return sessionService.deleteAll(sessions);
    }
}
