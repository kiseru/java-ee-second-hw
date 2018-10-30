package com.alex.websocket.catservice.amqp;

import com.alex.websocket.catservice.dto.CatReplyDto;
import com.alex.websocket.catservice.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatReplyProducer {

    private static final String EXCHANGE = "my-exchange";
    private static final String ROUTING_KEY = "cat-reply";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void produce(CatReplyDto catReplyDto) {
        try {
            String catReplyDtoString = objectMapper.writeValueAsString(catReplyDto);
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, catReplyDtoString);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
