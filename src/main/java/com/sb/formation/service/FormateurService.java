package com.sb.formation.service;


import java.util.List;

import com.sb.formation.entities.Formateur;
import com.sb.formation.reponses.MessageResponse;

public interface FormateurService {
    public MessageResponse save(Formateur formateur);
    public MessageResponse update(Formateur formateur);
    public MessageResponse delete(Long id);
    public List<Formateur> findAll();
    public Formateur findById(Long id);

}
