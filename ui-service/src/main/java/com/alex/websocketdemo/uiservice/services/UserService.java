package com.alex.websocketdemo.uiservice.services;

import com.alex.websocketdemo.uiservice.amqp.SignUpProducer;
import com.alex.websocketdemo.uiservice.dto.UserDto;
import com.alex.websocketdemo.uiservice.models.User;
import com.alex.websocketdemo.uiservice.repositories.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private SignUpProducer signUpProducer;

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(UserDto userDto) {
        signUpProducer.produce(userDto);
    }
}
