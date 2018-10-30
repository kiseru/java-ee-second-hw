package com.alex.websocketdemo.amqp;

import com.alex.websocketdemo.dto.UserDto;
import com.alex.websocketdemo.dto.UserIdDto;
import com.alex.websocketdemo.models.User;
import com.alex.websocketdemo.services.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SignUpConsumer {

    @Autowired
    private CatRequestProducer catRequestProducer;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    @RabbitListener(queues = "sign-up-queue")
    public void consume(String userDtoString) {
        try {
            UserDto userDto = objectMapper.readValue(userDtoString, UserDto.class);
            User user = User.builder()
                    .name(userDto.getName())
                    .build();
            userService.save(user);
            UserIdDto userIdDto = new UserIdDto(user.getId(), userDto.getUuid());
            catRequestProducer.produceMessage(userIdDto);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
