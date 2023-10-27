package com.sb.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Profil;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.ProfilRepository;

@Service
public class ProfilServiceImpl implements ProfilService{
	
	@Autowired
	ProfilRepository profilRepo ;
	
	 @Transactional
	    @Override
		public MessageResponse save(Profil profil) {
	        boolean existe = profilRepo.existsByLibelle(profil.getLibelle());
	        if (existe){
	            return new MessageResponse(false,"Echec !","Ce profil existe déja !");
	        }
	        profilRepo.save(profil);
	        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	    }


	    @Transactional
	    @Override
	    public MessageResponse update(Profil profil) {
	        boolean existe = profilRepo.existsById(profil.getIdProfil());
	        if (!existe){
	            boolean existe1 = profilRepo.existsByLibelle(profil.getLibelle());
	            return new MessageResponse(false,"Echec !","Cette domaine existe déja !");

	        }
	        profilRepo.save(profil);
	        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	    }

	    @Transactional
	    @Override
	    public MessageResponse delete(Long id) {
	    	Profil profil = findById(id);
	        if (profil==null){
	            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
	        }
	        profilRepo.delete(profil);
	        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	    }

	    @Override
	    public List<Profil> findAll() {

	        return profilRepo.findAll();
	    }

	    @Override
	    public Profil findById(Long id) {
	    	Profil profil = profilRepo.findById(id).orElse(null);
	        return  profil;
	    }

}
