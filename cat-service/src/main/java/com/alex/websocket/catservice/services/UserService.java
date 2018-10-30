package com.alex.websocket.catservice.services;

import com.alex.websocket.catservice.models.User;
import com.alex.websocket.catservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
