package com.alex.websocketdemo.uiservice.controllers;

import com.alex.websocketdemo.uiservice.dto.UserDto;
import com.alex.websocketdemo.uiservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private UserService userService;

    @MessageMapping("/image/{uuid}")
    public void getImage(@DestinationVariable("uuid") String uuid,
                         String name) {
        UserDto userDto = new UserDto(name, uuid);
        userService.save(userDto);
    }
}
