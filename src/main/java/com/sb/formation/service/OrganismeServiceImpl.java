package com.sb.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Organisme;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.OrganismeRepository;

@Service
public class OrganismeServiceImpl implements OrganismeService{
	@Autowired
	private OrganismeRepository organismeRepo ; 
	
	@Transactional
    @Override
    public MessageResponse save(Organisme organisme) {
        boolean existe = organismeRepo.existsByLibelle(organisme.getLibelle());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette organisme existe déja !");
        }
        organismeRepo.save(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }


    @Transactional
    @Override
    public MessageResponse update(Organisme organisme) {
        boolean existe = organismeRepo.existsById(organisme.getId());
        if (!existe){
            boolean existe1 = organismeRepo.existsByLibelle(organisme.getLibelle());
            return new MessageResponse(false,"Echec !","Cette organisme existe déja !");

        }
        organismeRepo.save(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Organisme organisme = findById(id);
        if (organisme==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        organismeRepo.delete(organisme);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Override
    public List<Organisme> findAll() {

        return organismeRepo.findAll();
    }
    
	@Transactional
	@Override
	public MessageResponse deleteAll(List<Organisme> organismes) {
		organismeRepo.deleteAll(organismes);
        return new MessageResponse(true,"Succès", "les enregistrements ont été supprimés avec succès.");

	}

    @Override
    public Organisme findById(Long id) {
    	Organisme organisme = organismeRepo.findById(id).orElse(null);
        return organisme;
    }

}
