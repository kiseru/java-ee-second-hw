package com.alex.websocketdemo.services;

import com.alex.websocketdemo.models.User;
import com.alex.websocketdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
