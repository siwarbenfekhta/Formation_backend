package com.sb.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sb.formation.entities.Formation;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.FormationRepository;

@Service
public class FormationServiceImpl implements FormationService{
	
	@Autowired
	private FormationRepository formationRepo ;
    @Transactional
    @Override
    public MessageResponse save(Formation formation) {
        boolean existe = formationRepo.existsByTitre(formation.getTitre());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette formation existe déja !");
        }
        formationRepo.save(formation);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }


    @Transactional
    @Override
    public MessageResponse update(Formation formation) {
        boolean existe = formationRepo.existsById(formation.getIdFormation());
        if (!existe){
            boolean existe1 = formationRepo.existsByTitre(formation.getTitre());
            return new MessageResponse(false,"Echec !","Cette formation existe déja !");

        }
        formationRepo.save(formation);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
    	Formation formation = findById(id);
        if (formation==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        formationRepo.delete(formation);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Override
    public List<Formation> findAll() {

        return formationRepo.findAll();
    }

    @Override
    public Formation findById(Long id) {
    	Formation formation = formationRepo.findById(id).orElse(null);
        return formation;
    }


}
