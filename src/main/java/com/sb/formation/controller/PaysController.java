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

import com.sb.formation.entities.Pays;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.PaysServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/pays")
public class PaysController {
	
	 @Autowired
	    private PaysServiceImpl paysService;

	    @GetMapping
	    @PreAuthorize("hasRole('ADMIN')")
	    public List<Pays> findAll() {
	        return paysService.findAll();
	    }

	    @PostMapping
	    @PreAuthorize("hasRole('ADMIN')")
	    public MessageResponse save(@RequestBody Pays pays) {
	        return paysService.save(pays);
	    }

	    @PutMapping
	    @PreAuthorize("hasRole('ADMIN')")
	    public MessageResponse update(@RequestBody Pays pays) {
	        return paysService.update(pays);
	    }

	   @GetMapping("/{code}")
	   @PreAuthorize("hasRole('ADMIN')")
	    public Pays findById(@PathVariable("code") Long id) {
	        return paysService.findById(id);
	    }

	    @DeleteMapping("/{id}")
	    @PreAuthorize("hasRole('ADMIN')")
	    public MessageResponse delete(@PathVariable Long id) {
	        return paysService.delete(id);
	    }

}
