package com.sb.formation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Organisme;
import com.sb.formation.reponses.MessageResponse;
@Service
public interface OrganismeService {
    public MessageResponse save(Organisme organisme);
    public MessageResponse update(Organisme organisme);
    public MessageResponse delete(Long id);
    public List<Organisme> findAll();
    public Organisme findById(Long id);
    public MessageResponse deleteAll(List<Organisme> organismes);

}
