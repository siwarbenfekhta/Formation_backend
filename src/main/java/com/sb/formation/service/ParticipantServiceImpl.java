package com.sb.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.formation.entities.Organisme;
import com.sb.formation.entities.Participant;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.ParticipantRepository;

@Service
public class ParticipantServiceImpl implements ParticipantService {

@Autowired
ParticipantRepository participantRepository;

    @Transactional
    @Override
    public MessageResponse save(Participant participant) {
        boolean existe = participantRepository.existsByNom(participant.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Ce participant existe déja !");
        }
        else 
        	participantRepository.save(participant);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }


    @Transactional
    @Override
    public MessageResponse update(Participant participant) {
        boolean existe = participantRepository.existsById(participant.getId());
        if (!existe){
            boolean existe1 = participantRepository.existsByNom(participant.getNom());
            return new MessageResponse(false,"Echec !","Cette participant existe déja !");

        }
        participantRepository.save(participant);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Participant participant = findById(id);
        if (participant==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        participantRepository.delete(participant);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Override
    public List<Participant> findAll() {

        return participantRepository.findAll();
    }

    @Override
    public Participant findById(Long id) {
        Participant participant = participantRepository.findById(id).orElse(null);
        return participant;
    }
}
