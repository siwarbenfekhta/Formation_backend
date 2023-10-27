package com.sb.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Formateur;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.FormateurRepository;

@Service
public class FormateurServiceImpl implements FormateurService{
	
	@Autowired
	private FormateurRepository formateurRepo ;
	
	@Transactional
    @Override
    public MessageResponse save(Formateur formateur) {
        boolean existe = formateurRepo.existsByNom(formateur.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Ce formateur existe déja !");
        }
        formateurRepo.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }


    @Transactional
    @Override
    public MessageResponse update(Formateur formateur) {
        boolean existe = formateurRepo.existsById(formateur.getId());
        if (!existe){
            boolean existe1 = formateurRepo.existsByNom(formateur.getNom());
            return new MessageResponse(false,"Echec !","Ce formateur existe déja !");

        }
        formateurRepo.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
    	Formateur formateur = findById(id);
        if (formateur==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        formateurRepo.delete(formateur);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Override
    public List<Formateur> findAll() {

        return formateurRepo.findAll();
    }

    @Override
    public Formateur findById(Long id) {
    	Formateur formateur = formateurRepo.findById(id).orElse(null);
        return formateur;
    }
	

}
