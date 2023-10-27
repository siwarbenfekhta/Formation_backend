package com.sb.formation.controller;

import com.sb.formation.entities.Domaine;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.DomaineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
@CrossOrigin("*")
@RequestMapping("/domaine")
public class DomaineController {

    @Autowired
    private DomaineServiceImpl domaineService;

    //@RequestMapping(value="/domaine", method=RequestMethod.GET)
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Domaine> findAll() {
        return domaineService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponse save(@RequestBody Domaine domaine) {
    	System.out.println("say hi");
        return domaineService.save(domaine);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponse update(@RequestBody Domaine domaine) {
        return domaineService.update(domaine);
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasRole('ADMIN')")
    public Domaine findById(@PathVariable("code") Long id) {
        return domaineService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponse delete(@PathVariable Long id) {
        return domaineService.delete(id);
    }
    
    @PostMapping(value = "/delete")
    public MessageResponse deleteAll(@RequestBody List<Domaine> students) {
        return domaineService.deleteAll(students);
    }
}


