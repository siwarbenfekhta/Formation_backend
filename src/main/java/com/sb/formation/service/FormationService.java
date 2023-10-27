package com.sb.formation.service;

import java.util.List;
import com.sb.formation.entities.Formation;
import com.sb.formation.reponses.MessageResponse;

public interface FormationService {
    public MessageResponse save(Formation formation);
    public MessageResponse update(Formation formation);
    public MessageResponse delete(Long id);
    public List<Formation> findAll();
    public Formation findById(Long id);
}
