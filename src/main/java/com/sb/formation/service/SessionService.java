package com.sb.formation.service;

import java.util.List;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Session;
import com.sb.formation.reponses.MessageResponse;

public interface SessionService {
	public MessageResponse save(Session session);
    public MessageResponse update(Session session);
    public MessageResponse delete(Long id);
    public List<Session> findAll();
    public Session findById(Long id);
    public MessageResponse deleteAll(List<Session> sessions);

}
