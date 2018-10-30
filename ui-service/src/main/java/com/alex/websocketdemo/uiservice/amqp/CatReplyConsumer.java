package com.alex.websocketdemo.uiservice.amqp;

import com.alex.websocketdemo.uiservice.dto.CatReplyDto;
import com.alex.websocketdemo.uiservice.dto.ImageDto;
import com.alex.websocketdemo.uiservice.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CatReplyConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RabbitListener(queues = "cat-reply-queue")
    public void consume(String catReplyDtoString) {
        try {
            CatReplyDto catReplyDto = objectMapper.readValue(catReplyDtoString, CatReplyDto.class);
            simpMessagingTemplate.convertAndSend("/topic/image/" + catReplyDto.getUuid() + "/reply", catReplyDtoString);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
