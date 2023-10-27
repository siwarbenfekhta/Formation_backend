package com.sb.formation.service;

import java.util.List;

import com.sb.formation.entities.Participant;
import com.sb.formation.reponses.MessageResponse;

public interface ParticipantService {
	public MessageResponse save(Participant participant);
    public MessageResponse update(Participant participant);
    public MessageResponse delete(Long id);
    public List<Participant> findAll();
    public Participant findById(Long id);
}
