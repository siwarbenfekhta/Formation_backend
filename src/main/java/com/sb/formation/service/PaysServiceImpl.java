package com.sb.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.formation.entities.Pays;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.PaysRepository;

@Service
public class PaysServiceImpl implements PaysService {

@Autowired
PaysRepository paysRepository;

    @Transactional
    @Override
    public MessageResponse save(Pays pays) {
        boolean existe = paysRepository.existsByLibelle(pays.getLibelle());
        if (existe){
            return new MessageResponse(false,"Echec !","Ce pays existe déja !");
        }
        paysRepository.save(pays);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }


    @Transactional
    @Override
    public MessageResponse update(Pays pays) {
        boolean existe = paysRepository.existsById(pays.getId());
        if (!existe){
            boolean existe1 = paysRepository.existsByLibelle(pays.getLibelle());
            return new MessageResponse(false,"Echec !","Cette pays existe déja !");

        }
        paysRepository.save(pays);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Pays pays = findById(id);
        if (pays==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        paysRepository.delete(pays);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Override
    public List<Pays> findAll() {

        return paysRepository.findAll();
    }

    @Override
    public Pays findById(Long id) {
        Pays pays = paysRepository.findById(id).orElse(null);
        return pays;
    }
}
