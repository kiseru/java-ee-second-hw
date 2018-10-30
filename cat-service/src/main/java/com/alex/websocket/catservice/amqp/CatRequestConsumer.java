package com.alex.websocket.catservice.amqp;

import com.alex.websocket.catservice.dto.CatDto;
import com.alex.websocket.catservice.dto.CatReplyDto;
import com.alex.websocket.catservice.dto.UserIdDto;
import com.alex.websocket.catservice.models.User;
import com.alex.websocket.catservice.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

@Component
public class CatRequestConsumer {

    private static final String CAT_REQUEST_URL = "https://api.thecatapi.com/v1/images/search";

    @Autowired
    private CatReplyProducer catReplyProducer;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @RabbitListener(queues = "cat-request-queue")
    public void consume(String userIdDtoString) {
        try {
            UserIdDto userIdDto = objectMapper.readValue(userIdDtoString, UserIdDto.class);
            CatDto[] body = restTemplate.getForEntity(CAT_REQUEST_URL, CatDto[].class).getBody();
            CatDto catDto = Arrays.stream(body)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
            User user = userService.findById(userIdDto.getUserId());
            user.setImageUrl(catDto.getUrl());
            userService.save(user);
            CatReplyDto catReplyDto = new CatReplyDto(userIdDto.getUserUuid(), user.getImageUrl());
            catReplyProducer.produce(catReplyDto);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
