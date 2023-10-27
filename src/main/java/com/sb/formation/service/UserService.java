package com.sb.formation.service;

import java.util.List;

import com.sb.formation.entities.User;
import com.sb.formation.reponses.MessageResponse;

public interface UserService {
    public MessageResponse save(User user);
    public MessageResponse update(User user);
    public MessageResponse delete(Long id);
    public List<User> findAll();
    public User findById(Long id);
}
