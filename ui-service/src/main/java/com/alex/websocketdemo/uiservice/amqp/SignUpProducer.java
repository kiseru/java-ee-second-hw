package com.alex.websocketdemo.uiservice.amqp;

import com.alex.websocketdemo.uiservice.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpProducer {

    private static final String EXCHANGE = "my-exchange";
    private static final String ROUTING_KEY = "sign-up";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void produce(UserDto userDto) {
        try {
            String userDtoString = objectMapper.writeValueAsString(userDto);
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, userDtoString);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
