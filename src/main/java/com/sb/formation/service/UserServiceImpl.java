package com.sb.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.formation.entities.User;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepo ;
	@Transactional
    @Override
    public MessageResponse save(User user) {
        boolean existe = userRepo.existsByUsername(user.getUsername());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette user existe déja !");
        }
        userRepo.save(user);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }


    @Transactional
    @Override
    public MessageResponse update(User user) {
        boolean existe = userRepo.existsById(user.getId());
        if (!existe){
            boolean existe1 = userRepo.existsByUsername(user.getUsername());
            return new MessageResponse(false,"Echec !","Cette user existe déja !");

        }
        userRepo.save(user);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        User user = findById(id);
        if (user==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        userRepo.delete(user);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Override
    public List<User> findAll() {

        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        User user = userRepo.findById(id).orElse(null);
        return user;
    }

}
