package com.alex.websocketdemo.amqp;

import com.alex.websocketdemo.dto.UserIdDto;
import com.alex.websocketdemo.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatRequestProducer {

    private static final String EXCHANGE = "my-exchange";
    private static final String ROUTING_KEY = "cat-request";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void produceMessage(UserIdDto userIdDto) {
        try {
            String userIdDtoString = objectMapper.writeValueAsString(userIdDto);
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, userIdDtoString);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
