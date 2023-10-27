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

import com.sb.formation.entities.Participant;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.ParticipantServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/participant")
public class ParticipantController {
	  @Autowired
	    private ParticipantServiceImpl participantService;

	    //@RequestMapping(value="/participant", method=RequestMethod.GET)
	    @GetMapping
	    @PreAuthorize("hasRole('USER')")
	    public List<Participant> findAll() {
	        return participantService.findAll();
	    }

	    @PostMapping
	    @PreAuthorize("hasRole('USER')")
	    public MessageResponse save(@RequestBody Participant participant) {
	        return participantService.save(participant);
	    }

	    @PutMapping
	    @PreAuthorize("hasRole('USER')")
	    public MessageResponse update(@RequestBody Participant participant) {
	        return participantService.update(participant);
	    }

	   @GetMapping("/{code}")
	   @PreAuthorize("hasRole('USER')")
	    public Participant findById(@PathVariable("code") Long id) {
	        return participantService.findById(id);
	    }

	    @DeleteMapping("/{id}")
	    @PreAuthorize("hasRole('USER')")
	    public MessageResponse delete(@PathVariable Long id) {
	        return participantService.delete(id);
	    }
}
