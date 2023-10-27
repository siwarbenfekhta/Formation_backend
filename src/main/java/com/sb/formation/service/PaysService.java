package com.sb.formation.service;

import java.util.List;

import com.sb.formation.entities.Pays;
import com.sb.formation.reponses.MessageResponse;

public interface PaysService {
	public MessageResponse save(Pays pays);
    public MessageResponse update(Pays pays);
    public MessageResponse delete(Long id);
    public List<Pays> findAll();
    public Pays findById(Long id);

}
